
package it2b.paparon.purok;
import java.util.Scanner;

public class IT2BPAPARONPUROK {

    public static void main(String[] args) {

        int cho;
        Scanner sc = new Scanner(System.in);
        
        members members = new members();
        activities activities = new activities();

        do {
            System.out.println("  |---------------------------------------------|");
            System.out.println("1.|                   Members                   |");
            System.out.println("2.|                  Activities                 |");
            System.out.println("3.|                    Exit                     |");
            System.out.println("  |---------------------------------------------|");
            System.out.print("Enter choice:  ");
            cho = sc.nextInt();

            switch (cho) {
                case 1:
                    members.menu(sc);
                    break;
                case 2:
                    activities.menu(sc);
                    break;
                case 3:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (cho != 3);
        
        sc.close();
    }
}

        
              
          

 
        

    
   