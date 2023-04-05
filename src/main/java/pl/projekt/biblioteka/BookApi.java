package pl.projekt.biblioteka;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {
    List<Book> books = new ArrayList<>();

    public BookApi() {
        books.add(new Book(1L, "Harry Potter i Kamień Filozoficzny", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
        books.add(new Book(2L, "Władca Pierścieni: Drużyna Pierścienia", "J.R.R. Tolkien", LocalDate.of(1954, 7, 29)));
        books.add(new Book(3L, "Lalka", "Bolesław Prus", LocalDate.of(1890, 12, 1)));
        books.add(new Book(4L, "Metro 2033", "Dmitry Glukhovsky", LocalDate.of(2005, 7, 1)));
        books.add(new Book(5L, "Mistrz i Małgorzata", "Mikhail Bulgakov", LocalDate.of(1966, 1, 1)));
    }


    @GetMapping("/all")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/getBook/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) {
        return books.stream()
                .filter(book -> book.getId().equals(Long.valueOf(id)))
                .findFirst();
    }

    @PostMapping
    public boolean addBook(@RequestBody Book book) {
        return books.add(book);
    }

    @PutMapping("/updateBook")
    public boolean updateBook(@RequestBody Book book) {
        for (Book currentBook : books) {
            if (currentBook.getId().equals(book.getId())) {
                int index = books.indexOf(currentBook);
                books.set(index, book);
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/deleteBook/{id}")
    public boolean deleteBook(@PathVariable("id") Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
