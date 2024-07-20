package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Bib_LendBook")
public class LendBook {
	@Id
	@Column (name = " lenboo_id")
	private int lenboo_id;
	
	@Column (name = " lenboo_name")
	private String lenboo_name;
	
	@Column (name = " lenboo_category")
	private String lenboo_category;
	
	@Column (name = " lenboo_nameUser")
	private String lenboo_nameUser;
	
	@Column (name = " lenboo_date")
	private String lenboo_date;

	public int getLenboo_id() {
		return lenboo_id;
	}

	public void setLenboo_id(int lenboo_id) {
		this.lenboo_id = lenboo_id;
	}

	public String getLenboo_name() {
		return lenboo_name;
	}

	public void setLenboo_name(String lenboo_name) {
		this.lenboo_name = lenboo_name;
	}

	public String getLenboo_category() {
		return lenboo_category;
	}

	public void setLenboo_category(String lenboo_category) {
		this.lenboo_category = lenboo_category;
	}

	public String getLenboo_nameUser() {
		return lenboo_nameUser;
	}

	public void setLenboo_nameUser(String lenboo_nameUser) {
		this.lenboo_nameUser = lenboo_nameUser;
	}

	public String getLenboo_date() {
		return lenboo_date;
	}

	public void setLenboo_date(String lenboo_date) {
		this.lenboo_date = lenboo_date;
	}
	
	
	
	
}
