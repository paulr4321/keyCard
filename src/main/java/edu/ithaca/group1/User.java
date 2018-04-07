package edu.ithaca.group1;

public class User {

    private String id;
    private String name;
    private String department;

    /**
     * Default constructor
     */
    public User(){}

    /**
     * @param id of the user
     * @param name of the user
     */
    public User(String id, String name, String department)
    {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    /*
    * Getter function for ID
    */
    public String getId(){
        return this.id;
    }

    /*
    * Getter function for Name
    */
    public String getName(){
        return this.name;
    }

    /*
    * Setter function for ID
    */
    
    public void setId(String idIn){
        this.id = idIn;
    }

    /*
    * Setter function for Name
    */
    public void setName(String nameIn){
        this.name = nameIn;
    }

    /**
     * @return a formatted String representing the properties of this User
     */
    public String toString()
    {
        String output = "UserId: " + id + "\nName: " + name;
        return output;
    }

    public void setDepartment(String department){this.department = department; }

    public String getDepartment()
    {
        return department;
    }
}
