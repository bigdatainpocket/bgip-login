package com.bgip.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgip.model.User;
import com.bgip.service.UserServiceImpl;

@RestController
@RequestMapping("/bgip")
public class LoginController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String userRegistration(){
		
		return " Hi aLL";
		
	}
	
	
	
//	@Secured({"ROLE_ADMIN"})
//    @RequestMapping("/resource")
//    public Map<String, Object> home(@AuthenticationPrincipal User userDetails) {
//        Client client = users.findOne("{#: #}", Client.USERNAME, userDetails.getUsername()).as(Client.class);
//        Map<String, Object> model = new HashMap<>();
//        model.put("roles", client.getRoles());
//        return model;
//    }
//	
//	
	
	
	
	
	
}
