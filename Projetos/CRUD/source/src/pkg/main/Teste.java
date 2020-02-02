package pkg.main;

import pkg.connection.Manager;
import pkg.entity.Client;
import pkg.entity.Contact;
import pkg.entity.Laptop;
import pkg.entity.Locale;
import pkg.entity.Payment;
import pkg.entity.Status;
import pkg.entity.User;

public class Teste {
	public Teste(){
		User user = new User();		
		user.setName("João Paulo");
		user.setBrazilLaptop(18);
		
		//Cliente Teste.
		Client client = new Client();
		client.setAccount_holder("João account_holder");
		client.setAccount_number("3333-Accont_number");
		client.setAccount_type("Current account_type");
		client.setBank_agency("bank bank_agency");
		client.setCpf("052.859.939-97");				
		client.setDob("02/10/1990");
		client.setNotes("Cliente Teste");
		client.setRg("96661681");
		
		//Contact teste.
		Contact contact = new Contact();
		contact.setEmail("cronos2277@gmail.com");
		contact.setHome_phone("+55(42)3226-1608");
		contact.setMobile("+55(41)88570053");
		contact.setSecondary_phone("+55(42)3226-1240");
		contact.setNotes("Teste para contatos");
		
		//Laptop teste		
		Laptop laptop = new Laptop();
		laptop.setFacebook_login("facebook.login");
		laptop.setFacebook_page("facebook.page");
		laptop.setFacebook_password("facebook.password");
		laptop.setFinal_date("01/01/2015");
		laptop.setInitial_date("02/06/2014");
		laptop.setLaptop_received("04/04/2014");
		laptop.setLaptop_shipped("03/03/2005");
		laptop.setNotes("Laptop notas");
		laptop.setTeam_view_id("View id");
		laptop.setTeam_view_pw("View.password");		
		
		//locale teste
		Locale locale = new Locale();
		locale.setAddress("Rua Diolando João Scremim");
		locale.setCity("Ponta Grossa");
		locale.setNeighborhood("Uvaranas");
		locale.setNotes("Notas Locale");
		locale.setState("Paraná");
		locale.setZipcode("83280-000");
		
		//Payment teste.
		Payment pay = new Payment();
		pay.setContractPayment(830.90);
		pay.setNotes("Notas Payment");
		pay.setPayment_date("04/04/2013");
		pay.setReferredby("Rodrigo");
		pay.setWithdraw_cost(30.00);
		
		//Status teste
		Status status = new Status();		
		status.setPayment_status(true);
		status.setReference_bonus_status(0);
		status.setShipment_status(2);
		status.setAccount_status(2);
		
		//Manager adicionando registro.
		Manager manager = new Manager(0);
		user.setContact(contact);
		user.setClient(client);
		user.setLaptop(laptop);
		user.setLocale(locale);
		user.setPayment(pay);
		user.setStatus(status);
		manager.create(user);
		new Manager(1).addAttachment("teste","C:", "Fotos");
		new Manager(1).addReference("Rodrigo", "Rodrigo indicou");		
		
	}

}

