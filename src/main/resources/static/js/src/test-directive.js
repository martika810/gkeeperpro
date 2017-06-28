console.log("Hello directives");
var direcApp = angular.module('directiveApp',[]);

direcApp.controller('directiveController',function($scope,$http){
    $scope.populate = function(){
	$http.get('/task')
    	.then(function(response){
    	    $scope.taskList = response.data;
    	});
    };
    $scope.populate();
        
});
direcApp.directive('testDirective',function(){
    return {
        template : angular.element('parr.html')
    };
    
});

angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("directivePanel"), ['directiveApp']);
});