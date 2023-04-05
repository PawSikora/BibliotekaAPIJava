package pl.projekt.biblioteka;

import java.time.LocalDate;

public class Book {
    private Long id;
    private String tytul;
    private String autor;
    private LocalDate rokWydania;

    public Book(Long id, String tytul, String autor, LocalDate rokWydania) {
        this.id = id;
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(LocalDate rokWydania) {
        this.rokWydania = rokWydania;
    }
}
