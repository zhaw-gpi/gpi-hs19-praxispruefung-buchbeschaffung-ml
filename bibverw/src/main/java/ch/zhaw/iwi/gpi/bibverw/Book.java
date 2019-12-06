package ch.zhaw.iwi.gpi.bibverw;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Book
 */
@Entity
public class Book {

    @Id
    private Long isbn;
    private String title;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    
}