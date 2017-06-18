console.log("Hello employee-controller");
var employeeApp = angular.module('employeeApp',[]);
employeeApp.controller('employeeController',function($scope,$http){
	
	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable employeeList
	$http.get("/employee")
			.then(function(response){
				$scope.employeeList = response.data
				
				//cuando haya un cambio en la variable "employeeList", entonces se ejecuta estaa funcion
				$scope.$watch('employeeList', function() {
					 $('.collapsible').collapsible();
				}, true);
			});
		
});


angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("employeePanel"), ['employeeApp']);
});
