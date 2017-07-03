console.log("Hello employee-controller");
var employeeApp = angular.module('employeeApp',[]);
employeeApp.factory("employeeService",['$rootScope','$http','$q',function($rootScope,$http,$q){
    
    function loadTaskForAnEmployee(taskGroupByEmployeeMap,taskMap){
	var taskByEmployee = {};
	    for (var employeeId in taskGroupByEmployeeMap ) {
		 var taskList = [];
		 taskGroupByEmployeeMap[employeeId].forEach(function(entry){
		     taskList.push(taskMap[entry]);
		 });
		 
		 taskByEmployee[employeeId]=taskList;
	    }
	    return taskByEmployee;
    }
    function loadEmployee(){
	var employeeResponse = {};
	$http.get("/employee").then(function(response){
	    $rootScope.employeeMap= response.data;
	});
	
		
    }
    return{
	loadData:function(){
	    var taskGroupByEmployeeMap = {};
	    //var employeeRequest = $http.get("/employee");
	    var taskGroupByEmployeeRequest = $http.get("task/by_employee");
	    //var toolRequest = $http.get("/tool");
	    var taskRequest = $http.get("/task");
	    
	    $q.all([taskRequest,taskGroupByEmployeeRequest])
	    	.then(function(response){
	    	    $('.collapsible').collapsible();
	    	    var taskMap = response[0].data;
	    	   // var employeeMap = response[1].data;
	    	   // taskGroupByEmployeeMap = response[1].data;
	    	   // var toolMap = response[3].data;
	    	  $rootScope.taskGroupByEmployeeMap=loadTaskForAnEmployee(response[1].data,taskMap);
	    	   
	    	});
	    
	    
	},
	loadEmployee:function(){
	    loadEmployee();
	}
    }
}]);

employeeApp.controller('employeeController',['$scope','employeeService',function($scope,employeeService){
	
	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable employeeList
    
       $scope.save = function(){
	    console.log("Click save");
       }
       employeeService.loadEmployee();
       employeeService.loadData();
       
	
		
}]);


angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("employeePanel"), ['employeeApp']);
});
