package task2;

import java.io.Serializable;

public class Textbook implements Serializable {

    private int isbn;
    private String title;
    private String authors;

    public Textbook(int isbn, String title, String authors){
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }


    @Override
    public String toString() {
        return title + " " + authors + " " + isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Textbook){
            Textbook t = (Textbook) obj;
            return t.authors.equals(this.authors) && t.title.equals(this.title) && t.isbn == this.isbn;
        }
        return false;
    }
}

