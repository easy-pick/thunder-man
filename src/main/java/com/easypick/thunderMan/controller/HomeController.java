package com.easypick.thunderMan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// /으로 접근할경우 home으로 이동
	@GetMapping({ "/", "/home" })
	public String signin() {
		return "home";
	}
}