import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int port = 779 ;
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Input your name: ");
        name = scanner.nextLine();
        System.out.println("Welcome "+name+"!");

        ConnectionManager manager = null;
        try {
            manager = new ConnectionManager(port,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager.beginConnection();
    }
}
