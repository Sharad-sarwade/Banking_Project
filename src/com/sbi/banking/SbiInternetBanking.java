package com.sbi.banking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class SbiInternetBanking {

	public static void main(String[] args) throws IOException {
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\demo.properties");
		
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			
			System.out.println(e);
		}
		String userName = p.getProperty("userName");
		String password = p.getProperty("password");
		String name = p.getProperty("name");
		String accNum=p.getProperty("accNum");
		String ifsc =p.getProperty("IFSC");
		String cifs =p.getProperty("CIFS");
		String bal=p.getProperty("bal");
		String stmt1=p.getProperty("StatementLine1");
		String stmt2=p.getProperty("StatementLine2");
		String stmt3=p.getProperty("StatementLine3");
		String stmt4=p.getProperty("StatementLine4");
		
		Bank_Operations bankOperation=new Bank_Operations();
	
				System.out.println("SBI Banking");
				System.out.println("Enter user name");
				Scanner sc = new Scanner(System.in);
				String enteredUserId  = sc.next();
					
				System.out.println("Please Enter Password");
				String enteredPassword=sc.next();
							
		//	if(true) {
				if(enteredUserId.equals(userName) && (enteredPassword.equals(password))) {
					System.out.println("Login Successfull.....");
					Bank_Operations.banking(bal,name,accNum,ifsc,cifs,userName,password,stmt1,stmt2,stmt3,stmt4);

				}
				else {
					System.out.println("please enter correct user name or password...");
				}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}	}

	}


