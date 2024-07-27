package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Bib_Users")
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="us_id")
	private int us_id;
	
	@Column (name="us_name")
	private String us_name;
	
	@Column (name="us_lastname")
	private String us_lastname;
	
	@Column (name="us_cell")
	private String us_cell;
	
	@Column (name="us_email")
	private String us_email;
	
	@Column (name="us_password")
	private String us_password;
	
	@Column (name="us_image", columnDefinition = "TEXT")
	private String us_image;
	
	@Column (name="us_admin")
	private Boolean us_admin;

	
	public int getUs_id() {
		return us_id;
	}

	public void setUs_id(int us_id) {
		this.us_id = us_id;
	}

	public String getUs_name() {
		return us_name;
	}

	public void setUs_name(String us_name) {
		this.us_name = us_name;
	}

	public String getUs_lastname() {
		return us_lastname;
	}

	public void setUs_lastname(String us_lastname) {
		this.us_lastname = us_lastname;
	}

	public String getUs_cell() {
		return us_cell;
	}

	public void setUs_cell(String us_cell) {
		this.us_cell = us_cell;
	}

	public String getUs_email() {
		return us_email;
	}

	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}

	public String getUs_password() {
		return us_password;
	}

	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}

	public String getUs_image() {
		return us_image;
	}

	public void setUs_image(String us_image) {
		this.us_image = us_image;
	}

	public Boolean getUs_admin() {
		return us_admin;
	}

	public void setUs_admin(Boolean us_admin) {
		this.us_admin = us_admin;
	}
	

	
	
}
