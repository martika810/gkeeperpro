var HomePage = function() { 
      this.taskTab = element(by.id('tabTask'));
      this.taskPanel = element(by.id('taskPanel'));
      this.firstItem = element.all(by.css('.collection-item.collapsible-header')).first();
};

describe('taskController', function() {  
 
  it('should open task with one task',function(){
        
      browser.get('/ini');
      var homePage = new HomePage();
      
      //clickar en tareas y comprobar que el panel esta visible
      homePage.taskTab.click();
      expect(homePage.taskPanel.isDisplayed()).toBe(true);
      var taskList = element.all(by.repeater('task in taskList'));
      expect(taskList.count()).toEqual(3);
      
      //clickar en el primer elemento y comprobar que se abrio el panel
      let firstItem = $$('.collection-item #task_id').first();
      expect($$('.collapsible-body').first().isDisplayed()).toBe(false);
      firstItem.click();
      expect($$('.collapsible-body').first().isDisplayed()).toBe(true);
      
      var titleInsidePanel = $$('.collection-item.active .collapsible-body #task_title');
      var titleValue = titleInsidePanel.getAttribute('value').then(function(value){
	  console.log(this);
	  return value;
      });
     
      
  });
  
});
