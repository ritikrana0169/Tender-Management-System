package com.tender.MainUi;

import java.util.Scanner;

import com.tender.controller.AdminController;
import com.tender.controller.LoginController;
import com.tender.controller.VendorController;

public class MainUi {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	try {
		int i=0;
		while(i!=9) {
			System.out.println("1: Administrator");
			System.out.println("2: Vendor");
			System.out.println("9: Exit");
			i=sc.nextInt();
			switch(i) {
			case 1:
				if(new LoginController().adminLogin(sc)) {
					new AdminController().administratorMethod(sc);	
				}else {
					System.out.println("Wrong Credentials");
				}
				break;
			case 2:
				new VendorController().vendorMethod(sc);
				
				break;
			case 9:
				System.out.println("Program End");
				break;
			}
		}		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Program Ended");
	}

}
}
