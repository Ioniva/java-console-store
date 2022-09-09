package dao;

import model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getAllItems();

    void saveItem(Item item);

    Item getItemByCode(String code);

    int getItemPreparationTimeById(int id);

}
