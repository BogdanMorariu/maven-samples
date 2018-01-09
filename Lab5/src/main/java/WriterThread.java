import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WriterThread implements Runnable {
    private String name;
    private ConnectionManager manager;
    private Socket clientSocket;

    public WriterThread(Socket clientSocket,String name,ConnectionManager manager){
        this.clientSocket = clientSocket;
        this.name = name;
        this.manager = manager;
    }

    @Override
    public void run(){
        try(PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ){
            String message = "";
            out.println("!ack");
            System.out.println("name sent:" +name+". message is:"+message);
            out.println(name);
            while(!message.equals("!bye") && !message.equals("!byebye") && !(message.split(" ")[0].equals("!hello") && message.split(" ").length == 2)){
                System.out.print("You: ");
                message = scanner.nextLine();
                out.println(message);
            }
            if(message.split(" ")[0].equals("!hello") && message.split(" ").length == 2)
                manager.getConnection(message.split(" ")[1]);
            if(message.equals("!bye")){
            System.out.println("closing : " + clientSocket.getPort());
            manager.closeConnection(clientSocket.getPort());
            manager.beginConnection();}
            if(message.equals("!byebye")) {
                System.out.println("Closing app");
                manager.closeAllConnections();
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
