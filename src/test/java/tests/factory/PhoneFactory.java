package tests.factory;

import me.pagar.model.Phone;

public class PhoneFactory {

	public Phone create(){
		Phone phone = new Phone("11", "87654321");
		return phone;
	}
}
