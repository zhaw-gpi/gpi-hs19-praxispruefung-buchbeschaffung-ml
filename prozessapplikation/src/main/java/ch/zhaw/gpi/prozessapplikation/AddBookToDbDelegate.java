package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

/**
 * AddBookToDbDelegate
 */
@Named("addBookToDb")
public class AddBookToDbDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long isbn = (Long) execution.getVariable("publicationIsbn");
        String title = (String) execution.getVariable("publicationTitle");

        RestTemplate restTemplate = new RestTemplate();

        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);

        restTemplate.postForObject("http://localhost:8090/api/bibverw/books", book, Object.class);

    }

    
}