import Model.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.BlockingQueue;

public class BigDecimalConsumer implements Runnable{

    BigDecimalSerializer serializer;
    private BlockingQueue<BigDecimal> queue;

    public BigDecimalConsumer(BlockingQueue<BigDecimal> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            int i=0;
            BigDecimal bigDecimal;
            while(!(bigDecimal = queue.take()).equals(BigDecimal.ZERO)){
                System.out.println("Consumed BigDecimal nr " + ++i + " : " + bigDecimal.toString());
            }
            System.out.println("BigDecimalConsumer FINISHED work : CONSUMED " + i + " Elements");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
