import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class StreamManager implements Serializable {
    List<BigDecimal> bigDecimals;

    public StreamManager(List<BigDecimal> bigDecimals) {
        this.bigDecimals = bigDecimals;
    }

    public BigDecimal sum(){
        return bigDecimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal average(){
        return new BigDecimal(bigDecimals.stream().mapToLong(BigDecimal::longValue).average().getAsDouble());
    }

    public List<BigDecimal> top10(){
        return bigDecimals.stream().sorted((bd1,bd2) -> bd1.compareTo(bd2)*-1)
                .limit(bigDecimals.size()/10).collect(Collectors.toList());
    }
}
