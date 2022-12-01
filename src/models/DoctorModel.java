package models;

public class DoctorModel {
    private String fullName;
    private String id;
    private String password;
    private String specialty;
    private int price;

    public DoctorModel(String fullName,  String id, String password, String specialty, int price) {
        this.fullName = fullName;
        this.id = id;
        this.password = password;
        this.price = price;
        this.specialty = specialty;
    }
    
    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    
    
    
}
