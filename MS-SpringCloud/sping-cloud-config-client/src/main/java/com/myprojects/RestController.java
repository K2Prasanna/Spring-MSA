package com.myprojects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RestController {
	
	@Value("${rate}")
	String rate;
	
	@Value("${lanecount}")
	String laneCount;
	
	@Value("${tollstart}")
	String tollStart;
	
	@Value("${connectstring}")
	String connectstring;

	@RequestMapping("/rate")
	public String getRate(Model m)
	{
		m.addAttribute("rateamount",rate);
		m.addAttribute("lanes",laneCount);
		m.addAttribute("tollstart",tollStart);
		m.addAttribute("connstring",connectstring);
		
		return "rateView";
	}
}
