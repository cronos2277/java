package Spring.verification;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Check implements Validator {
	private long id;
	private String value;
	public Check(long id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public boolean supports(Class<?> clazz) {		
		return Check.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"value", "erro.vazio");
		if(id < 1) {
			errors.rejectValue("id", "ID Invalido");
		}
	}

	@Override
	public String toString() {
		return "Bean [id=" + id + ", value=" + value + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
