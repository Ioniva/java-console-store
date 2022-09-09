package dao;

import model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomers();

    int saveCustomer(Customer customer);

    List<Customer> getAllCustomersByType(String type);

    Customer getCustomerByNif(String nif);

}
