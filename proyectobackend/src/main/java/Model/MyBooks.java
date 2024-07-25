package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Bib_MyBooks")
public class MyBooks {
	@Id
	@Column (name = "myBoo_id")
	private int myBoo_id;
	@Column (name = "myBoo_idUser")
	private int myBoo_idUser;
	@Column (name = "myBoo_nameUser")
	private String myBoo_nameUser;
	@Column (name = "myBoo_idBook")
	private int myBoo_idBook;
	@Column (name = "myBoo_nameBook")
	private String myBoo_nameBook;
	@Column (name = "myBoo_stateBook")
	private String myBoo_stateBook;
	
	public int getMyBoo_id() {
		return myBoo_id;
	}
	public void setMyBoo_id(int myBoo_id) {
		this.myBoo_id = myBoo_id;
	}
	public int getMyBoo_idUser() {
		return myBoo_idUser;
	}
	public void setMyBoo_idUser(int myBoo_idUser) {
		this.myBoo_idUser = myBoo_idUser;
	}
	public String getMyBoo_nameUser() {
		return myBoo_nameUser;
	}
	public void setMyBoo_nameUser(String myBoo_nameUser) {
		this.myBoo_nameUser = myBoo_nameUser;
	}
	public int getMyBoo_idBook() {
		return myBoo_idBook;
	}
	public void setMyBoo_idBook(int myBoo_idBook) {
		this.myBoo_idBook = myBoo_idBook;
	}
	public String getMyBoo_nameBook() {
		return myBoo_nameBook;
	}
	public void setMyBoo_nameBook(String myBoo_nameBook) {
		this.myBoo_nameBook = myBoo_nameBook;
	}
	public String getMyBoo_stateBook() {
		return myBoo_stateBook;
	}
	public void setMyBoo_stateBook(String myBoo_stateBook) {
		this.myBoo_stateBook = myBoo_stateBook;
	}
	
	
	
}
