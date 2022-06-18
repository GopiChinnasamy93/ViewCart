package com.shopping;

import java.util.Scanner;

public class Online {
	static Customer customer = null;
	static Scanner input = new Scanner(System.in);
	static int qty;
	static String productid;
	String choiceoption;

	public static void main(String[] args) {
		int choice = 0;

		do {
			System.out.println("""
					1.Add Cart
					2.View Cart
					3.Delete Items in Cart
					4.Delete Cart
					5.Exit
					""");
			System.out.println("Enter the Choice");
			String choiceoption = input.next();
			if (numberchecking(choiceoption) == true) {
				choice = Integer.parseInt(choiceoption);
				switch (choice) {
				case 1:

					showproduct(); // Showing all the products in product util list.
					if (customer == null) {
	
					customerdetails(); // Creating customer details if we adding first item.
					}
					productdetails(); // product details for adding in cart list
					addcart();
					break;
				case 2:
					viewcart();
					break;
				case 3:
					deleteitems();
					break;
				case 4:
					deletecart();
					break;
				default:
					System.out.println("Thank You!");

				}

			} else {
				System.out.println("Please enter the number");
				System.out.println();
			}

		} while (choice < 5);
	}

	static void showproduct() {
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s", "Product ID", "Product Make", "Model", "Color", "Price",
				"Stock Availble");
		System.out.println();
		for (Product p : ProductUtil.productlist) {
			System.out.printf("%-15s %-15s %-15s %-15s %-15d %-15d", p.getProductid(), p.getMake(), p.getModel(),
					p.getColor(), p.getPrice(), p.getQoh());
			System.out.println();
		}
	}

	private static void customerdetails() {

		String id;
		String name;
		String city;
		System.out.println("Enter Customer ID : ");
		id = input.next();
		System.out.println("Enter Customer Name : ");
		name = input.next();
		System.out.println("Enter City Name");
		city = input.next();
		customer = new Customer(id, name, city);

	}

	private static void productdetails() {
		System.out.println("Enter Product id");
		productid = input.next();
		System.out.println("Enter Qty");
		qty = input.nextInt();

	}

	private static void addcart() {
		if (ProductUtil.productidavailble(productid) == true) // To check whether the product available or not in
																// product list.
		{
			Cart cart = new Cart(productid, ProductUtil.getmake(productid), ProductUtil.model(productid),
					ProductUtil.color(productid), ProductUtil.price(productid), qty);
			if (ProductUtil.Qty(productid) >= qty) // To check whether the Qty is higher or lesser than stock available.
			{
				CartUtilList.add(cart); // Adding in cart list.
				ProductUtil.find(productid).setQoh(ProductUtil.Qty(productid) - qty); // Decreasing Qty in product list
																						// after Qty added in cart list
			} else {
				System.out.printf("The Qty is higher than Stock Available.Stock Available : %d",
						ProductUtil.Qty(productid));
			}
		} else {
			System.out.println("The product id not available in product list ");
			System.out.println();
		}
	}

	private static void viewcart() {
		if (CartUtilList.cartlist.size() > 0) {
			System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s", "Product ID", "Make", "Model", "Color", "Price",
					"Qty");
			System.out.println();

			for (Cart cart : CartUtilList.cartlist) {
				System.out.printf("%-15s %-15s %-15s %-15s %-15d %-15d", cart.getProductid(), cart.getMake(),
						cart.getModel(), cart.getColor(), cart.getPrice(), cart.getQty());
				System.out.println();
			}
			System.out.println();
		} else {
			System.out.println("Cart List is Empty");
			System.out.println();
		}

	}

	private static void deleteitems() {

		System.out.println("Enter Product id");
		String id = input.next();
		CartUtilList.remove(id);

	}

	private static void deletecart() {
		CartUtilList.removecart();
	}

	static boolean numberchecking(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;

		}
		return true;

	}

}
