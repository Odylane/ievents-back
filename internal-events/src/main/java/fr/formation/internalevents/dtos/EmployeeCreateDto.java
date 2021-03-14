package fr.formation.internalevents.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fr.formation.internalevents.validation.UniqueEmail;
import fr.formation.internalevents.validation.UniqueUsername;

/**
 * A DTO that specifies the validation rules to create an employee.
 * 
 * @author Catherine Nobyn
 *
 */
public class EmployeeCreateDto {

	@UniqueUsername
	@NotBlank
	@Size(max = 11)
	@Pattern(regexp = "^[G][L]0{2}(\\d){7}$", message = "Votre identifiant correspond à votre matricule RH GL00xxxxxxx")
	private String username;

	@NotBlank
	@Size(min = 2, max = 100)
	@Pattern(regexp = "^([\\p{javaLowerCase}.'-]{2,100})$", message = "Le prénom doit contenir entre 2 et 100 caractères")
	private String firstname;

	@NotBlank
	@Size(min = 2, max = 100)
	@Pattern(regexp = "^([\\p{javaLowerCase}.'-]{2,100})$", message = "Le prénom doit contenir entre 2 et 100 caractères")
	private String lastname;

	@UniqueEmail
	@NotBlank
	@Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")
	private String email;

	@NotBlank
	@Size(min = 8, max = 12)
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@§;#$%?/,^&*]).{8,12}$", message = "Votre mot de passe doit contenir au moins un chiffre, une minuscule, une majuscule, un caractère spécial et être compris en 8 et 12 caractères")
	private String password;

	public EmployeeCreateDto() {
		//
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
