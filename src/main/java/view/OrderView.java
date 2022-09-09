package view;

import controller.CustomerController;
import controller.ItemController;
import controller.OrderController;
import factory.CustomerFactory;
import factory.ItemFactory;
import factory.OrderFactory;

import model.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

import static util.ScannerUtils.*;

public class OrderView {
    private OrderController orderController = OrderFactory.getOrderController();
    private ItemController itemController = ItemFactory.getItemController();
    private CustomerController customerController = CustomerFactory.getCustomerController();
    private CustomerView customerView = CustomerFactory.getCustomerView();

    public void orderMenu() throws Exception {
        int userInput;
        do {
            System.out.println("****************************************");
            System.out.println(" - Gestionar pedidos - ");
            System.out.println("1) Nuevo pedido.");
            System.out.println("2) Borrar pedidos.");
            System.out.println("3) Mostrar pedidos enviados");
            System.out.println("4) Mostrar pedidos pendientes de envio");
            System.out.println("5) Volver al menú anterior.");
            userInput = showIntRangeInput(1, 5);
        } while (userInput < 1 || userInput > 5);
        printSelectedCase(userInput);
    }

    private void printSelectedCase(int userInput) throws Exception {
        switch (userInput) {
            case 1:
                try {
                    printAddOrder();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            case 2:
                try {
                    printDeleteOrder();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            case 3:
                printToSendOrder();
                break;
            case 4:
                printNotToSendOrder();
                break;
            case 5:
                MainView.mainView();
                break;
        }
    }

    private void printAddOrder() throws Exception {

        String clientCode = showStringInput("Introducir NIF del cliente:");
        int amount = showIntInput("Introducir cantidad:");
        String date = showStringInput("Introducir fecha y hora del pedido (DD/MM/AAAA HH:MM):");

        Date orderDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
        int customerId = 0;
        int itemId = 0;

        if (!customerController.contains(clientCode)) {
            System.out.println("El cliente no existe, introduzca datos de nuevo cliente:");
            customerId = customerView.printNewCustomer();
        } else {
            customerId = customerController.getCustomerByNif(clientCode).getId();
        }

        String itemCode = showStringInput("Introducir articulo:");

        if (!itemController.contains(itemCode)) {
            System.out.println("El articulo no existe!");
            this.orderMenu();
        } else {
            itemId = itemController.getItemByCode(itemCode).getId();
        }

        Order order = new Order(amount, orderDate, customerId, itemId, false);
        orderController.save(order);

        System.out.println("El pedido ha sido creado con exito");
        this.orderMenu();
    }

    private void printDeleteOrder() throws Exception {
        int orderId = showIntInput("Introducir ID del pedido:");
        if (orderController.contains(orderId)) {
            Order order = orderController.getOrderById(orderId);
            orderController.delete(order);
            System.out.println(order);

        } else {

            System.out.println("El id introducido no existe!");
        }
        this.orderMenu();
    }

    private void printToSendOrder() throws Exception {
        String filter = showStringInput("Filtrar por cliente (Si/No)?");

        if (filter.equals("Si")) {
            String clientCode = showStringInput("Introducir NIF del cliente:");
            orderController.orderToSendFiltered(clientCode).forEach(System.out::println);
        }

        if (filter.equals("No")) {
            orderController.orderToSend().forEach(System.out::println);
        }

        this.orderMenu();

    }

    private void printNotToSendOrder() throws Exception {
        String filter = showStringInput("Filtrar por cliente (Si/No)?");

        if (filter.equals("Si")) {
            
            String clientCode = showStringInput("Introducir NIF del cliente:");
            orderController.orderNotToSendFiltered(clientCode).forEach(System.out::println);
        }

        if (filter.equals("No")) {
            orderController.orderNotToSend().forEach(System.out::println);
        }

        this.orderMenu();

    }
}
