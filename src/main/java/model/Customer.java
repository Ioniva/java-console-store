package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public abstract class Customer {

    protected Integer id;
    protected String email;
    protected String nif;
    protected String address;
    protected String name;
    protected String customerType;

    public Customer(){}

    public Customer(String email, String nif, String address, String name, String customerType) {
        this.email = email;
        this.nif = nif;
        this.address = address;
        this.name = name;
        this.customerType = customerType;
    }

    public abstract String customerType();
    public abstract float annualCalc();
    public abstract double shippingDiscount(Item item);

}
