package consumers;

import Model.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Person> queue;
    private String filename;

    public Consumer(BlockingQueue<Person> q,String filename){
        this.queue=q;
        this.filename = filename;
    }

    public void run() {
        try{
            int i=1;
            Person person;
            OutputStream stream = Files.newOutputStream(Paths.get(filename),StandardOpenOption.CREATE);
            while(!(person = queue.take()).isEmpty()){
                stream.write(person.toFileFormat().getBytes(Charset.forName("UTF-8")));
                System.out.println("Consumed person nr " + i++ + " : " + person.toString());
            }
            System.out.println("Consumer FINISHED work : CONSUMED " + i + " Elements");
        }catch(InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
