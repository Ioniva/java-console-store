package controller;

import java.util.List;

import dao.CustomerDao;
import factory.CustomerFactory;
import model.Customer;

public class CustomerController {

    private CustomerDao customerDao = CustomerFactory.getCustomerDaoImpl();

    public int save(Customer customer) throws Exception {
        if (contains(customer.getEmail())){
            throw new Exception("El cliente ya existe");
        }
        else {
            return customerDao.saveCustomer(customer);
        }
    }

    public boolean contains(String nif){
        for (Customer c : customerDao.getAllCustomers()) {
            if (c.getNif().equals(nif)) {
                return true;
            }
        }
        return false;
    }

    public List<Customer> getArrayList() {
        return customerDao.getAllCustomers();
    }

    public List<Customer> getAllCustomersByType(String type){
        return customerDao.getAllCustomersByType(type);
    }

    public Customer getCustomerByNif(String nif){
        return customerDao.getCustomerByNif(nif);
    }
}
