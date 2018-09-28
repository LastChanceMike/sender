package model;

/**
 * Created by DORDV on 17.08.2018.
 */
public class User {
    private String orderNumber;
    private String name;
    private String email;


    public User(String orderNumber, String name, String email) {
        this.name = name;
        this.email = email;
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
