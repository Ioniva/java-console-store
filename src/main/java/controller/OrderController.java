package controller;

import dao.ItemDao;
import dao.OrderDao;
import factory.ItemFactory;
import factory.OrderFactory;
import model.Item;
import model.Order;

import java.util.Calendar;
import java.util.List;

public class OrderController {
    private OrderDao orderDao = OrderFactory.getOrderDao();
    private ItemDao itemDao = ItemFactory.getItemDaoImpl();

    public void save(Order order) {
        orderDao.saveOrder(order);
    }

    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    public void delete(Order order) throws Exception {
        if (orderIsSent(order)) {
            System.err.println("El pedido no se puede borrar porque ya ha sido enviado.");
            System.out.println("Pulse la tecla [Enter] para continuar...");
            System.in.read();
        } else {
            orderDao.deleteOrder(order.getId());
        }

    }

    private boolean orderIsSent(Order order) {
        Item item = ItemFactory.getItem();
        Calendar preparationDate = Calendar.getInstance();
        preparationDate.setTime(order.getOrderDate());
        preparationDate.add(Calendar.MINUTE, itemDao.getItemPreparationTimeById(order.getItemId()));

        Calendar nowDate = Calendar.getInstance();
        nowDate.getTime();

        return preparationDate.getTimeInMillis() < nowDate.getTimeInMillis();
    }

    public List<Order> orderToSendFiltered(String nif) {
        return orderDao.orderIsSendFiltered(nif, true);
    }

    public List<Order> orderToSend() {
        return orderDao.orderIsSend(true);
    }

    public List<Order> orderNotToSendFiltered(String nif) throws Exception {
        return orderDao.orderIsSendFiltered(nif, false);

    }

    public List<Order> orderNotToSend() {
        return orderDao.orderIsSend(false);

    }

    public boolean contains(int id) {
        for (Order o : orderDao.getAllOrders()) {
            if (o.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
