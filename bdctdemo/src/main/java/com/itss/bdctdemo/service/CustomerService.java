package com.itss.bdctdemo.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import com.opencsv.CSVWriter;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Autowired
	private CustomerCommunicationRepository customerCommunicationRepository;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");

	public List<CustomerDetails> getCustomerDetails() {
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerRepository.findAll();

		List<CustomerDetails> customerDetails = new ArrayList<CustomerDetails>();
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()) {
			Customer cust = (Customer) it.next();
			CustomerDetails custdetails = new CustomerDetails();
			custdetails.setCustomerID(cust.getCustomerID());
			custdetails.setPassword(cust.getPassword());
			custdetails.setFirstName(cust.getFirstName());
			custdetails.setLastName(cust.getLastName());
			custdetails.setGender(cust.getGender());
			custdetails.setEnabled(cust.getEnabled());
			custdetails.setAccountNonExpired(cust.getAccountNonExpired());
			custdetails.setCredentialsNonExpired(cust.getCredentialsNonExpired());
			custdetails.setAccountNonLocked(cust.getAccountNonLocked());

			Optional<CustomerAddress> caopt = customerAddressRepository.findById(cust.getCustomerID());
			if (caopt.isPresent()) {
				CustomerAddress custAdd = caopt.get();
				custdetails.setStreet(custAdd.getStreet());
				custdetails.setHouseNo(custAdd.getHouseNo());
				custdetails.setCity(custAdd.getCity());
				custdetails.setPinCode(custAdd.getPinCode());
				custdetails.setCountry(custAdd.getCountry());
			} else {
				custdetails.setStreet("");
				custdetails.setHouseNo("");
				custdetails.setCity("");
				custdetails.setPinCode("");
				custdetails.setCountry("");
			}
			Optional<CustomerCommunication> ccoptt = customerCommunicationRepository.findById(cust.getCustomerID());
			if (ccoptt.isPresent()) {
				CustomerCommunication custcomm = ccoptt.get();
				custdetails.setEmailId(custcomm.getEmailId());
				custdetails.setCountryCode(custcomm.getCountryCode());
				custdetails.setPhoneNo(custcomm.getPhoneNo());
			} else {
				custdetails.setEmailId("");
				custdetails.setCountryCode("");
				custdetails.setPhoneNo("");
			}
			customerDetails.add(custdetails);
		}
		return customerDetails;
	}

	public void prepareCustomerDetailsCSV() {
		String filePath = "C:/Projects/HongKong_BCT/POC_SpringBoot/GeneratedFiles/CustomerDetails_"
				+ dateFormat.format(new Date()) + ".csv";
		List<CustomerDetails> custDetails = getCustomerDetails();
		File file = new File(filePath);
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] header = { "CUSTOMER_ID", "PASSWORD", "FIRST_NAME", "LAST_NAME", "GENDER", "ENABLED",
					"ACCOUNT_NON_EXPIRED", "CREDENTIALS_NON_EXPIRED", "ACCOUNT_NON_LOCKED", "STREET", "HOUSENO", "CITY",
					"PINCODE", "COUNTRY", "EMAIL_ID", "COUNTRY_CODE", "PHONE_NO" };
			writer.writeNext(header);
			Iterator<CustomerDetails> it = custDetails.iterator();
			while (it.hasNext()) {
				CustomerDetails cd = it.next();
				List<String> zoom = new ArrayList<>();
				zoom.add(cd.getCustomerID());
				zoom.add(cd.getPassword());
				zoom.add(cd.getFirstName());
				zoom.add(cd.getLastName());
				zoom.add(cd.getGender());
				zoom.add(cd.getEnabled());
				zoom.add(cd.getAccountNonExpired());
				zoom.add(cd.getCredentialsNonExpired());
				zoom.add(cd.getAccountNonLocked());
				zoom.add(cd.getStreet());
				zoom.add(cd.getHouseNo());
				zoom.add(cd.getCity());
				zoom.add(cd.getPinCode());
				zoom.add(cd.getCountry());
				zoom.add(cd.getEmailId());
				zoom.add(cd.getCountryCode());
				zoom.add(cd.getPhoneNo());

				String[] stockArr = new String[zoom.size()];
				stockArr = zoom.toArray(stockArr);

				writer.writeNext(stockArr);
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void PrepareCustomersCSV() {
		String filePath = "C:/Projects/HongKong_BCT/POC_SpringBoot/GeneratedFiles//Customers_"
				+ dateFormat.format(new Date()) + ".csv";
		List<Customer> cust = customerRepository.findAll();
		File file = new File(filePath);
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] header = { "CUSTOMER_ID", "PASSWORD", "FIRST_NAME", "LAST_NAME", "GENDER", "ENABLED",
					"ACCOUNT_NON_EXPIRED", "CREDENTIALS_NON_EXPIRED", "ACCOUNT_NON_LOCKED" };
			writer.writeNext(header);
			Iterator<Customer> it = cust.iterator();
			while (it.hasNext()) {
				Customer cd = it.next();
				List<String> zoom = new ArrayList<>();
				zoom.add(cd.getCustomerID());
				zoom.add(cd.getPassword());
				zoom.add(cd.getFirstName());
				zoom.add(cd.getLastName());
				zoom.add(cd.getGender());
				zoom.add(cd.getEnabled());
				zoom.add(cd.getAccountNonExpired());
				zoom.add(cd.getCredentialsNonExpired());
				zoom.add(cd.getAccountNonLocked());

				String[] stockArr = new String[zoom.size()];
				stockArr = zoom.toArray(stockArr);

				writer.writeNext(stockArr);
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String createCustomer(CustomerBean customerBean) {
		Customer cust = new Customer();
		cust.setCustomerID(customerBean.getCustomerID());
		cust.setPassword(customerBean.getPassword());
		cust.setFirstName(customerBean.getFirstName());
		cust.setLastName(customerBean.getLastName());
		cust.setGender(customerBean.getGender());
		cust.setEnabled(customerBean.getEnabled());
		cust.setAccountNonExpired(customerBean.getAccountNonExpired());
		cust.setCredentialsNonExpired(customerBean.getCredentialsNonExpired());
		cust.setAccountNonLocked(customerBean.getAccountNonLocked());
		customerRepository.save(cust);
		return "{status : success}";
	}

	public String deleteCustomer(String CustID) {
		customerRepository.deleteById(CustID);
		return "{status : success}";
	}
	
	
	
	public String createCustomerAddress(CustomerAddressBean customerAddressBean) {
		CustomerAddress cust = new CustomerAddress();
		cust.setCustomerID(customerAddressBean.getCustomerID());
		cust.setStreet(customerAddressBean.getStreet());
		cust.setHouseNo(customerAddressBean.getHouseNo());
		cust.setCity(customerAddressBean.getCity());
		cust.setPinCode(customerAddressBean.getPinCode());
		cust.setCountry(customerAddressBean.getCountry());
		customerAddressRepository.save(cust);
		return "{status : success}";
	}

	public String deleteCustomerAddress(String CustID) {
		customerAddressRepository.deleteById(CustID);
		return "{status : success}";
	}
	
	
	public String createCustomerCommunication(CustomerCommunicationBean customerCommunicationBean) {
		CustomerCommunication cust = new CustomerCommunication();
		cust.setCustomerID(customerCommunicationBean.getCustomerID());
		cust.setEmailId(customerCommunicationBean.getEmailId());
		cust.setCountryCode(customerCommunicationBean.getCountryCode());
		cust.setPhoneNo(customerCommunicationBean.getPhoneNo());
		customerCommunicationRepository.save(cust);
		return "{status : success}";
	}

	public String deleteCustomerCommunication(String CustID) {
		customerCommunicationRepository.deleteById(CustID);
		return "{status : success}";
	}
	
	

	public void prepareCustomerDetailsPDF() throws DocumentException, IOException {

		Document document = new Document();

		String filePath = "C:/Projects/HongKong_BCT/POC_SpringBoot/GeneratedFiles/CustomerDetails_"
				+ dateFormat.format(new Date()) + ".pdf";

		OutputStream outputStream = new FileOutputStream(new File(filePath));
		PdfWriter.getInstance(document, outputStream);
		document.open();

		document.add(new Paragraph(
				"'CUSTOMER_ID', 'PASSWORD', 'FIRST_NAME', 'LAST_NAME', 'GENDER', 'ENABLED','ACCOUNT_NON_EXPIRED', 'CREDENTIALS_NON_EXPIRED', 'ACCOUNT_NON_LOCKED'"));

		List<CustomerDetails> custDetails = getCustomerDetails();
		Iterator<CustomerDetails> it = custDetails.iterator();
		while (it.hasNext()) {
			CustomerDetails cd = it.next();
			String newPara=cd.getCustomerID()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getPassword()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getFirstName()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getLastName()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getGender()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getEnabled()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getAccountNonExpired()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getCredentialsNonExpired()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getAccountNonLocked()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getStreet()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getHouseNo()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getCity()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getPinCode()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getCountry()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getEmailId()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getCountryCode()+CSVWriter.DEFAULT_SEPARATOR+
					cd.getPhoneNo()+CSVWriter.DEFAULT_SEPARATOR;
			document.add(new Paragraph(newPara));
		}
		document.close();
		outputStream.close();

	}
}
