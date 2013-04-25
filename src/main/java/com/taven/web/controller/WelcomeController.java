package com.taven.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping
	public String mainPage() {

		return "help";

	}

	@RequestMapping(params = "method=mainPage")
	public String mainPage(HttpServletRequest request, HttpServletResponse response) {

		return "welcome";

	}

}
