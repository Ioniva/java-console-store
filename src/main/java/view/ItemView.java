package view;

import controller.ItemController;
import factory.ItemFactory;
import model.Item;

import static util.ScannerUtils.*;

public class ItemView {
    private ItemController itemController = ItemFactory.getItemController();

    public void itemMenu() throws Exception {
        int userInput;
        do {
            System.out.println("****************************************");
            System.out.println(" - Gestionar articulos - ");
            System.out.println("1) Nuevo articulo.");
            System.out.println("2) Mostrar articulos.");
            System.out.println("3) Volver al menu anterior.");
            userInput = showIntRangeInput(1,3);
        } while (userInput < 1 || userInput > 3);
        printSelectedCase(userInput);
    }

    private void printSelectedCase(int userInput) throws Exception {
        switch (userInput){
            case 1:
                printNewItem();
                break;
            case 2:
                printAllItems();
                break;
            case 3:
                MainView.mainView();
                break;
        }
    }

    private void printNewItem() throws Exception {
        String code = showStringInput("Introducir codigo alfanumerico:");
        String description = showStringInput("Introducir descripcion:");
        double sellPrice = showDoubleInput("Introducir precio de venta:");
        double itemshippingCost = showDoubleInput("Introducir precio de envio:");
        int preparationTime = showIntInput("Introducir tiempo de preparacion (en minutos):");

        if (itemController.contains(code)) {
            System.out.println("El código ya existe en la base de datos.");
        } else {
            Item item = new Item(code, description, sellPrice, itemshippingCost, preparationTime);
            itemController.save(item);
        }
        
        this.itemMenu();
    }

    private void printAllItems() throws Exception {
        System.out.println("Todos los articulos...");
        itemController.getArrayList().forEach(System.out::println);
        this.itemMenu();
    }
}
