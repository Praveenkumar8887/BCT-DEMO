package com.itss.bdctdemo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itss.bdctdemo.entitybeans.CustomerAddress;
import com.itss.bdctdemo.repository.CustomerAddressRepository;

@RestController
public class CustomerAddressController {

	@Autowired
	CustomerAddressRepository customerAddressRepository;

	@RequestMapping(value = "/getCustomerAddresses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerAddress> getCustomerAddresses() throws URISyntaxException {
		return customerAddressRepository.findAll();
	}

}
