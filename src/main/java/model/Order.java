package model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Order {
    private int id;
    private int units;
    private Date orderDate;
    private int customerId;
    private int itemId;
    private boolean readyToShip;

    public Order(){}

    public Order(int units, Date orderDate, int customer, int item, boolean readyToShip) {
        this.units = units;
        this.orderDate = orderDate;
        this.customerId = customer;
        this.itemId = item;
        this.readyToShip = readyToShip;
    }
}

