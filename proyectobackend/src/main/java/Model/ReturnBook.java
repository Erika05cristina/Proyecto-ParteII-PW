package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Bib_ReturnBook")
public class ReturnBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = " retboo_id")
	private int retboo_id;
	
	@Column (name = " retboo_name")
	private String retboo_name;
	
	@Column (name = " retboo_category")
	private String retboo_category;
	
	@Column (name = " retboo_nameUser")
	private String retboo_nameUser;
	
	@Column (name = " retboo_date")
	private String retboo_date;

	public int getRetboo_id() {
		return retboo_id;
	}

	public void setRetboo_id(int retboo_id) {
		this.retboo_id = retboo_id;
	}

	public String getRetboo_name() {
		return retboo_name;
	}

	public void setRetboo_name(String retboo_name) {
		this.retboo_name = retboo_name;
	}

	public String getRetboo_category() {
		return retboo_category;
	}

	public void setRetboo_category(String retboo_category) {
		this.retboo_category = retboo_category;
	}

	public String getRetboo_nameUser() {
		return retboo_nameUser;
	}

	public void setRetboo_nameUser(String retboo_nameUser) {
		this.retboo_nameUser = retboo_nameUser;
	}

	public String getRetboo_date() {
		return retboo_date;
	}

	public void setRetboo_date(String retboo_date) {
		this.retboo_date = retboo_date;
	}
	
	
	
}
