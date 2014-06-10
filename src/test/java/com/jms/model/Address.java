package com.jms.model;

public class Address {
	
	private String company;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Address() {
		this.company = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.country = "";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof Address))
			return false;
		
		Address a = (Address) o;
		return  (
				company.equals(a.company) &&
				address.equals(a.address) &&
				city.equals(a.city) &&
				state.equals(a.state) &&
				zip.equals(a.zip) &&
				country.equals(a.country)
		);
	
	}

	public String getCompany() {
		return company;
	}

	public Address setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Address setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public Address setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public Address setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(String country) {
		this.country = country;
		return this;
	}
	
}
