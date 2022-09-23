package com.itss.bdctdemo.scheduler;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.itextpdf.text.DocumentException;
import com.itss.bdctdemo.repository.CustomerRepository;
import com.itss.bdctdemo.service.CustomerSQLLoaderService;
import com.itss.bdctdemo.service.CustomerService;

@Component
@EnableScheduling
public class CustomerScheduler {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerSQLLoaderService customerSQLLoaderService;

	// @Scheduled(fixedRate = 10000)
	public void prepareCustomerDetailsCSV() {
		customerService.prepareCustomerDetailsCSV();
	}

	@Scheduled(fixedRate = 10000)
	public void prepareCustomersCSV() {
		customerService.PrepareCustomersCSV();
	}

	@Scheduled(fixedRate = 15000)
	public void loadCustomersbySQLLoader() throws IOException {
		File file = new File("C:/Projects/HongKong_BCT/POC_SpringBoot/SQLLoaderFiles/IN");
		if (file.exists() && file.isDirectory()) {
			File[] FileList = file.listFiles();
			for (int i = 0; i < FileList.length; i++) {
				String sss=FileList[i].getName().replace(".csv","");				
					customerSQLLoaderService.executeSQLLoader(sss);			
					FileList[i].renameTo(new File(
						"C:/Projects/HongKong_BCT/POC_SpringBoot/SQLLoaderFiles/Loaded/" + FileList[i].getName()));
			}
		} else {
			System.out.println("Directory Not Present");
		}
	}

	@Scheduled(fixedRate = 10000)
	public void prepareCustomerDetailsPDF() throws DocumentException, IOException {
		customerService.prepareCustomerDetailsPDF();
	}

}
