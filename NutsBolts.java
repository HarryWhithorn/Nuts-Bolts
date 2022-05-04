/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuts.bolts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author m1900400
 */
public class NutsBolts {

    static Scanner SC = new Scanner(System.in);
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        menu();

    }

    public static void menu() throws FileNotFoundException, IOException {

        int choice = 0;

        do {
            System.out.println(
                    "Please select an option below\n"
                    + "1. Enter a new product\n"
                    + "2. Search for a product\n"
                    + "3. Remove a Product\n"
                    + "4.Exit");
            while (!SC.hasNextInt()) {
                System.out.println("Must be an integer");
                SC.next();
            }
            choice = SC.nextInt();
            SC.next();
            if (choice == 1) {
                addProduct();
                break;
            } else if (choice == 2) {
                productSearch();
                break;
            } else if (choice == 3) {
                removeProducts();
                break;
            } else if (choice == 4) {
                break;
            }
        } while (choice != 0);

    }

    public static void addProduct() throws FileNotFoundException, IOException {

        String productID;
        System.out.println("Enter Product ID.");
        productID = SC.next();

        String name;
        System.out.println("Enter the Product name.");
        name = SC.next();

        String department;
        System.out.println("Enter the department.");
        department = SC.next();

        String location;
        System.out.println("Enter the location.");
        location = SC.next();

        String quant;
        System.out.println("Enter the quantity of the Product.");
        quant = SC.next();

        try (FileWriter fw = new FileWriter("warehouse.txt", true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(productID + "," + name + "," + department + "," + location + "," + quant);
            //bw.newLine();

        } catch (IOException e) {

        }

    }

    public static void productSearch() throws FileNotFoundException, IOException {

        String productSearch;
        System.out.println("Enter the product ID.");
        productSearch = SC.next();

        String nameSearch;
        System.out.println("Enter the name of the product.");
        nameSearch = SC.next();

        BufferedReader br = new BufferedReader(new FileReader("Warehouse.txt"));

        boolean found = false;
        Scanner line = new Scanner(new File("\\I:\\Documents\\NetBeansProjects\\Nuts&Bolts\\Warehouse.txt"));
        String foundWord = productSearch;
        while (line.hasNextLine()) {

            String[] reader = line.nextLine().split(",");

            for (String word : reader) {
                if (word.equals(foundWord)) {

                    found = true;
                    String productID = reader[0];
                    String name = reader[1];
                    String department = reader[2];
                    String location = reader[3];
                    String quant = reader[4];
                    System.out.println(productID + "\t" + name + "\t"
                            + department + "\t" + location + "\t" + quant);
                }
            }
        }
        if (!found) {
            System.out.println(foundWord + "not found");

        }

    }

    public static void removeProducts() throws FileNotFoundException, IOException {
        
        
        
    }
        
        
}
