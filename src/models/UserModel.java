package models;

public class UserModel {
    private String fullName;
    private String id;
    private String password;

    public UserModel(String fullName,  String id, String password) {
        this.fullName = fullName;
        this.id = id;
        this.password = password;
    }
    
    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }
    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    
    
    
}
