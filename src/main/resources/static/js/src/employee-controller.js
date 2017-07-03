console.log("Hello employee-controller");
var employeeApp = angular.module('employeeApp',[]);

employeeApp.service('employeeService',function($scope,$http,$q){
    return{
	loadTaskForAnEmployee:function(taskGroupByEmployeeMap,taskMap){
	    var taskByEmployee = {};
	    for (var employeeId in taskGroupByEmployeeMap ) {
		 var taskList = [];
		 taskGroupByEmployeeMap[employeeId].forEach(function(entry){
		     taskList.push(taskMap[entry]);
		 });
		 taskList;
		 taskByEmployee[employeeId]=taskList;
	    }
	    return taskByEmployee;
	},
        loadData:function(){
  	  var taskRequest = $http.get("/task")
  	   var employeeRequest = $http.get("/employee");
  	   var taskBrupByEmployeeRequest =  $http.get("task/by_employee");
  	   var toolRequest = $http.get("/tool");
  	   $q.all([taskRequest,employeeRequest,taskBrupByEmployeeRequest,toolRequest])
  	   .then(function(response){
  	       $('.collapsible').collapsible();
  	       $scope.taskMap = response[0].data;
  	       $scope.employeeMap = response[1].data;
  	       $scope.taskGroupByEmployeeMap = response[2].data;
  	       $scope.toolMap = response[3].data;
               $scope.taskGroupByEmployeeMap = $scope.loadTaskForAnEmployee($scope.taskGroupByEmployeeMap,$scope.taskMap);
  	       
  	   });
        }
    } 
});
employeeApp.controller('employeeController',function(employeeService){
	
	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable employeeList
    
       $scope.save = function(){
	    console.log("Click save");
	}
	employeeService.loadData();
		
});




angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("employeePanel"), ['employeeApp']);
});
