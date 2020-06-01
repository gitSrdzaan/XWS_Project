package xml.team.model;

import javax.persistence.*;


@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
/*
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager, mappedBy = "User")
	private List<User> users;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
	private List<String> car_model;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
	private List<String> fuel_type;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
	private List<String> car_class;

*/

	
	public Admin() {
		// eo radim
	}

	
	
}
