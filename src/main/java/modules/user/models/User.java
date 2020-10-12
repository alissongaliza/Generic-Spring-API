package modules.user.models;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user", schema = "public")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(unique = true)
	private String email;
	private String password;
	private String lastname;
	private String firstname;

	protected User() {}

	private User(final String email, final String password, final String lastname, final String firstname) {
//		this.id = id;
		this.email = email;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public static UserBuilder builder() {
		return new UserBuilder();
	}

	public static class UserBuilder {
		private UUID id;
		private String email;
		private String password;
		private String lastName;
		private String firstName;

		UserBuilder() {
		}

		public UserBuilder email(final String email) {
			this.email = email;
			return this;
		}

		public UserBuilder password(final String password) {
			this.password = password;
			return this;
		}

		public UserBuilder lastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder firstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public User build() {
			return new User(email, password, lastName, firstName);
		}
	}

	public UUID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	@Override
	public String toString() {
		return "User{" +
			"id='" + id + '\'' +
			", email='" + email + '\'' +
			", password='" + password + '\'' +
			", lastName='" + lastname + '\'' +
			", firstName='" + firstname + '\'' +
			'}';
	}
}
