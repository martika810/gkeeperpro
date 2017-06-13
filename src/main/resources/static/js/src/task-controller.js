console.log("Hello offer");
var taskApp = angular.module('taskApp',[]);
taskApp.controller('taskController',function($scope,$http){
	
	$http.get("/task")
			.then(function(response){
				$scope.taskList = response.data
			});

	//$(document).ready(function(){
        $('.collapsible').collapsible();
        // Open
        $('.collapsible').collapsible('open', 0);

        // Close
        $('.collapsible').collapsible('close', 0);
      //});
});