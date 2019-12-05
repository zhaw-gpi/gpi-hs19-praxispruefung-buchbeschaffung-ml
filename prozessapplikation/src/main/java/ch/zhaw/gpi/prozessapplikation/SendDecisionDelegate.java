package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * SendDecisionDelegate
 */
@Named("sendDecision")
public class SendDecisionDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        

    }

    
}