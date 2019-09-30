package com.myprojects;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	OAuth2ClientContext oauthcontext;
	
	@Autowired
	OAuth2RestTemplate template;

	@RequestMapping("/home")
	public String loadHome() {
		System.err.println(oauthcontext.getAccessToken());
		return "home";
	}

	@RequestMapping("/callback")
	public String callback() {
		return "callback";
	}

	@RequestMapping("/chome2")
	public String loadHome2() {
		return "home2";
	}

	
	@RequestMapping("/report")
	public String getReport(Model model)
	{
		ResponseEntity<ArrayList<TollUsage>> tolls = template.exchange("http://localhost:8098/services/tolldata", HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<TollUsage>>(){});
	
		model.addAttribute("tolls", tolls.getBody());
		return "report";
	}

	
public static class TollUsage {
		
		public String Id;
		public String stationId;
		public String licensePlate;
		public String timestamp;
		
		public TollUsage() {}
		
		public TollUsage(String id, String stationid, String licenseplate, String timestamp){
			this.Id = id;
			this.stationId = stationid;
			this.licensePlate = licenseplate;
			this.timestamp = timestamp;
		}
		
		
	}

}
