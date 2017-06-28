package com.golf.app.webcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebContentController {

	@RequestMapping("/directive")
	public String directive() {
		return "html/test_directive";
	}

	@RequestMapping("/ini")
	public String page() {
		return "html/homepage";
	}

	@RequestMapping("/parr")
	public String parr() {
		return "html/parr";
	}

}
