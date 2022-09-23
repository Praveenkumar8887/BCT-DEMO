package com.itss.bdctdemo.controller;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.itss.bdctdemo.entitybeans.Customer;
import com.itss.bdctdemo.entitybeans.CustomerAddress;
import com.itss.bdctdemo.entitybeans.CustomerAddressBean;
import com.itss.bdctdemo.entitybeans.CustomerBean;
import com.itss.bdctdemo.entitybeans.CustomerCommunication;
import com.itss.bdctdemo.entitybeans.CustomerCommunicationBean;
import com.itss.bdctdemo.entitybeans.CustomerDetails;
import com.itss.bdctdemo.repository.CustomerAddressRepository;
import com.itss.bdctdemo.repository.CustomerCommunicationRepository;
import com.itss.bdctdemo.repository.CustomerRepository;
import com.itss.bdctdemo.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	private CustomerCommunicationRepository customerCommunicationRepository;

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers() throws URISyntaxException {
		return customerRepository.findAll();
	}
	
	@RequestMapping(value = "/getCustomerAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerAddress> getCustomerAddress() throws URISyntaxException {
		return customerAddressRepository.findAll();
	}
	
	@RequestMapping(value = "/getCustomerCommunication", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerCommunication> getCustomerCommunication() throws URISyntaxException {
		return customerCommunicationRepository.findAll();
	}

	@RequestMapping(value = "/getCustomerDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDetails> getCustomerDetails() throws URISyntaxException {
		return customerService.getCustomerDetails();
	}
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody CustomerBean customerBean) {
		return customerService.createCustomer(customerBean);
	}
	
	@RequestMapping(value = "/deleteCustomer/{custid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomer(@PathVariable("custid") String filter) {
		return customerService.deleteCustomer(filter);
	}
	
	@RequestMapping(value = "/createCustomerAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomerAddress(@RequestBody CustomerAddressBean customerAddressBean) {
		return customerService.createCustomerAddress(customerAddressBean);
	}
	
	@RequestMapping(value = "/deleteCustomerAddress/{custid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomerAddress(@PathVariable("custid") String filter) {
		return customerService.deleteCustomerAddress(filter);
	}
	
	@RequestMapping(value = "/createCustomerCommunication", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomerCommunication(@RequestBody CustomerCommunicationBean customerCommunicationBean) {
		return customerService.createCustomerCommunication(customerCommunicationBean);
	}
	
	@RequestMapping(value = "/deleteCustomerCommunication/{custid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomerCommunication(@PathVariable("custid") String filter) {
		return customerService.deleteCustomerCommunication(filter);
	}
}
