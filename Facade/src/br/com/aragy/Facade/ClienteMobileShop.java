package br.com.aragy.Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClienteMobileShop {

	private static int choice;

	public static void main(String args[]) throws NumberFormatException, IOException {

		do {
			System.out.print("========= Mobile Shop ============ \n");
			System.out.print("            1. IPHONE.             \n");
			System.out.print("            2. SAMSUNG.            \n");
			System.out.print("            3. BLACKBERRY.         \n");
			System.out.print("            4. Exit.               \n");
			System.out.print("Entre com sua escolha: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			ShopKeeper sk = new ShopKeeper();
			switch (choice) {
			case 1:
				sk.iphoneSale();			
				break;
			case 2:			
				sk.samsungSale();			
				break;
			case 3:
				sk.blackberrySale();
				break;
			default: 
				System.out.println("Nada foi Comprado");			
				return;
			}
		} while (choice != 4);
	}
}