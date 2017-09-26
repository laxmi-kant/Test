package signupApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Welcome {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String doSomething() {

		return "index.html";
		}
	
	@RequestMapping(value="/signIn.html", method=RequestMethod.GET)
	public String getLogin() {

		return "signIn.html";
		}
	
	@RequestMapping(value="/reset.html", method=RequestMethod.GET)
	public String getForgot() {

		return "reset.html";
		}
	@RequestMapping(value="/app.js", method=RequestMethod.GET)
	public String getapp() {
		return "app.js";
		}
	@RequestMapping(value="/success.html", method=RequestMethod.GET)
	public String getSuccess() {
		return "success.html";
		}
	@RequestMapping(value="/Welcome.html", method=RequestMethod.GET)
	public String getWelcome() {
		return "Welcome.html";
		}
}
