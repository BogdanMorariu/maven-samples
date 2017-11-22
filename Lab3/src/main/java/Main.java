import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.invoke.SerializedLambda;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//-------------------------------
//------ Work not finished !------
public class Main {

    public static void main(String[] args) throws Exception {
        List<BigDecimal> bdList = new ArrayList<>();
        int listSize = 10000;
        Random rand = new Random();
        for(int i=0; i< listSize;i++)
            bdList.add(new BigDecimal(rand.nextLong() & Integer.MAX_VALUE));

        StreamManager streamManager = new StreamManager(bdList);
        BigDecimal sum = streamManager.sum();
        System.out.println("\nThe sum is : " + sum);

        BigDecimal average = streamManager.average();
        System.out.println("The average is : " + average);

        List<BigDecimal> top10 = streamManager.top10();
        System.out.println("Top 10%: " + top10);


        //HomeWork
        BigDecimalSerializer.serializeBigDecimals(bdList,"Lab3\\BigDecimal.txt");
        List<BigDecimal> recievedDecimals = BigDecimalSerializer.deserializeBigDecimal("Lab3\\BigDecimal.txt");
        System.out.println("Deserialized BigDecimals: " + recievedDecimals);


        Runnable runnable = (Runnable & Serializable) () -> System.out.println("Serialize me senpai");




        Callable<BigDecimal> sumFunction = (Callable<BigDecimal> & Serializable) streamManager::sum;
        LambdaSerializer.serializeLambda(sumFunction,"Lab3\\Lambda.txt");
        System.out.println("The serialized method for sum returned :"
                + LambdaSerializer.deserializeCallable("Lab3\\Lambda.txt").call());

        Callable<BigDecimal> avgFunction = (Callable<BigDecimal> & Serializable) streamManager::average;
        LambdaSerializer.serializeLambda(avgFunction,"Lab3\\Lambda.txt");
        System.out.println("The serialized method for average returned :"
                + LambdaSerializer.deserializeCallable("Lab3\\Lambda.txt").call());

        Callable<List<BigDecimal>> topFunction = (Callable<List<BigDecimal>> & Serializable) streamManager::top10;
        LambdaSerializer.serializeLambda(topFunction,"Lab3\\Lambda.txt");
        System.out.println("The serialized method for sum returned :"
                + LambdaSerializer.deserializeCallable("Lab3\\Lambda.txt").call());
    }

}
