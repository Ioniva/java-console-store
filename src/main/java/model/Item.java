package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Item {
    private int id;
    private String code;
    private String description;
    public double sellPrice;
    private double itemshippingCost;
    private int preparationTime;

    public Item() {
    }

    public Item(String code, String description, double sellPrice, double itemshippingCost, int preparationTime) {
        this.code = code;
        this.description = description;
        this.sellPrice = sellPrice;
        this.itemshippingCost = itemshippingCost;
        this.preparationTime = preparationTime;
    }
}
