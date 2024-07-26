package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @description Historial de los libros prestados
*/

@Entity
@Table (name="Bib_LendBook")
public class LendBook {
	
	@Id
	@Column (name = "lenboo_id")
	private int lenboo_id;
	
	@Column (name = "lenboo_name")
	private String lenboo_nameBook;
	
	@Column (name = "lenboo_category")
	private String lenboo_category;
	
	@Column (name = "lenboo_nameUser")
	private String lenboo_nameUser;
	
	@Column (name = "lenboo_inicial_date")
	private String lenboo_inicial_date;
	
	@Column (name = "lenboo_limit_date")
	private String lenboo_limit_date;

	public int getLenboo_id() {
		return lenboo_id;
	}

	public void setLenboo_id(int lenboo_id) {
		this.lenboo_id = lenboo_id;
	}

	public String getLenboo_nameBook() {
		return lenboo_nameBook;
	}

	public void setLenboo_nameBook(String lenboo_nameBook) {
		this.lenboo_nameBook = lenboo_nameBook;
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

	public String getLenboo_inicial_date() {
		return lenboo_inicial_date;
	}

	public void setLenboo_inicial_date(String lenboo_inicial_date) {
		this.lenboo_inicial_date = lenboo_inicial_date;
	}

	public String getLenboo_limit_date() {
		return lenboo_limit_date;
	}

	public void setLenboo_limit_date(String lenboo_limit_date) {
		this.lenboo_limit_date = lenboo_limit_date;
	}

	

	
}
