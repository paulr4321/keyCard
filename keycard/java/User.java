package java;

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
    * @param: int idIn is what id is getting set to
    * Setter function for ID
    */
    
    public void setId(int idIn){
        this.id = idIn;
    }

    /*
    * @param: int name is what name is getting set to
    * Setter function for Name
    */
    public void setName(String nameIn){
        this.name = nameIn;
    }
}
