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
	
	public Admin() {
		// eo radim
	}
	
	
}
