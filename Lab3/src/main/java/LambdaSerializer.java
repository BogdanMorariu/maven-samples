import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class LambdaSerializer {

    public static void serializeLambda(Runnable lambda, String filename){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(lambda);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void serializeLambda(Callable lambda, String filename){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(lambda);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Runnable deserializeRunnable(String filename){
        Runnable receivedLambda;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))){
            receivedLambda = (Runnable) inputStream.readObject();
            return receivedLambda;
        }catch (Exception e){
            e.printStackTrace();
        }
        return () -> System.out.println("Not Good");
    }

    public static Callable deserializeCallable(String filename){
        Callable receivedLambda;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))){
            receivedLambda = (Callable) inputStream.readObject();
            return receivedLambda;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
