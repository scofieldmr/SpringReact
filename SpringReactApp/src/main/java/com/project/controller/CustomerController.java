package com.project.controller;

import com.project.dto.CustomerDTO;
import com.project.dto.CustomerSaveDTO;
import com.project.dto.CustomerUpdateDTO;
import com.project.entity.Customer;
import com.project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    //To add new Customer details in the Database
    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){

        Customer cd = customerService.addNewCustomer(customerSaveDTO);

        if(cd!=null){
            return ResponseEntity.ok().body(cd);
        }

        return ResponseEntity.badRequest().body("Failed to Add Customer Details");

    }

    // To get all the customer details
    @GetMapping("/getAllCustomer")
    public ResponseEntity<?> allCustomers(){

        List<CustomerDTO> list = customerService.getAllCustomer();

        if(list.isEmpty()){
            return ResponseEntity.badRequest().body("No Details Found");
        }

        return ResponseEntity.ok().body(list);

    }

    //To update the customer details using the customer id
    @PostMapping("/updateCustomer/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO,
                                            @PathVariable(value = "id") Long id){

        Customer cd = customerService.updateCustomer(customerUpdateDTO,id);

        if(cd!=null){
            return ResponseEntity.ok().body(cd);
        }

        return ResponseEntity.badRequest().body("Failed to Update..Customer Details not found...");

    }

    //To delete the customer details using the customer id
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id){

        boolean customer = customerService.deleteCustomer(id);

        if(customer==false){
            return ResponseEntity.badRequest().body("No Content Found..");
        }

        return ResponseEntity.ok().body("Deleted Successfully...");


    }

}
