package com.golf.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface Controller<TYPE> {
	ResponseEntity<List<TYPE>> getAll();
	ResponseEntity<TYPE> update(TYPE obj);
	ResponseEntity<TYPE> delete(String id);
	ResponseEntity<TYPE> create(TYPE obj);

}
