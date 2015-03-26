package test;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONTACT database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contactid;

	@Column(name="FIRST_NAME", length=25)
	private String firstName;

	@Column(name="LAST_NAME", length=35)
	private String lastName;

	@Column(name="PHONE_NO", length=15)
	private String phoneNo;

	public Contact() {
	}

	public int getContactid() {
		return this.contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}