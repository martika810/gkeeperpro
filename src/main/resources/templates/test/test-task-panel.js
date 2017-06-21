var mockModule = require('./mock-backend'); 
var HomePage = function() { 
      this.taskTab = element(by.id('tabTask'));
      this.taskPanel = element(by.id('taskPanel'));
};
describe('MockingHttp', function() {
  beforeEach(function() {
      var ptor = protractor.getInstance();
      ptor.addMockModule('httpBackendMock', mockModule.httpBackendMock); 
      var homeUrl = 'http://localhost:8090/ini';
     
      browser.get(homeUrl);
//    browser.addMockModule('httpMocker', function() {
//        angular.module('httpMocker', ['ngMockE2E'])
//      	.run(function($httpBackend) {
//      	    $httpBackend.whenGET(
//      	    'http://localhost:8090/task')
//      	    .respond([  
//      	    {  
//               "id":"005eda6f-500e-4c01-8044-6c55bfcdcafd",
//               "title":"Task3",
//               "description":"Description task3",
//               "personAssignedId":"UNASSIGNED"
//             }])
//      	 })
//    })
  });
  it('should open task with one task',function(){
      
      var homePage = new HomePage();
      homePage.taskTab.click();
      expect(homePage.taskPanel.isDisplayed()).toBe(true);
      var taskList = element.all(by.repeater('task in taskList'));
      expect(taskList.count()).toEqual(3);
      //browser.pause();
  });
});
