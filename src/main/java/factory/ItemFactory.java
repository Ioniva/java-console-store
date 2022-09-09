package factory;

import controller.ItemController;
import dao.impl.ItemDaoImpl;
import model.Item;
import view.ItemView;

public class ItemFactory {

    public static Item getItem() { return new Item();}

    public static ItemDaoImpl getItemDaoImpl(){
        return new ItemDaoImpl();
    }

    public static ItemController getItemController(){
        return new ItemController();
    }

    public static ItemView getItemView(){
        return new ItemView();
    }

}
