package Cagas_Christian_Daniel_A_High;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Billable[] list = {
            new DocumentParcel("PH-1001", 0.5, true),
            new DocumentParcel("PH-1002", 0.2),
            new FragileParcel("PH-2001", 3.0, 10000),
            new FragileParcel("PH-2002", 5.0, 2500),
            new PickupService("Juan Dela Cruz", 50.00),
        };

        int userChoice = 0;

        do {

            String menuChoices[] = {
                "\n=====MENU=====",
                "1. Display all",
                "2. Search by keyword",
                "3. Show total and highest",
                "0. Exit",
            };

            for(int i = 0; i < menuChoices.length; i++) {
                System.out.println(menuChoices[i]);
            }

            System.out.print("Enter choice : ");

            try {
                userChoice = Integer.parseInt(s.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option.");
                continue;
            }

            switch (userChoice) {
                case 1:
                    for(Billable item : list) {
                        item.printReport();
                    }
                    break;

                case 2:
                    System.out.print("Enter keyword : ");
                    String keywordEntered = s.nextLine().trim().toLowerCase(Locale.ROOT);

                    boolean found = false;

                    for(Billable item : list) {
                        if (item.getLabel().toLowerCase(Locale.ROOT).contains(keywordEntered)) {
                            item.printReport();
                            found = true;
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    double highestFee = Double.NEGATIVE_INFINITY;
                    Billable highest = null;

                    for(Billable item : list) {
                        double fee = item.computeFee();

                        total += fee;

                        if (fee > highestFee) {
                            highestFee = fee;
                            highest = item;
                        }
                    }

                    System.out.printf("Total: %.2f%n", total);

                    if (highest != null) {
                        System.out.printf(
                            "Highest: %s (%.2f)%n", 
                            highest.getLabel(), 
                            highestFee
                        );
                    }
                    break;
                
                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (userChoice != 0);

        System.out.println("\n=== TASK 6 ===");

        Billable item2 = getItem(list, 2);
        System.out.println("getItem(2): ");

        if (item2 == null) {
            System.out.println("Invalid Selection");
        }else{
            item2.printReport();
        }


        Billable item10 = getItem(list, 10);
        System.out.println("getItem(10): ");

        if (item10 == null) {
            System.out.println("Invalid Selection");
        }else{
            item10.printReport();
        }


        Billable itemNegative = getItem(list, -1);
        System.out.println("getItem(-1): ");

        if (itemNegative == null) {
            System.out.println("Invalid Selection");
        }else{
            itemNegative.printReport();
        }


        System.out.println(
            "formatTracking(\" ph-1001 \") -> " + formatTracking(" ph-1001 ")
        );

        System.out.println(
            "Parcel count: " + Parcel.getParcelCount()
        );

        s.close();
    }

    public static Billable getItem(Billable[] items, int index) {

        if (items == null || index < 0 || index >= items.length) {
            return null;
        }

        return items[index];
    }

    public static String formatTracking(String s) {
        if (s == null) {
            return "";
        }

        return s.trim().toUpperCase().replace("-", " | ");
    }

}


