package com.shopping;

import java.util.ArrayList;
import java.util.List;

public class ProductUtil {
	static List<Product>productlist=new ArrayList<>();
	
	static {
		productlist.add(new Product("P101", "Redmi", "9i", "Black", 9000, 20));
		productlist.add(new Product("P102", "Redmi", "6i", "Black", 11000, 20));
		productlist.add(new Product("P103", "Redmi", "10 pro", "Black", 12000, 20));
		productlist.add(new Product("P104", "Redmi", "9i", "Black", 9500, 20));
		productlist.add(new Product("P105", "Samsung", "Galaxy", "Black", 20000, 20));
		productlist.add(new Product("P106", "Samsung", "9i", "Galaxy", 34000, 20));
		productlist.add(new Product("P107", "Nokia", "9i", "Ci-300", 9300, 20));
	}

	
	static Product find(String id) {
		Product cart=null;
		for(Product pro:productlist) {
			 if(pro.getProductid().equalsIgnoreCase(id)){
				 cart=pro;
				 break;
			 }
			 
		}
		return cart; 
	}
	static boolean productidavailble(String id) {
		int b=0;
		for(Product pro:productlist) {
			 if(pro.getProductid().equalsIgnoreCase(id)){
				b=1;
				 break;
			 }}
		if (b==1) {
			return true;
		}
		else {
	
	
		return false;
		
		
		}
		
		
	}
	static String getmake(String id) {
		return find(id).getMake();		
	}
	static String model(String id) {
		return find(id).getModel();		
	}
	static String color(String id) {
			
		return find(id).getColor();		
	}
	static int price(String id) {
		return find(id).getPrice();
	}
	static int Qty(String id) {
		
		return find(id).getQoh();	
	}
	
}
	