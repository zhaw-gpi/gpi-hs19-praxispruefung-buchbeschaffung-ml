package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * CheckAvailableFundsDelegate
 */
@Named("checkAvailableFunds")
public class CheckAvailableFundsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long price = (Long) execution.getVariable("publicationPrice");
        
        execution.setVariable("availableFundsAfterProcure", 10000 - price);

    }

    
}