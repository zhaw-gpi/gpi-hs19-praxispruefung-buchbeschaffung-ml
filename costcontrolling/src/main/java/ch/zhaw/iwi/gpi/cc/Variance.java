package ch.zhaw.iwi.gpi.cc;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Variances
 */
@Entity
public class Variance {

    @Id
    private Long accountId;
    private String accountName;
    private Long amountBudgeted;
    private Long amountRemaining;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAmountBudgeted() {
        return amountBudgeted;
    }

    public void setAmountBudgeted(Long amountBudgeted) {
        this.amountBudgeted = amountBudgeted;
    }

    public Long getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(Long amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    
    
}