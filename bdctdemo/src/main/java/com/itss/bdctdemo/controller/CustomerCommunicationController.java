package com.itss.bdctdemo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itss.bdctdemo.entitybeans.CustomerCommunication;
import com.itss.bdctdemo.repository.CustomerCommunicationRepository;

@RestController
public class CustomerCommunicationController {

	@Autowired
	private CustomerCommunicationRepository customerCommunicationRepository;

	@RequestMapping(value = "/getCustomerCommunications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerCommunication> getCustomerCommunications() throws URISyntaxException {
		return customerCommunicationRepository.findAll();
	}
}
