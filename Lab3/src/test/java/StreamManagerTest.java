import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class StreamManagerTest {

    private StreamManager streamManager;
    private List<BigDecimal> bdList;

    @Before
    public void setUp() throws Exception {
        bdList = new ArrayList<>();
        streamManager = new StreamManager(bdList);
        int listSize = 10;
        for(int i=0; i< listSize;i++)
            bdList.add(new BigDecimal(111));
    }

    @Test
    public void sum() throws Exception {
        BigDecimal result = new BigDecimal(1110);
        assertTrue(result.equals(streamManager.sum()));
    }

    @Test
    public void average() throws Exception {
        BigDecimal result = new BigDecimal(111);
        assertTrue(result.equals(streamManager.average()));
    }

    @Test
    public void top10() throws Exception {
        BigDecimal result = new BigDecimal(111);
        assertTrue(streamManager.top10().get(0).equals(result));
    }

}