package model;
import java.time.LocalDate;

public class Pets {
	private int id;
	private String petName;
	//when owner class is made create object of it here so a pet has an owner
	private Owner owner;
	private LocalDate petBirthday;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public LocalDate getPetBirthday() {
		return petBirthday;
	}
	public void setPetBirthday(LocalDate petBirthday) {
		this.petBirthday = petBirthday;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Pets [id=" + id + ", petName=" + petName + ", petBirthday=" + petBirthday + "]";
	}
	
}
