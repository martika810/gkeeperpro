package com.golf.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.golf.app.domain.Mutable;
import com.golf.app.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import com.golf.app.domain.Tool;
import com.golf.app.domain.ToolMutable;
import com.golf.app.repositories.ToolRepository;

@Controller
@RequestMapping("/tool")
public class ToolController implements com.golf.app.controllers.Controller<ToolMutable>
{

	private ToolRepository repository;
	
	@Autowired
	public ToolController(ToolRepository repository)
	{
		this.repository=repository;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String,ToolMutable>> getAll() {
		Map<String,Tool> tools=repository.readAll();

		Map<String,ToolMutable> toolResponse=convertToApi(tools);
		return ResponseEntity.status(HttpStatus.OK).body(toolResponse);
	}

	@Override
	public ResponseEntity<ToolMutable> update(ToolMutable obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ToolMutable> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ToolMutable> create(ToolMutable obj) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, ToolMutable> convertToApi(final Map<String, Tool> map) {
		Map<String, ToolMutable> mutableMap = new HashMap<>();
		map.keySet().stream().forEach(key -> {
			ToolMutable taskMutable =  map.get(key).mutable();
			mutableMap.put(key, taskMutable);

		});
		return mutableMap;
	}
}
