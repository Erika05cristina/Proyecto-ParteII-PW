package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Bib_Books")
public class Book {
	
	@Id
	@Column (name = " boo_id")
	private int boo_id;
	
	@Column(name ="boo_name")
	private String boo_name;
	
	@Column (name ="boo_image", columnDefinition = "TEXT")
	private String boo_image;
	
	@Column (name ="boo_autor")
	private String boo_autor;
	
	@Column (name ="boo_category")
	private String boo_category;
	
	@Column (name="boo_description", columnDefinition = "TEXT")
	private String boo_description;

	public int getBoo_id() {
		return boo_id;
	}

	public void setBoo_id(int boo_id) {
		this.boo_id = boo_id;
	}

	public String getBoo_name() {
		return boo_name;
	}

	public void setBoo_name(String boo_name) {
		this.boo_name = boo_name;
	}

	public String getBoo_image() {
		return boo_image;
	}

	public void setBoo_image(String boo_image) {
		this.boo_image = boo_image;
	}
	

	public String getBoo_category() {
		return boo_category;
	}

	public void setBoo_category(String boo_category) {
		this.boo_category = boo_category;
	}

	public String getBoo_description() {
		return boo_description;
	}

	public void setBoo_description(String boo_description) {
		this.boo_description = boo_description;
	}

	public String getBoo_autor() {
		return boo_autor;
	}

	public void setBoo_autor(String boo_autor) {
		this.boo_autor = boo_autor;
	}

	
	
	
	
	
	
	
}
