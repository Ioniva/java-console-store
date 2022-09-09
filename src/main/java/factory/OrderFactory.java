package factory;

import controller.OrderController;
import dao.impl.OrderDaoImpl;
import model.Order;
import view.OrderView;

public class OrderFactory {
    public static Order getOrder() { return new Order();}

    public static OrderDaoImpl getOrderDao(){
        return new OrderDaoImpl();
    }

    public static OrderController getOrderController(){
        return new OrderController();
    }

    public static OrderView getOrderView(){
        return new OrderView();
    }
}
