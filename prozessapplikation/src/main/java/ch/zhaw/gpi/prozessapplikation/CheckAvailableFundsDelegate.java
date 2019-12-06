package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

/**
 * CheckAvailableFundsDelegate
 */
@Named("checkAvailableFunds")
public class CheckAvailableFundsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long price = (Long) execution.getVariable("publicationPrice");
        Long availableFundsAfterProcure;

        RestTemplate restTemplate = new RestTemplate();

        Variance variance = restTemplate.getForObject("http://localhost:8070/api/v1/variances/{accountId}", Variance.class, 6503);
        availableFundsAfterProcure = variance.getAmountRemaining() - price;
        
        execution.setVariable("availableFundsAfterProcure", availableFundsAfterProcure);
    }

    
}