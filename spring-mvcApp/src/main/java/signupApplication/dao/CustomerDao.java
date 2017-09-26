package signupApplication.dao;

import signupApplication.model.Customer;

public interface CustomerDao {
boolean  save(Customer cust);
Customer  signIn(String email,String password);
public Boolean   forgotPassword(String email,String password);
}
