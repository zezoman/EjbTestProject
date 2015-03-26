package test;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Stateless Session bean to save and/or list all contacts<br/>
 * We are using Java EE 6 Web Profile, so we don't need EJB Project to create Stateless Session Beans!<br>
 * This is a CMT (Again thanks to Apache TomEE, It CAN make JTA data-sources unlike plain Apache Tomcat which is just a Servlet Container)
 */
@Stateless
@LocalBean
public class ContactService {
	
	@PersistenceContext(unitName = "TestUnit")
	private EntityManager em;

	public ContactService() {
		System.out.println("Instance created for Contact Service");
	}

	/**
	 * Method to create new record using provided arguments<br/>
	 * TransactionAttribute for this method is REQUIRED (default)
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phone
	 */
	public void save(String firstName, String lastName, String phone) {
		Contact cn = new Contact();
		cn.setFirstName(firstName);
		cn.setLastName(lastName);
		cn.setPhoneNo(phone);
		em.persist(cn);
		System.out.println("Record saved");
	}

	/**
	 * Method to load all contacts from the database
	 * 
	 * @return List of all contacts
	 */
	public List<Contact> loadAll() {
		List<Contact> list = null;
		TypedQuery<Contact> q = em.createNamedQuery("Contact.findAll", Contact.class);
		list = q.getResultList();
		return list;
	}

}
