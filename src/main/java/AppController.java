import java.sql.Connection;
import java.util.Scanner;

public class AppController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsertOperation insertOperation = new InsertOperation();
        ReadOperation readOperation = new ReadOperation();
        UpdateOperation updateOperation = new UpdateOperation();
        DeleteOperation deleteOperation = new DeleteOperation();
        while (true) {
            System.out.println("Enter from the following: ");
            System.out.println("1. Insert Data");
            System.out.println("2. Read Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Check Connection");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            try{
                switch (option) {
                    case 1: System.out.println("Choose from the following: ");
                            System.out.println("1. Insert Single Record");
                            System.out.println("2. Batch Upload Excel");
                            int insertOption = scanner.nextInt();
                            if (insertOption == 1) {
                                System.out.println("Enter the the record: ");
                                System.out.println("Name: ");
                                String name = scanner.next();
                                System.out.println("Email: ");
                                String email = scanner.next();
                                System.out.println("Address: ");
                                String address = scanner.next();
                                System.out.println("Password: ");
                                String password = scanner.next();
                                insertOperation.insertSingle(name, email, address, password);
                            }
                            if (insertOption == 2) {
                                System.out.println("Enter the excel path ");
                                String excelPath = scanner.next();
                                insertOperation.insertFromExcel(excelPath);
                            }
                            break;
                    case 2: System.out.println("Read all Data: ");
                            readOperation.readAll();
                            break;
                    case 3: System.out.println("Update Data: ");
                            System.out.println("Enter the user Id: ");
                            int userId = scanner.nextInt();
                            updateOperation.update(userId);
                            break;
                    case 4: System.out.println("Delete Data: ");
                            deleteOperation.delteOperation();
                            break;
                    case 5: System.out.println("Check Connection: ");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            Connection conn = databaseConnection.getConnection();
                            if (conn != null || conn.isValid(2)){
                                System.out.println("Connection health is full ");
                            } else {
                                System.out.println("Connection is not healthy");
                            }
                            break;
                    case 6: System.exit(0);
                    default: System.out.println("Invalid option");
                             break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}