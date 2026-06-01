package com.bankingapplication.CustomerManagementService.controller;

import com.bankingapplication.CustomerManagementService.entities.CustomerEntity;
import com.bankingapplication.CustomerManagementService.services.CustomerManagementService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerManagementController {

    @Autowired
    CustomerManagementService customerManagementService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerManagementController.class);

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomerProfile(@RequestBody @Valid CustomerEntity customer) {

        CustomerEntity customerEntity = customerManagementService.createCustomerProfile(customer);
        LOGGER.info("Customer created with : "+ customerEntity);
        return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {

        final List<CustomerEntity> customerEntityList = customerManagementService.getAllCustomers();
        LOGGER.info("Total number of customers: "+ customerEntityList.size());
        return new ResponseEntity<>(customerEntityList, HttpStatus.OK);
    }

    @GetMapping(path = "/fetch/{id}")
    public ResponseEntity<CustomerEntity> fetchSingleCustomerBasedOnId(@PathVariable("id") int customerId) {

        CustomerEntity customer = customerManagementService.fetchSingleCustomerBasedOnId(customerId);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<CustomerEntity> updateSingleCustomerDetails(@RequestBody CustomerEntity customerEntity, @PathVariable int id) {

        CustomerEntity updatedCustomer = customerManagementService.updateSingleCustomerDetails(customerEntity, id);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<CustomerEntity> deleteSingleCustomer(@PathVariable("id") Integer customerId) {
        CustomerEntity deletedCustomer = customerManagementService.deleteSingleCustomer(customerId);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }

}
