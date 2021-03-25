package ku.message.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	private String username;
	private String password;

	private String firstName;
	private String lastName;
	private String email;
	private String role;

	private Instant createdAt;

	public void setPassword(String hashedPassword) {}

	public void setCreatedAt(Instant now) {}

	public String getPassword()
	{
		return password;
	}
}
