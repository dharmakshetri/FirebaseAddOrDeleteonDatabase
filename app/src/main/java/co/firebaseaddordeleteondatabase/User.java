package co.firebaseaddordeleteondatabase;

/**
 * Created by horror on 12/14/16.
 */

public class User {

    private String name;
    private String country;
    private double weight;


    public User(){}
    public User(String n, String c, double w){
        this.name=n;
        this.country=c;
        this.weight=w;

    }
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getWeight() {
        return weight;
    }



    @Override
    public String toString() {
        return name +" "+ country +" " +weight;
    }
}
