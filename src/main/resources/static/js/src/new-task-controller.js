console.log("Hello new-task-controller");
var newTaskApp = angular.module('newTaskApp',[]);

newTaskApp.controller('newTaskController',function($scope,$http){
    
    $scope.initializeNewTask = function(){
	    $scope.newTask = new Object();
	}
	
	$scope.createNewTask = function(){
	    console.log('save received!')
//	    task['title'] = $('#newTaskContainer #task_title').val();
//	    task['description'] = $('#newTaskContainer ##task_description').val();
//	    $http.post('/task',task)
//	    .success(function (data, status, headers) {
//	        console.log('sucess');
//	        $scope.populatePanel();
//	        $('#newTaskContainer').hide();
//	    })
//	    .error(function (data, status, header, config) {
//	        console.log('error');
//	    });
	    
	}
	
	$scope.populatePanel = function(){
	    $http.get("/employee")
	        .then(function(response){
		        $scope.employeeMap = response.data
	        });
	    $http.get("/tool")
	            .then(function(response){
		            $scope.toolList = response.data
		            $scope.toolMap = $scope.createToolMap();
	            });
	}
	
	$scope.populatePanel();
	$scope.assignEmployee = function(task){
    	    var selectedEmployee = $('.collection-item.active #employee_dropdown').find(':selected').val();
    	    var isAlreadyAssigned = ($.inArray(selectedEmployee, task.personAssignedIds)!==-1);
    	    var isEmptyEmployee = selectedEmployee == "";
    	    if(!isAlreadyAssigned && !isEmptyEmployee){
    	       task.personAssignedIds.push(selectedEmployee);
    		
    	    }
    	    
    	}

    	$scope.unassignEmployee = function(task,employeeId){
    	    console.log("Unassigned")
    	    task.personAssignedIds = $.grep( task.personAssignedIds, function(id){ 
    		 return id != employeeId;
    	    });
    	}
    
});

angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("newTaskPanel"), ['newTaskApp']);
	
});