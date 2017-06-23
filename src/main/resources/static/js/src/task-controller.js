console.log("Hello task-controller");
var taskApp = angular.module('taskApp',[]);
taskApp.controller('taskController',function($scope,$http){
    	
	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable taskList
    	$scope.populatePanel = function(){
    	    $http.get("/task")
    	    .then(function(response){
    		$scope.taskList = response.data
			
		//cuando haya un cambio en la variable "taskList", entonces se ejecuta estaa funcion
		$scope.$watch('taskList', function() {
		    $('.collapsible').collapsible();
		}, true);
    	    });
    	    $http.get("/employee")
    	    .then(function(response){
    		$scope.employeeList = response.data
    		  $http.get("/tool")
    	    .then(function(response){
    		$scope.toolList = response.data
    	    });	
    	}
    	$scope.populatePanel();
	
	$scope.readData = function(){
		var taskToSave = new Object();
		taskToSave.id = $('.collection-item.active #task_id').attr('value')
		taskToSave.title = $('.collection-item.active #task_title').val();
		taskToSave.description = $('.collection-item.active #task_description').val();
		taskToSave.personAssignedId = $('.collection-item.active #task_employee').val().toString(); 
		taskToSave.toolAssignedId = $('.collection-item.active #task_tool').val().toString();  
		
		return taskToSave;
	}
	
	$scope.save = function(){
	   
		var taskToSave = $scope.readData();
		var taskInJson = taskToSave;
		
		$http.put('/task',taskInJson)
			.success(function (data, status, headers) {
			    console.log('sucess');
			    $scope.populatePanel();
			})
			.error(function (data, status, header, config) {
			    console.log('error');
			});
		}
	

});

angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("taskPanel"), ['taskApp']);
});
