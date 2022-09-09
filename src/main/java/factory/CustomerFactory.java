package factory;

import controller.CustomerController;
import dao.impl.CustomerDaoImpl;
import model.Customer;
import model.Premium;
import model.Standard;
import view.CustomerView;

public class CustomerFactory {

    public static Customer getCustomerPremium(){ return new Premium(); }

    public static Customer getCustomerStandard(){ return new Standard(); }

    public static CustomerDaoImpl getCustomerDaoImpl(){
        return new CustomerDaoImpl();
    }

    public static CustomerController getCustomerController(){
        return new CustomerController();
    }

    public static CustomerView getCustomerView(){
        return new CustomerView();
    }

}
