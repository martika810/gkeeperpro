package com.golf.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public ResponseEntity<List<ToolMutable>> getAll() {
		List<Tool> tools=new ArrayList<>();
		tools.add(Tool.of("Corta cesped", "En uso", "Imagen"));
		tools.add(Tool.of("Sopladora", "Disponible", "Imagen"));
		tools.add(Tool.of("Fumigadora", "Disponible", "Imagen"));
		tools.add(Tool.of("Segadora", "Disponible", "Imagen"));
		repository.update(tools);
		List<ToolMutable> toolResponse=convertToApi(tools);
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
	
	private ToolMutable convertToApi(final Tool tool){
		return tool.mutable();
	}
	
	private List<ToolMutable> convertToApi(final List<Tool> toolList){
		return toolList.stream().map(t ->this.convertToApi(t)).collect(Collectors.toList());
	}
}
