package com.golf.app.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golf.app.domain.Tool;

@Component("ToolRepository")
public class ToolRepository implements Repository<String,Tool> {
	
	private Map<String,Tool>dataSource;

	public ToolRepository()
	{
		this.dataSource=new HashMap<>();
	}
	
	@Override
	public Tool add(final Tool obj) {
		dataSource.put(obj.getId(),obj);
		return dataSource.get(obj.getId());
	}

	@Override
	public Tool update(final Tool obj) {
		dataSource.put(obj.getId(),obj);
		return dataSource.get(obj.getId());
	}

	@Override
	public void update(List<Tool> list) {
		for (Tool tool:list)
		{
			dataSource.put(tool.getId(), tool);
		}
		
	}

	@Override
	public Tool read(String key) {
		// TODO Auto-generated method stub
		return dataSource.get(key);
	}

	@Override
	public void delete(String key) {
		dataSource.remove(dataSource.get(key));
		
	}
	
}
