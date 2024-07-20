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
	private int lenboo_name;
	
	@Column (name = " lenboo_category")
	private int lenboo_category;
	
	@Column (name = " lenboo_nameUser")
	private int lenboo_nameUser;
	
	@Column (name = " lenboo_date")
	private int lenboo_date;

	public int getLenboo_id() {
		return lenboo_id;
	}

	public void setLenboo_id(int lenboo_id) {
		this.lenboo_id = lenboo_id;
	}

	public int getLenboo_name() {
		return lenboo_name;
	}

	public void setLenboo_name(int lenboo_name) {
		this.lenboo_name = lenboo_name;
	}

	public int getLenboo_category() {
		return lenboo_category;
	}

	public void setLenboo_category(int lenboo_category) {
		this.lenboo_category = lenboo_category;
	}

	public int getLenboo_nameUser() {
		return lenboo_nameUser;
	}

	public void setLenboo_nameUser(int lenboo_nameUser) {
		this.lenboo_nameUser = lenboo_nameUser;
	}

	public int getLenboo_date() {
		return lenboo_date;
	}

	public void setLenboo_date(int lenboo_date) {
		this.lenboo_date = lenboo_date;
	}
	
	
	
	
}
