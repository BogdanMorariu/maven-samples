import Model.Person;
import Producers.Producer;
import consumers.Consumer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100);
        //producePersons();
        produceBigDecimals();
    }

    private static void producePersons(){
        BlockingQueue<Person> personsQueue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(personsQueue,"Lab4/input4.txt");
        Consumer consumer = new Consumer(personsQueue,"Lab4/output4.txt");
        new Thread(producer).start();
        new Thread(consumer).start();
        System.out.println("Producer and Consumer For Persons has been started");
    }

    private static void produceBigDecimals() throws InterruptedException {
        List<BigDecimal> bdList = new ArrayList<>();
        int listSize = 100000000;
        Random rand = new Random();
        for(int i=0; i< listSize;i++)
            bdList.add(new BigDecimal(rand.nextLong() & Integer.MAX_VALUE));
        BigDecimalSerializer.serializeBigDecimals(bdList,"Lab4/BigDecimals.txt");

        BlockingQueue<BigDecimal> decimalsQueue = new LinkedBlockingQueue<>();
        BigDecimalProducer decimalProducer = new BigDecimalProducer(decimalsQueue);
        BigDecimalConsumer decimalConsumer = new BigDecimalConsumer(decimalsQueue);
        new Thread(decimalConsumer).start();
        new Thread(decimalProducer).start();
        System.out.println("Producer and Consumer For BigDecimals has started");
    }
}
