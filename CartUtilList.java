package com.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CartUtilList {
	static List<Cart>cartlist=new ArrayList<>();
	static Scanner input=new Scanner(System.in);
	
	
	public static void add(Cart cart) {
		Cart tem=null;
		
			for(Cart cart1: cartlist) {
					if(cart1.getProductid().equals(cart.getProductid()) && cart1.getPrice()==cart.getPrice()){
					tem=cart1;
					break;}}
			if(tem==null) {                                   // Checking product id available in cart list
				cartlist.add(cart);
				System.out.println("Cart Added ");
				System.out.println();}
				else {
					
				int temp=tem.getQty()+cart.getQty();                // if already available , then increasing Qty in cart list           
				tem.setQty(temp);
				System.out.println("Product available in cart list. Qty increased");
				System.out.println();
				}
					
				
	}
	
	static void remove(String id) {
		Cart temp=null;
		for (Cart cart: cartlist) {
			if(cart.getProductid().equalsIgnoreCase(id)) {
				temp=cart;
			}
		}
		if(temp==null) {
			System.out.println(" The product ID is not available in cart list");
		}
		else {
			
			System.out.println("Enter the removing Qty ");
			int qty=input.nextInt();
			if(temp.getQty()>=qty) {
				temp.setQty(temp.getQty()-qty);	
				int setq=ProductUtil.find(id).getQoh()+qty;
			
				ProductUtil.find(id).setQoh(setq);
				
				if(temp.getQty()==0) {
					cartlist.remove(temp);
				}
			}else
			{
				System.out.println("The removing Qty is higher than product Qty in cart");
			}
			
		}
	}
	
	
	
	static void removecart() {
		
		if(cartlist.size()==0) {
			System.out.println("Cart List is Empty");
		}else {
		
		for(Cart cart:cartlist) {		
			int q=ProductUtil.find(cart.getProductid()).getQoh()+cart.getQty();
			ProductUtil.find(cart.getProductid()).setQoh(q);
			cart.setQty(0);
		}
	for(int i=cartlist.size()-1;i>=0;i--) {
		cartlist.remove(i);
		}		
		
		System.out.println("All Items removed from Cart ");
		System.out.println();
		}	
}
}