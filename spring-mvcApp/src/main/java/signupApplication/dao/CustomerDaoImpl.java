package signupApplication.dao;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import signupApplication.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory factory;

	public Session getSession() {
		return this.factory.getCurrentSession();
	}

	public boolean save(Customer cust) {
		getSession().save(cust);
		return true;
	}

	public Customer signIn(String email, String password) {
		System.out.println(email + "  " + password);
		Customer criteria = (Customer) getSession().createCriteria(Customer.class)
				.add(Restrictions.ilike("email", email)).add(Restrictions.ilike("password", password)).uniqueResult();
		System.out.println(criteria.toString());

		return criteria;
	}

	public Boolean forgotPassword(String email, String password) {

		Customer cust = (Customer) getSession().createCriteria(Customer.class).add(Restrictions.ilike("email", email))
				.uniqueResult();
		System.out.println(cust.toString());
		Customer newCust = new Customer();
		newCust.setCustomerId(cust.getCustomerId());
		cust.setPassword(password);
		getSession().update(cust);
		return true;
	}

}
