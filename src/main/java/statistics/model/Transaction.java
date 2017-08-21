package statistics.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import statistics.validation.Past;

import static java.lang.System.currentTimeMillis;
import static statistics.service.TransactionService.TIME_LIMIT;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    @Past
    private Long timestamp;

    @JsonIgnore
    public boolean isNewerThanTimeLimit() {
        return currentTimeMillis() - timestamp <= TIME_LIMIT;
    }

}