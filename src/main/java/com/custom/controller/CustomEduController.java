package com.custom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomEduController {

	@GetMapping("/main")
	public String main() {
		return "main";
	}
}
