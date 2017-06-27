package com.golf.app.controllers;

import java.util.HashMap;
import java.util.Map;

import com.golf.app.domain.Mutable;
import com.golf.app.domain.Task;
import org.springframework.http.ResponseEntity;

public interface Controller<TYPE> {
	ResponseEntity<Map<String, TYPE>> getAll();
	ResponseEntity<TYPE> update(TYPE obj);
	ResponseEntity<TYPE> delete(String id);
	ResponseEntity<TYPE> create(TYPE obj);

}
