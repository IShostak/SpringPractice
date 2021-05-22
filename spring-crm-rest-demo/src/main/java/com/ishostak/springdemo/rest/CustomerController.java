package com.ishostak.springdemo.rest;

import com.ishostak.springdemo.entity.Customer;
import com.ishostak.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> customers() {

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer customers(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found " + customerId);
        }

        return theCustomer;
    }

    @PostMapping("/customers/")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        //if id = 0 DAO will insert new customer
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @PutMapping("/customers/")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found " + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer +  " + customerId;
    }
}
