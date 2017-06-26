var HomePage = function() { 
      this.taskTab = element(by.id('tabTask'));
      this.taskPanel = element(by.id('taskPanel'));
      this.firstItem = element.all(by.css('.collection-item.collapsible-header')).first();
};

describe('taskController', function() {  
    
  beforeEach(function(){
     
  });
 
  it('Clickar en tareas deberia listar las tareas',function(){

      browser.get('/ini');
      var homePage = new HomePage();
        
      //clickar en tareas y comprobar que el panel esta visible
      homePage.taskTab.click();
      expect(homePage.taskPanel.isDisplayed()).toBe(true);
      var taskList = element.all(by.repeater('task in taskList'));
      expect(taskList.count()).toEqual(3);
          
  });
  it('Clickar en la primera tarea deberia expandir un panel con detalles',function(){

      //clickar en el primer elemento y comprobar que se abrio el panel
      let firstItem = $$('.collection-item #task_id').first();
      expect($$('.collapsible-body').first().isDisplayed()).toBe(false); //comprueba k el panel estaba cerrado
      firstItem.click();
      expect($$('.collapsible-body').first().isDisplayed()).toBe(true); //despues del click se abre
      
      var titleInsidePanel = element(by.css('.collection-item.active .collapsible-body #task_title'));
      expect(titleInsidePanel.getAttribute('value')).toBe('Task1');
      
      var descriptionInsidePanel =element(by.css('.collection-item.active .collapsible-body #task_description'));
      expect(descriptionInsidePanel.getText()).toBe('Description task1');
    
      var doneButton =  element(by.css('.collection-item.active .collapsible-body .btn'));
      expect(doneButton.isDisplayed()).toBe(true);
           
  });
  
  it('Comprobar que los empleados asignados a la tarea se muestran',function(){
      var employeesAssigned = element.all(by.css('.collection-item.active .collapsible-body #task_employee span.chip'));
      expect(employeesAssigned.count()).toBe(2);
      
      
      var firstElement = element.all(by.css('.collection-item.active .collapsible-body #task_employee span.chip')).first();
      var arrayOfEmployees = firstElement.getText().then(function(text){
	  var employeeName = text.split('\n')[0];
	  expect(employeeName).toBe('Juan Ortega Rubio');
      });
           
  });
  
});
