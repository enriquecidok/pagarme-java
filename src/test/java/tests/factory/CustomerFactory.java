package tests.factory;

import org.joda.time.DateTime;

import me.pagar.model.Address;
import me.pagar.model.Phone;
import me.pagar.model.request.CustomerRequest;

public class CustomerFactory {

	private AddressFactory addressFactory;
	private PhoneFactory phoneFactory;
	
	public CustomerFactory(){
		this.addressFactory = new AddressFactory();
		this.phoneFactory = new PhoneFactory();
	}
	
	public CustomerRequest create(){
		String document = "35965816804";
		String name = "NAme";
		DateTime bornAt = new DateTime(2001, 1, 1, 0, 0);
		String email = "email@email.com";
		String gender = "M";
		Phone phone = phoneFactory.create();
		Address address = addressFactory.create();
		CustomerRequest customer = new CustomerRequest(document, name, email, address, phone);
		customer.setBornAt(bornAt);
		customer.setGender(gender);
		return customer;
	}
}
