package view;

import controller.CustomerController;
import factory.CustomerFactory;
import model.Customer;
import model.Premium;
import model.Standard;

import static util.ScannerUtils.*;

public class CustomerView {
    private static CustomerController customerController = CustomerFactory.getCustomerController();

    public void customerMenu() throws Exception {
        int userInput;
        do {
            System.out.println("****************************************");
            System.out.println(" - Gestionar clientes - ");
            System.out.println("1) Nuevo cliente.");
            System.out.println("2) Mostrar clientes.");
            System.out.println("3) Mostrar clientes Estandar.");
            System.out.println("4) Mostrar clientes Premium.");
            System.out.println("5) Volver al menú anterior.");
            
            // Se le asigna el valor que retorna el metodo Menu().
            userInput = showIntRangeInput(1,5);
        } while (userInput < 1 || userInput > 5);
        // Ejecutar el caso seleccionado.
        printSelectedCase(userInput);
    }

    private void printSelectedCase (int userInput) throws Exception {
        switch (userInput){
            case 1:
                try {
                    printNewCustomer();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                this.customerMenu();
                break;
            case 2:
                printAllCustomers();
                break;
            case 3:
                printStandarCustomers();
                break;
            case 4:
                printPremiumCustomers();
                break;
            case 5:
                MainView.mainView();
                break;
        }
    }

    protected int printNewCustomer() throws Exception {
        String email = showStringInput("Introducir email:");
        String nif = showStringInput("Introducir NIF:");
        String address = showStringInput("Introducir direccion:");
        String name = showStringInput("Introducir nombre:");
        String customerType = showStringInput("Tipo cliente (Premium/Estandar):");

        int newCustomerId = 0;

        if (customerType.equals("Premium")){
            Premium customer = new Premium(email, nif, address, name, customerType);
            newCustomerId = customerController.save(customer);
        }
        if (customerType.equals("Estandar")){
            Standard customer = new Standard(email, nif, address, name, customerType);
            newCustomerId = customerController.save(customer);
        }

        return newCustomerId;
        //this.customerMenu();
    }

    private void printAllCustomers () throws Exception {
        System.out.println("Todos los clientes...");
        customerController.getArrayList().forEach(System.out::println);
        this.customerMenu();
    }

    public void printStandarCustomers () throws Exception {
        System.out.println("Todos los clientes ESTANDARES...");
        customerController.getAllCustomersByType("Estandar").forEach(System.out::println);
        System.out.println("Volviendo al menu....");
        this.customerMenu();
    }

    public void printPremiumCustomers () throws Exception {
        System.out.println("Todos los clientes PREMIUM...");
        customerController.getAllCustomersByType("Premium").forEach(System.out::println);
        System.out.println("Volviendo al menu....");
        this.customerMenu();
    }
}
