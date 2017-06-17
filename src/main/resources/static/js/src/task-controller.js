console.log("Hello task-controller");
var taskApp = angular.module('taskApp',[]);
taskApp.controller('taskController',function($scope,$http){
	
	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable taskList
	$http.get("/task")
			.then(function(response){
				$scope.taskList = response.data
				
				//cuando haya un cambio en la variable "taskList", entonces se ejecuta estaa funcion
				$scope.$watch('taskList', function() {
					 $('.collapsible').collapsible();
				}, true);
			});
		
});


angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("taskPanel"), ['taskApp']);
});
