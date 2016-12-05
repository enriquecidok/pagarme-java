package tests.factory;

import me.pagar.model.request.CustomerRequest;

public class CustomerFactory {

	private AddressFactory addressFactory;
	private PhoneFactory phoneFactory;
	
	public CustomerFactory(){
		this.addressFactory = new AddressFactory();
		this.phoneFactory = new PhoneFactory();
	}
	
	public CustomerRequest create(){
		CustomerRequest customer = new CustomerRequest();
		customer.setBornAt("2016-02-22T00:00:00.000Z");
		customer.setDocumentNumber("35965816804");
		customer.setEmail("ewfwef@wefew.com");
		customer.setGender("M");
		customer.setName("name");
		customer.setPhone(phoneFactory.create());
		customer.setAddress(addressFactory.create());
		return customer;
	}
}
