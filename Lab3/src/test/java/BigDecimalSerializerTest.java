import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BigDecimalSerializerTest {

    private List<BigDecimal> bdList;

    @Before
    public void setUp() throws Exception {
        bdList = new ArrayList<>();
        int listSize = 5;
        for(int i=0; i< listSize;i++)
            bdList.add(new BigDecimal(111));
    }

    @Test
    public void serializeBigDecimals() throws Exception {
        try{
            BigDecimalSerializer.serializeBigDecimals(bdList,"D:\\Scoala\\Anul-3\\Perforamce stuff\\maven-samples\\Lab3\\BigDecimalTest.txt");
            assertTrue(true);
        }catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void deserializeBigDecimal() throws Exception {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals = BigDecimalSerializer.deserializeBigDecimal("D:\\Scoala\\Anul-3\\Perforamce stuff\\maven-samples\\Lab3\\BigDecimalTest.txt");
        assertFalse(bigDecimals.isEmpty());
    }

}