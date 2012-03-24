package models;

import play.data.validation.Email;

public class EmailModel {

	@Email
	public String email;

	public EmailModel(String email) {
		this.email = email;
	}
}
