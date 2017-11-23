package Producers;

import Model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Person> queue;
    private String filename;

    public Producer(BlockingQueue<Person> q, String filename){
        this.queue=q;
        this.filename = filename;
    }

    public void run() {
        try {
            String input = new String(Files.readAllBytes(Paths.get(filename)),"UTF-8");
            String[] tokens = input.split("%");
            int i=0;
            for(String token : tokens){
                String[] fields = token.split("~");
                Person person = new Person(fields[0],fields[1],fields[2],Long.valueOf(fields[3]),fields[4]);
                i++;
                if(person.isValid()){
                    System.out.println("Produced person nr " + i + " : " + person.toString());
                    queue.put(person);
                }
            }
            System.out.println("Producer FINISHED work : PRODUCED " + i + " Elements");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        String msg = "exit";
        try {
            queue.put(new Person());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
