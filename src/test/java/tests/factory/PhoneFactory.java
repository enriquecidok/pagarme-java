package tests.factory;

import me.pagar.model.Phone;

public class PhoneFactory {

	public Phone create(){
		Phone phone = new Phone();
		phone.setDdd("11");
		phone.setNumber("87654321");
		return phone;
	}
}
