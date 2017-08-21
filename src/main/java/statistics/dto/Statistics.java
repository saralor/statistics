package statistics.dto;

import java.util.Collection;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import statistics.model.Transaction;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Statistics {

    private Double sum;

    private Double avg;

    private Double max;

    private Double min;

    private Long count;

    public Statistics() {
    }

    public Statistics(Collection<Transaction> transactions) {
        final List<Double> amountsLastMinute = transactions.stream().map(Transaction::getAmount).collect(toList());
        final Long count = amountsLastMinute.stream().count();
        this.setCount(count);
        if (count > 0) {
            this.setSum(amountsLastMinute.stream().mapToDouble(Double::doubleValue).sum());
            this.setAvg(amountsLastMinute.stream().mapToDouble(Double::doubleValue).average().getAsDouble());
            this.setMax(amountsLastMinute.stream().max(Double::compareTo).get());
            this.setMin(amountsLastMinute.stream().min(Double::compareTo).get());
        }
    }
}
