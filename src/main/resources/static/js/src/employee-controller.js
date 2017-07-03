console.log("Hello employee-controller");
var employeeApp = angular.module('employeeApp',[]);

employeeApp.controller('employeeController',['$scope','$http','$q',function($scope,$http,$q){
    
    	$scope.loadTaskForAnEmployee = function(taskGroupByEmployeeMap,taskMap){
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
	
       $scope.loadData = function(){
	    
	    var employeeRequest = $http.get("/employee");
	    var taskGroupByEmployeeRequest = $http.get("task/by_employee");
	    var toolRequest = $http.get("/tool");
	    var taskRequest = $http.get("/task");
	    //NOTA: el $q es para ke la parte del then se ejecute cuando 
	    //se hayan recibido la respuesta a todas las requests que hay arriba
	    $q.all([taskRequest,taskGroupByEmployeeRequest,employeeRequest,toolRequest])
	    	.then(function(response){
	    	    $('.collapsible').collapsible();
	    	    $scope.taskMap = response[0].data;
	    	    $scope.employeeMap = response[2].data;
	    	    var taskGroupByEmployeeMap = response[1].data;
	    	    $scope.taskGroupByEmployeeMap=$scope.loadTaskForAnEmployee(taskGroupByEmployeeMap,$scope.taskMap);
	    	    $scope.toolList = response[3].data;
	    	 
	    	   
	    	});
	    
       }
       $scope.save = function(){
	    console.log("Click save");
       }
       
       $scope.loadData();
       
	
		
}]);


angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("employeePanel"), ['employeeApp']);
});
