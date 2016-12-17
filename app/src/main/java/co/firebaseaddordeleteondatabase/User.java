package co.firebaseaddordeleteondatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by horror on 12/14/16.
 */

public class User {
    public String name;
    public String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User(){}
    public User(String n, String c){
        this.name=n;
        this.country=c;

    }

    public Map<String, Object> mapUsers (){
        HashMap<String, Object> hashMap= new HashMap<>();
        hashMap.put("name", name);
        return  hashMap;
    }
    @Override
    public String toString() {
        return name +" "+ country;
    }
}
