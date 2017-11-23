import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalSerializer {

    public static void serializeBigDecimals(List<BigDecimal> bigDecimalList, String filename){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            int length = bigDecimalList.size();
            outputStream.writeInt(length);
            for(BigDecimal bd : bigDecimalList)
                outputStream.writeObject(bd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BigDecimal> deserializeBigDecimal(String filename){
        List<BigDecimal> bigDecimals = new ArrayList<>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            int length = inputStream.readInt();
            while(length--!=0){
                bigDecimals.add((BigDecimal) inputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bigDecimals;
    }
}
