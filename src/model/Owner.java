package model;

public class Owner {
	private int id;
	private String ownerName;
	
	public Owner() {
		super();
	}
	
	public Owner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}
	
	public Owner(int id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerName=" + ownerName + "]";
	}
	
}
