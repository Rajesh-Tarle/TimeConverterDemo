package com.timeconverter.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeconverter.services.TimeConverterService;

@Controller
public class TimeConverterController {	
	
	@Autowired
	private TimeConverterService timeConverterService;
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("Test Home "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE));
		String currentTimeInWords = timeConverterService.getCurrentTimeInWords(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),Calendar.getInstance().get(Calendar.MINUTE));
		model.addAttribute("currentTimeInWords", currentTimeInWords);
		return "home";
	}

}
