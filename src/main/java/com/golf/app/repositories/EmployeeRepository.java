package com.golf.app.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golf.app.domain.Employee;

@Component("EmployeeRepository")//le dice a Springboot que cree un objeto de ese tipo
public class EmployeeRepository implements Repository<String,Employee>{
	private Map<String,Employee> dataSource;
	
	public EmployeeRepository ()
	{
	this.dataSource = new HashMap<>();
	}
	
	
	@Override
	public Employee add(Employee obj) {
		dataSource.put(obj.getId(), obj);
		return dataSource.get(obj.getId());
	}

	@Override
	public Employee update(Employee obj) {
		dataSource.put(obj.getId(), obj);
		return dataSource.get(obj.getId());
	}

	@Override
	public void update(List<Employee> list)
	{
		for(Employee employee:list )
		{
			dataSource.put(employee.getId(), employee);			
		}
	}

	@Override
	public Employee read(String key) {
		return dataSource.get(key);
	}

	@Override
	public void delete(String key) {
		dataSource.remove(dataSource.get(key));
		
	}
	
}