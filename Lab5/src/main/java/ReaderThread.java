import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ReaderThread implements Runnable {
    private Socket clientSocket;
    private ConnectionManager manager;

    public ReaderThread(Socket clientSocket,ConnectionManager manager){
        this.clientSocket = clientSocket;
        this.manager = manager;
    }

    @Override
    public void run(){
        try(
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){
            String response = in.readLine();
            if(!response.equals("!ack")){
                System.out.println("Invalid first response: "+response);
                return;
            }
            String message="",name;
            try {
                name = in.readLine();
                System.out.println(name+" connected to you");
                while(!message.equals("!bye") && message!=null){
                    message = in.readLine();
                    System.out.println("\n"+name+": "+message+"");
                }
                throw new SocketException();
            } catch (SocketException e){
                System.out.println("The other person left");
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
