package com.itss.bdctdemo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class CustomerSQLLoaderService {

	public void executeSQLLoader(String fileName) {
		String abcd = "sqlldr  userid=praveen/praveen control=C:/Projects/HongKong_BCT/POC_SpringBoot/SQLLoaderFiles/"+fileName
				+ ".ctl log=C:/Projects/HongKong_BCT/POC_SpringBoot/SQLLoaderFiles/SQLLoaderlog_"+fileName+".log";		
		try {
			Process p = Runtime.getRuntime().exec(abcd);
			p.waitFor();
		
		} catch (IOException e) {
			System.out.println(e.getMessage());			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
