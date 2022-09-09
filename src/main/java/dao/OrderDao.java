package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
    
    List<Order> getAllOrders();

    void saveOrder(Order order);

    void deleteOrder(int orderId);

    Order getOrderById(int id);

    List<Order> orderIsSendFiltered(String nif, boolean isReadyToShip);

    List<Order> orderIsSend(boolean isReadyToShip);

}
