package com.Shubh_Vivah.Shubh_Vivah.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showloginpage()
	{
		
		return "login";
	}

}

