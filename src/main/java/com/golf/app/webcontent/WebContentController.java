package com.golf.app.webcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebContentController {

	@RequestMapping("/ini")
	public String page() {
		return "html/homepage";
	}

	@RequestMapping("/task_container")
	public String taskcontainer() {
		return "html/task_container";
	}

}
