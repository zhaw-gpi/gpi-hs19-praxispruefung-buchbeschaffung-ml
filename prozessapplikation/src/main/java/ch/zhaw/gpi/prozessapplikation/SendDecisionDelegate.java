package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SendDecisionDelegate
 */
@Named("sendDecision")
public class SendDecisionDelegate implements JavaDelegate {

    @Autowired
    private MailService mailService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Boolean preliminaryDecision = (Boolean) execution.getVariable("preliminaryDecision");
        String publicationTitle = (String) execution.getVariable("publicationTitle");
        String email = (String) execution.getVariable("email");

        Boolean accepted;
        String subject = "Antrag Buchbeschaffung ";
        String body = "Ihr Antrag für das Buch mit dem Titel '" + publicationTitle + "' wurde ";

        if(!preliminaryDecision){
            accepted = false;
        } else {
            accepted = (Boolean) execution.getVariable("mainDecision");
        }

        if(accepted){
            subject += "bewilligt";
            body += "bewilligt.";
        } else {
            subject += "abgelehnt";
            body += "abgelehnt.";
        }

        mailService.sendFakeMail(email, subject, body);
    }    
}