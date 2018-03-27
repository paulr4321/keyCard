package edu.ithaca.group1;

public class User {

    private int id;
    private String name;


    /*
    * Getter function for ID
    */
    public int getId(){
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
    
    public void setId(int idIn){
        this.id = idIn;
    }

    /*
    * Setter function for Name
    */
    public void setName(String nameIn){
        this.name = nameIn;
    }
}
