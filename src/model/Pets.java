package model;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@ManyToOne (cascade=CascadeType.MERGE)
	@JoinTable(name="owner",
	joinColumns={ @JoinColumn(name="petId", referencedColumnName="id") },
	inverseJoinColumns={ @JoinColumn(name="ownerId", referencedColumnName="id", unique=true) })
	private Owner owner;
	@Column (name="birthday")
	private LocalDate petBirthday;
	
	public Pets() {
		//Default empty constructor
		super();
	}
	public Pets(String petName, Owner owner, LocalDate petBirthday) {
		// 3 arg constructor
		super();
		this.petName = petName;
		this.owner = owner;
		this.petBirthday = petBirthday;
	}
	public Pets(String petName, LocalDate petBirthday) {
		// 2 arg constructor
		super();
		this.petName = petName;
		this.petBirthday = petBirthday;
	}
	public Pets(int id, String petName, Owner owner, LocalDate petBirthday) {
		// 4 arg constructor
		super();
		this.id = id;
		this.petName = petName;
		this.owner = owner;
		this.petBirthday = petBirthday;
	}
	//Getters and Setters
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
	//Our toString 
	@Override
	public String toString() {
		return "Pets [id=" + id + ", petName=" + petName + ", petBirthday=" + petBirthday + "]";
	}
	
}
