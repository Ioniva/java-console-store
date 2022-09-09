package view;

import factory.CustomerFactory;
import factory.ItemFactory;
import factory.OrderFactory;

import static util.ScannerUtils.showIntRangeInput;

public class MainView {

    private static ItemView itemView = ItemFactory.getItemView();
    private static CustomerView customerView = CustomerFactory.getCustomerView();
    private static OrderView orderView = OrderFactory.getOrderView();

    public static void main(String[] args) throws Exception {
        mainView();
    }

    static void mainView() throws Exception {
        int userInput;
        do {
            System.out.println("**********************************************");
            System.out.println("**************** ONLINE STORE ****************");
            System.out.println("**********************************************");
            System.out.println("1) Gestionar pedidos.");
            System.out.println("2) Gestionar articulos.");
            System.out.println("3) Gestionar clientes.");
            userInput = showIntRangeInput(1, 3);
        } while (userInput < 1 || userInput > 3);
        printSelectedCase(userInput);
    }

    private static void printSelectedCase(int userInput) throws Exception {
        switch (userInput) {
            case 1:
                // Mostrar menu para gestionar pedidos.
                orderView.orderMenu();
                break;
            case 2:
                // Mostrar menu para gestionar articulos
                itemView.itemMenu();

                break;
            case 3:
                // Mostrar menu para gestionar clientes.
                customerView.customerMenu();
                break;
        }
    }
}
