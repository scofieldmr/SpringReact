package com.project.services;

import com.project.dto.CustomerDTO;
import com.project.dto.CustomerSaveDTO;
import com.project.dto.CustomerUpdateDTO;
import com.project.entity.Customer;
import com.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addNewCustomer(CustomerSaveDTO customerSaveDTO){

        Customer newCustomer = new Customer(customerSaveDTO.getCustomername(),customerSaveDTO.getAge()
                                 ,customerSaveDTO.getCity(),customerSaveDTO.getMobile());

        customerRepository.save(newCustomer);

        return newCustomer;
    }

    public List<CustomerDTO> getAllCustomer(){
        List<Customer>  allcust =  customerRepository.findAll();

        List<CustomerDTO> allcustdto = new ArrayList<>();

        for(Customer c: allcust){
            CustomerDTO customerDTO = new CustomerDTO(
               c.getCustomerid(), c.getCustomername(),c.getAge(),c.getCity(),c.getMobile()
            );

            allcustdto.add(customerDTO);
        }

        return allcustdto;
    }

    public CustomerDTO getCustomer(long id){
        Customer c = customerRepository.findById(id).get();

        CustomerDTO customerDTO = new CustomerDTO(
          c.getCustomerid(),c.getCustomername(),c.getAge(),c.getCity(),c.getMobile()
        );

        return customerDTO;
    }

    public Customer updateCustomer(CustomerUpdateDTO customerUpdateDTO,long id){

        if(customerRepository.existsById(id)){

            Customer c = customerRepository.findById(id).get();

            c.setCustomername(customerUpdateDTO.getCustomername());
            c.setAge(customerUpdateDTO.getAge());
            c.setCity(customerUpdateDTO.getCity());
            c.setMobile(customerUpdateDTO.getMobile());

            customerRepository.save(c);
            return c;
        }
        else{
            return null;
        }

    }

    public boolean deleteCustomer(Long id) {

        Optional<Customer> dcustomer = customerRepository.findById(id);

        if(dcustomer.isEmpty()){
            return false;
        }

        customerRepository.deleteById(id);
        return true;
    }
}
