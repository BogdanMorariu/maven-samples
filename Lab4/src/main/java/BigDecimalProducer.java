import Model.Person;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BigDecimalProducer implements Runnable{

    private BlockingQueue<BigDecimal> queue;

    public BigDecimalProducer(BlockingQueue<BigDecimal> q) throws InterruptedException {
        this.queue=q;
    }

    @Override
    public void run() {
        int i=0;
        try {
            List<BigDecimal> bigDecimals = BigDecimalSerializer.deserializeBigDecimal("Lab4/BigDecimals.txt");
            for(BigDecimal bigDecimal : bigDecimals){
                System.out.println("Produced BigDecimal nr " + ++i + " : " + bigDecimal.toString());
                queue.put(bigDecimal);
                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
        }
        System.out.println("BigDecimalProducer FINISHED work : PRODUCED " + i + " Elements");
        try {
            queue.put(BigDecimal.ZERO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
