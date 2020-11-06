package com.narval.Dto.form;

//import lombok.Getter;
//import lombok.Setter;

//@Getter 
//@Setter
public class UserCredentialForm {
	private String email;
	private String password;
	
	public UserCredentialForm() {	
	}
	
	public UserCredentialForm(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "UserCredential [email=" + email + ", password=" + password + ", toString()="
				+ super.toString() + "]";
	}
	
}
