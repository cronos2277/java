package model;
import java.util.Date;

import com.github.javafaker.Faker;

public class FakerData {
	private Faker faker;
	public FakerData() {
		this.faker = new Faker();		
	}
	
	public String getName() {
		return this.faker.name().fullName();
	}
	
	public Date getDate() {
		return this.faker.date().birthday();
	}
}
