import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionManager {

    private Map<String,Integer> connections;
    private Map<Integer,Socket> connected;
    private ExecutorService executor;
    private String name;
    private Scanner scanner;

    public ConnectionManager(int port,String name) throws IOException {
        this.name=name;
        connections = new HashMap<>();
        connected = new HashMap<>();
        executor = Executors.newFixedThreadPool(20);
        scanner= new Scanner(System.in);
        populate();
        ServerSocket serverSocket = new ServerSocket(port);
        executor.submit(new Thread(() ->{
            while (true){
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Connection accepted");
                    if(!connected.containsKey(clientSocket.getPort()))
                        connected.put(clientSocket.getPort(),clientSocket);
                    Runnable readerThread = new ReaderThread(clientSocket,this);
                    if(executor.submit(readerThread).isDone())
                        closeConnection(clientSocket.getPort());
                } catch (IOException e) {
                    System.out.println("err");
                    e.printStackTrace();
                }
            }
        }));

    }

    public void addConnection(String name,Integer port){
        connections.put(name,port);
    }

    public void beginConnection(){
        String line;
        System.out.println("Type \"!hello *name*\" to start talking");
        line = scanner.nextLine();
        if (line.split(" ")[0].equals("!hello") && line.split(" ").length == 2)
            getConnection(line.split(" ")[1]);
    }

    public void getConnection(String name){
        if(connections.containsKey(name)){
            System.out.println("Connecting to "+name+"...");
            Socket clientSocket = null;
            Integer port = connections.get(name);
            if(!connected.containsKey(port)){
                try {
                    clientSocket = new Socket("localhost",port);
                } catch (IOException e) {
                    System.out.println("Connection Refused!");
                }
                connected.put(connections.get(name),clientSocket);
            }
            else
                clientSocket = connected.get(port);
            Runnable writerThread = new WriterThread(clientSocket,this.name,this);
            executor.submit(writerThread);
        }
        else
            System.out.println("Person not found");
    }

    public void closeConnection(Integer port){
        try {
            connected.get(port).close();
            connected.remove(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeAllConnections(){
        connected.values().forEach(socket -> {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        connected.clear();
    }

    private void populate(){
        connections.put("bogdan",777);
        connections.put("catri",778);
        connections.put("ovidiu",779);
    }
}
