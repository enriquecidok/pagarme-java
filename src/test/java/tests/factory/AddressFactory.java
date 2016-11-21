package tests.factory;

import me.pagar.model.Address;

public class AddressFactory {

	public Address create(){
		Address address = new Address();
		address.setComplementary("Complementary");
		address.setNeighborhood("neighborhood");
		address.setStreet("Street");
		address.setStreetNumber("123");
		address.setZipcode("06350270");
		return address;
	}
}
