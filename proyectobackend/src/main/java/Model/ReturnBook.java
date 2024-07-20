package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Bib_ReturnBook")
public class ReturnBook {

	@Id
	@Column (name = " retboo_id")
	private int retboo_id;
	
	@Column (name = " retboo_name")
	private int retboo_name;
	
	@Column (name = " retboo_category")
	private int retboo_category;
	
	@Column (name = " retboo_nameUser")
	private int retboo_nameUser;
	
	@Column (name = " retboo_date")
	private int retboo_date;

	public int getRetboo_id() {
		return retboo_id;
	}

	public void setRetboo_id(int retboo_id) {
		this.retboo_id = retboo_id;
	}

	public int getRetboo_name() {
		return retboo_name;
	}

	public void setRetboo_name(int retboo_name) {
		this.retboo_name = retboo_name;
	}

	public int getRetboo_category() {
		return retboo_category;
	}

	public void setRetboo_category(int retboo_category) {
		this.retboo_category = retboo_category;
	}

	public int getRetboo_nameUser() {
		return retboo_nameUser;
	}

	public void setRetboo_nameUser(int retboo_nameUser) {
		this.retboo_nameUser = retboo_nameUser;
	}

	public int getRetboo_date() {
		return retboo_date;
	}

	public void setRetboo_date(int retboo_date) {
		this.retboo_date = retboo_date;
	}
	
	
	
}
