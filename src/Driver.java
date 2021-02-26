import java.io.IOException;
import java.util.Scanner;

public class Driver {

    private static Scanner scanner = new Scanner(System.in);
    private static Directory directory = new Directory(System.getProperty("user.dir"));//get current path

    public static void main(String[] args) throws IOException {
        Integer exitToggle = 0;
        while (exitToggle != 1) {
            Integer input = showWelcomeMessage();
            switch (input) {
                case 1:
                    directory.listFilesInSortedOrder();
                    break;
                case 2:
                    showSecondaryMenu();
                    break;
                case 3:
                    exitToggle = 1;
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }

    static void showSecondaryMenu() throws IOException {
        Integer mainMenuToggle = 0;
        while (mainMenuToggle != 1) {
            System.out.println("******************************");
            System.out.println("Please select one of the options from below : ");
            System.out.println("1. Add a file in the current directory");
            System.out.println("2. Delete a file from the current directory");
            System.out.println("3. Search a file in the current directory");
            System.out.println("4. Go back to main menu");
            System.out.println("Please enter your input : ");
            Integer input = scanner.nextInt();
            switch (input) {
                case 1:
                case 2:
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter the file name");
                    String fileName = scanner.nextLine();
                    System.out.println(directory.executeOperation(input, fileName));
                    break;
                case 4:
                    mainMenuToggle = 1;
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }

    static int showWelcomeMessage() {
        System.out.println("******************************");
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developed by : Clovis Tikum");
        System.out.println("Please select one of the options from below : ");
        System.out.println("1. Display the current file names in ascending order");
        System.out.println("2. Add/Delete/Search a file");
        System.out.println("3. Exit");
        System.out.println("Please enter your input : ");
        Integer input = scanner.nextInt();
        return input;
    }
}
