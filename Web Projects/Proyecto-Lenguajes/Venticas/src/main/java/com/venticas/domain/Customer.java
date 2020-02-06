package com.venticas.domain;

import java.util.LinkedList;
import java.util.List;

public class Customer {

	private int id;
	private boolean isSubscribed;
	private List<Address> address;
	private List<ContactInformation> contactInformations;

	public Customer() {
		address = new LinkedList<Address>();
		contactInformations = new LinkedList<ContactInformation>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSubscribed() {
		return isSubscribed;
	}

	public void setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<ContactInformation> getContactInformations() {
		return contactInformations;
	}

	public void setContactInformations(List<ContactInformation> contactInformations) {
		this.contactInformations = contactInformations;
	}

}
