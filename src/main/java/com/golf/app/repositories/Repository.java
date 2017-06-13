package com.golf.app.repositories;

import java.util.List;

public interface Repository<KEY,TYPE> {
	
	   TYPE add(TYPE obj);
	   TYPE update(TYPE obj);
	   void update(List<TYPE> obj);
	   TYPE read(KEY key);
	   void delete(KEY key);
}
