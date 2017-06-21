exports.httpBackendMock = function() {
    angular.module('httpBackendMock', ['taskApp', 'ngMockE2E'])
    .run(function($httpBackend) {
        console.log('Test platform bootstrapping');  
         
        $httpBackend.whenGET('/task').respond([{  
            "id":"005eda6f-500e-4c01-8044-6c55bfcdcafd",
            "title":"Task3",
            "description":"Description task3",
            "personAssignedId":"UNASSIGNED"
        }]);        
//        $httpBackend.whenGET('/events/' + sampleEventId).respond(sampleEvent);
//        $httpBackend.whenGET('/login').passThrough();
//        $httpBackend.whenGET(/partials\/.*/).passThrough();        
//        $httpBackend.whenPOST('/events').respond(function(method, url, data) {
//            data._id = 123456789;
//            return [200, angular.toJson(data), {}];
//        });
//        $httpBackend.whenDELETE('/events/' + sampleEventId).respond(function(method, url, data) {
//            return [200, {
//                delete: sampleEvent
//            }, {}];
//        });
        console.log('Test platform bootstrapping ... done');
    });
}