package test;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.*;

/**
 * Backing Bean for JSF pages. <br/>
 * This bean has reference of <code>ContactService</code> using @EJB Annotation
 */
@ManagedBean
@SessionScoped
public class ContactBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ContactService service;
	
	private String firstName, lastName, phone;
	
	private List<Contact> contactList;

	
	public ContactBean() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Call save method on ContactService and update list
	 * 
	 * @return Outcome for JSF Navigation
	 */

	public String addContact() {
		service.save(firstName, lastName, phone);
		contactList = service.loadAll();
		return "success";
	}
	
	public String backToNewContact() {
		return "backnewcontact";
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}