package models;

public class PatientModel {
    private String id;
    private String fullname;
    private String history;

    public PatientModel(String id, String fullname, String history) {
        this.id = id;
        this.fullname = fullname;
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

   
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

  
    
    
}
