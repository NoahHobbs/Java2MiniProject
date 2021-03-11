package model;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="pet")
public class Pets {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="petId")
	private int id;
	@Column(name="name")
	private String petName;
	
	//when owner class is made create object of it here so a pet has an owner
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="id")
	private Owner owner;
	@Column (name="birthday")
	private LocalDate petBirthday;
	
	public Pets() {
		super();
	}
	public Pets(String petName, Owner owner, LocalDate petBirthday) {
		super();
		this.petName = petName;
		this.owner = owner;
		this.petBirthday = petBirthday;
	}
	public Pets(String petName, LocalDate petBirthday) {
		super();
		this.petName = petName;
		this.petBirthday = petBirthday;
	}
	public Pets(int id, String petName, Owner owner, LocalDate petBirthday) {
		super();
		this.id = id;
		this.petName = petName;
		this.owner = owner;
		this.petBirthday = petBirthday;
	}
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
