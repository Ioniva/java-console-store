package model;


import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Premium extends Customer {

    private Integer annualQuota = 30;
    private double discount = 0.20;
    

    public Premium(String email, String nif, String address, String name, String customerType) {
        super(email, nif, address, name, customerType);
    }

    public Premium(){}
    
    
    // Metodos abstractos
    @Override
    public String customerType(){return "Premium";}
    @Override
    public float annualCalc(){return annualQuota;}
    @Override
    public double shippingDiscount(Item item){return discount * item.getSellPrice();}

    
    @Override
    public String toString() {
        return "id=" + getId() + ", email=" + getEmail() + ", nif=" + getNif()
                + ", address=" + getAddress() + ", name=" + getName() + ", customerType=" + getCustomerType();
    }
}
