package signupApplication.service;

import signupApplication.model.Customer;

public interface CustomerService {
	Boolean  save(Customer cust);
		Customer  signIn(String email,String password);
		public Boolean   forgotPassword(String email,String password);
}
