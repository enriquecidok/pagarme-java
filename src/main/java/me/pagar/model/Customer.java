package me.pagar.model;

public class Customer extends PagarmeObject<Customer> {

	private String documentNumber;
	private String name;
	private String email;
	private String bornAt;
	private String gender;
	private Address address;
	private Phone phone;
	
	public String getDocumentNumber() {
		return documentNumber;
	}
	public Customer setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return this;
	}
	public String getName() {
		return name;
	}
	public Customer setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getBornAt() {
		return bornAt;
	}
	public Customer setBornAt(String bornAt) {
		this.bornAt = bornAt;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public Customer setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public Address getAddress() {
		return address;
	}
	public Customer setAddress(Address address) {
		this.address = address;
		return this;
	}
	public Phone getPhone() {
		return phone;
	}
	public Customer setPhone(Phone phone) {
		this.phone = phone;
		return this;
	}
	
	
}
