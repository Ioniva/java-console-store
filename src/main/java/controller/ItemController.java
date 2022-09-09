package controller;

import dao.ItemDao;
import factory.ItemFactory;
import model.Item;

import java.util.List;

public class ItemController {

    private ItemDao itemDao = ItemFactory.getItemDaoImpl();

    public void save(Item item) {
        itemDao.saveItem(item);
    }

    public List<Item> getArrayList() {
        return itemDao.getAllItems();
    }

    public boolean contains(String code){
        for (Item i :  itemDao.getAllItems()) {
            if (i.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public Item getItemByCode(String code) {
        // Nota: Devuelvo el objeto entero
        return itemDao.getItemByCode(code);
    }
}
