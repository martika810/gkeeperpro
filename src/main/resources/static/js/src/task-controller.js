console.log("Hello task-controller");
var taskApp = angular.module('taskApp',[]);

taskApp.controller('taskController',function($scope,$http){
    	
    	//Crea un mapa que tiene como key el id del empleado y el valor(con nombre,apellidos,etc)
	$scope.createEmployeeMap = function(){
	    var employeeMap = new Object();
	    $.each($scope.employeeList,function(index,value){
		employeeMap[value.id] = value;
	    });
	    return employeeMap;
	}


	//esto lo he puesto así, bien separadito, para que se vea...lo añadí por si fuera ese el error, pensando que faltaba
	//pero tampoco hace falta deja tanto espeacio, con tres espacios vale! XD
	

	$scope.createToolMap = function(){
	    var toolMap = new Object();
	    $.each($scope.toolList,function(index,value){
		    toolMap[value.id] = value;
	    });
	    return toolMap;
	}
	

	$scope.selectTask = function(selectedTask){
	   $scope.selectedTask = selectedTask;
	}
	
	$scope.activeModal = function(){
	 // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
		$('.modal').modal();
	}
	
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
    		        $scope.employeeMap = response.data
    	        });
    	    $http.get("/tool")
 	            .then(function(response){
 		            $scope.toolList = response.data
 		            $scope.toolMap = $scope.createToolMap();
 	            });
    	    }
    	$scope.populatePanel();
	
    	$scope.assignEmployee = function(){
    	    var selectedEmployee = $('.collection-item.active #employee_dropdown').find(':selected').val();
    	    var isAlreadyAssigned = ($.inArray(selectedEmployee, $scope.selectedTask.personAssignedIds)!==-1);
    	    var isEmptyEmployee = selectedEmployee == "";
    	    if(!isAlreadyAssigned && !isEmptyEmployee){
    	       $scope.selectedTask.personAssignedIds.push(selectedEmployee);
    		
    	    }
    	    //TODO seleccionar la opcion asignar
    	}

    	$scope.unassignEmployee = function(employeeId){
    	    console.log("Unassigned")
    	    $scope.selectedTask.personAssignedIds = $.grep( $scope.selectedTask.personAssignedIds, function(id){ 
    		 return id != employeeId;
    	    });
    	}

    	$scope.assignTool = function(){
    	    var selectedTool = $('.collection-item.active #tool_dropdown').find(':selected').val();
    	    var isAlreadyAssigned = ($.inArray(selectedTool, $scope.selectedTask.toolAssignedIds)!==-1);
    	    var isEmptyTool = selectedTool == "";
    	    if(!isAlreadyAssigned && !isEmptyTool){
    		    $scope.selectedTask.toolAssignedIds.push(selectedTool);
    		
    	    }
    	    //TODO seleccionar la opcion asignar
    	}
    	$scope.unassignTool = function(toolId){
    	    console.log("Unassigned")
    	    $scope.selectedTask.toolAssignedIds = $.grep( $scope.selectedTask.toolAssignedIds, function(id){ 
    		 return id != toolId;
    	    });
    	}
	
	    $scope.save = function(){
	   
		    var taskToSave = $scope.selectedTask
		    $http.put('/task',taskToSave)
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
