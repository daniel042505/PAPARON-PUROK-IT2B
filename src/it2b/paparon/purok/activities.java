
package it2b.paparon.purok;
import java.util.Scanner;

public class activities {
   
    public void menu(Scanner sc) {
        int choice;
        do {
            System.out.println("|---------------------------------------------|");
            System.out.println("|                  Activities                 |");
            System.out.println("|---------------------------------------------|");
            System.out.println("1. Add Activity");
            System.out.println("2. View All Activities");
            System.out.println("3. View Activities by Person ID");
            System.out.println("4. View Attendees by Activity ID");
            System.out.println("5. View All Activities with Attendees");
            System.out.println("6. Update Activity");
            System.out.println("7. Delete Activity");
            System.out.println("8. Back to Main Menu");
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
                    viewActivitiesByPerson(sc);
                    break;
                case 4:
                    viewAttendeesByActivity(sc);
                    break;
                case 5:
                    viewAllActivitiesWithAttendees();
                    break;
                case 6:
                    updateActivities(sc);
                    break;
                case 7:
                    deleteActivities(sc);
                    break;
                case 8:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 8);
    }

    public void addActivity(Scanner sc) {
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

    public void viewActivities() {
        String sqlQuery = "SELECT * FROM tbl_activities";
        String[] columnHeaders = {"ID", "Activity Name", "Date", "Location"};
        String[] columnNames = {"s_id", "s_name", "s_date", "s_loc"};
        
        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }

   public void viewActivitiesByPerson(Scanner sc) {
    System.out.print("Enter Person ID to view their activities: ");
    int personId = sc.nextInt();
    
    String sqlQuery = "SELECT a.s_id, a.s_name, a.s_date, a.s_loc " +
                      "FROM tbl_activities a " +
                      "JOIN tbl_attendees at ON a.s_id = at.activity_id " +
                      "WHERE at.person_id = ?";
    String[] columnHeaders = {"Activity ID", "Activity Name", "Date", "Location"};
    String[] columnNames = {"s_id", "s_name", "s_date", "s_loc"};

    config conf = new config();
    conf.viewRecords(sqlQuery, columnHeaders, columnNames, personId);
}


    public void viewAttendeesByActivity(Scanner sc) {
        System.out.print("Enter Activity ID to view attendees: ");
        int activityId = sc.nextInt();
        
        String sqlQuery = "SELECT p.s_id, p.s_fname, p.s_lastname " +
                          "FROM tbl_members p " +
                          "JOIN tbl_attendees at ON p.s_hid = at.person_id " +
                          "WHERE at.activity_id = ?";
        String[] columnHeaders = {"Person ID", "First Name", "Last Name"};
        String[] columnNames = {"s_id", "s_fname", "s_lastname"};

        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames, activityId);
    }

    public void viewAllActivitiesWithAttendees() {
        String sqlQuery = "SELECT a.s_id, a.s_name, a.s_date, a.s_loc, p.s_id AS person_id, p.s_fname, p.s_lastname " +
                          "FROM tbl_activities a " +
                          "LEFT JOIN tbl_attendees at ON a.s_id = at.activity_id " +
                          "LEFT JOIN tbl_members p ON at.person_id = p.s_hid";
        
        String[] columnHeaders = {"Activity ID", "Activity Name", "Date", "Location", "Person ID", "First Name", "Last Name"};
        String[] columnNames = {"s_id", "s_name", "s_date", "s_loc", "person_id", "s_fname", "s_lastname"};

        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }

    public void updateActivities(Scanner sc) {
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

    public void deleteActivities(Scanner sc) {
        System.out.print("Enter the Activity ID to Delete: ");
        int id = sc.nextInt();
        String qry = "DELETE FROM tbl_activities WHERE s_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}




