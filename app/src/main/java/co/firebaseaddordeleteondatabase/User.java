package co.firebaseaddordeleteondatabase;

/**
 * Created by horror on 12/14/16.
 */

public class User {
    public String name;
    public String country;

    public User(){}
    public User(String n, String c){
        this.name=n;
        this.country=c;

    }
    @Override
    public String toString() {
        return name +" "+ country;
    }
}
