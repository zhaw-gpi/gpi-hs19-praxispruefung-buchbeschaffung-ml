package ch.zhaw.iwi.gpi.bibverw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * BibVerwRestController
 */
@RestController
public class BibVerwRestController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(path = "/api/bibverw/books", method = RequestMethod.POST)
    public void saveBook(@RequestBody Book book) {
        bookRepository.save(book);
    }
}