
package it2b.paparon.purok;
import java.util.Scanner;

public class IT2BPAPARONPUROK {

    public static void main(String[] args) {
        int cho;
        int choice;
        Scanner sc = new Scanner(System.in);
        
        do{
            
            System.out.println("  |---------------------------------------------|");
            System.out.println("1.|                   Members                   |");
            System.out.println("2.|                  Activities                 |");
            System.out.println("3.|                    Exit                     |");
            System.out.println("  |---------------------------------------------|");
            System.out.println("Enter choice:  ");
            cho = sc.nextInt();
           
                
            
            
          if (cho == 1) {
                do {
                    System.out.println("|---------------------------------------------|");
                    System.out.println("|                   Members                   |");
                    System.out.println("|---------------------------------------------|");
                    System.out.println("1. Add Members");
                    System.out.println("2. View Members");
                    System.out.println("3. Update Members");
                    System.out.println("4. Delete Members");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();  

                    switch (choice) {
                        case 1:
                            addMembers(sc);
                            break;
                        case 2:
                            viewMembers();
                            break;
                        case 3:
                            updateMembers();
                            break;
                        case 4:
                            deleteMembers();
                            break;
                        case 5:
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }
               } while (choice != 5);
            } else if (cho == 2) {
                do {
                    System.out.println("|---------------------------------------------|");
                    System.out.println("|                  Activities                 |");
                    System.out.println("|---------------------------------------------|");
                    System.out.println("1. Add Activity");
                    System.out.println("2. View Activities");
                    System.out.println("3. Update Activity");
                    System.out.println("4. Delete Activity");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();  

                    switch (choice) {
                        case 1:
                            addActivity(sc);
                            break;
                        case 2:
                            viewActivities();
                            break;
                        case 3:
                            updateActivities(sc);
                            break;
                        case 4:
                            deleteActivities(sc);
                            break;
                        case 5:
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }
                } while (choice != 5);
            } else if (cho == 3) {
                System.out.println("Thank you! Exiting program.");
            } else {
                System.out.println("Invalid choice, please try again.");
            }

        } while (cho != 3);
        
        sc.close();
    }

 
        

    
      public static void addMembers(Scanner sc) {
        System.out.print("Enter First Name: ");
        String fname = sc.next();
        System.out.print("Enter Last Name: ");
        String lname = sc.next();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Gender: ");
        String Gender = sc.next();
        System.out.println("Status:  ");
        String status = sc.next();
        config conf = new config();
        String sql = "INSERT INTO tbl_members (s_fname, s_lastname, s_age, s_gender, s_Status) VALUES (?, ?, ?, ?, ? )";
        conf.addRecord(sql, fname, lname, age, Gender, status);
    }

    public static void viewMembers() {
        String sqlQuery = "SELECT * FROM tbl_members";
        String[] columnHeaders = {"ID", "FirstName", "Lastname", "Age", "Gender", "Status"};
        String[] columnNames = {"s_hid", "s_fname", "s_lastname", "s_age", "s_gender", "s_Status"};
           
        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    
}
    
     public static void updateMembers(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        System.out.print("Enter new First Name: ");
        String nfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.next();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Gender: ");
        String gend = sc.next();
        System.out.print("Enter new Status: ");
        String nstatus = sc.next();
        
        String qry = "UPDATE tbl_members SET s_fname = ?, s_lastname = ?, s_age = ?, s_gender = ?, s_Status = ? WHERE s_hid = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, age, gend, nstatus, id);
        
    }
     public static void deleteMembers(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_members WHERE s_hid = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    
    }
public static void addActivity(Scanner sc) {
        System.out.print("Enter Activity Name: ");
        String activityName = sc.nextLine();
        System.out.print("Enter Activity Date: ");
        String activityDate = sc.nextLine();
        System.out.print("Enter Activity Location: ");
        String activityLocation = sc.nextLine();
        config conf = new config();
        String sql = "INSERT INTO tbl_activities (s_name, s_date, s_loc) VALUES (?, ?, ?)";
        conf.addRecord(sql, activityName, activityDate, activityLocation);
    }

    public static void viewActivities() {
        String sqlQuery = "SELECT * FROM tbl_activities";
        String[] columnHeaders = {"ID", "Activity Name", "Date", "Location"};
        String[] columnNames = {"s_id", "s_name", "s_date", "s_loc"};
        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }

    public static void updateActivities(Scanner sc) {
        System.out.print("Enter the Activity ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  
        System.out.print("Enter new Activity Name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new Activity Date: ");
        String newDate = sc.nextLine();
        System.out.print("Enter new Activity Location: ");
        String newLocation = sc.nextLine();

        String qry = "UPDATE tbl_activities SET s_name = ?, s_date = ?, s_loc = ? WHERE s_id = ?";
        config conf = new config();
        conf.updateRecord(qry, newName, newDate, newLocation, id);
    }

    public static void deleteActivities(Scanner sc) {
        System.out.print("Enter the Activity ID to Delete: ");
        int id = sc.nextInt();
        String qry = "DELETE FROM tbl_activities WHERE s_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}