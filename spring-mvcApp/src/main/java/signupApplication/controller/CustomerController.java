package signupApplication.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import signupApplication.model.Customer;
import signupApplication.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity <String> signUp(@RequestBody Customer cust) {
		;
		System.out.println(cust.toString());
		JSONObject json = new JSONObject();
		if(customerService.save(cust)){
			json.put("status", "success");
		};
		return new ResponseEntity<String>(json.toString(),HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer signIn(@RequestParam("email") String email, @RequestParam(name = "password") String password) {
		System.out.println(email + " " + password);
		return customerService.signIn(email, password);
	}

	@RequestMapping(value = "/forgotpass", method = RequestMethod.POST)
	
	public @ResponseBody ResponseEntity <String> forgotPassword(@RequestParam("email") String email,
			@RequestParam(name = "password") String password) {
		System.out.println(email + " " + password);
		JSONObject json = new JSONObject();
		if(customerService.forgotPassword(email, password)){
			json.put("status", "success");
		};
		
		return new ResponseEntity<String>(json.toString(),HttpStatus.OK);
	}
}
