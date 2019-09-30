package com.myprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	
	@Autowired
	private TaskProcessor tp;
	
	@RequestMapping(path="/toll",method=RequestMethod.POST)
	public @ResponseBody String postToll(@RequestBody String input)
	{
		tp.publishMessage(input);
		
		return "success";
	}
}
