import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private final List<Author> authors = new ArrayList<>();

    public Book() { }

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author a) {
        if (a != null) {
            authors.add(a);
        }
    }

    @Override
    public void print() {
        super.print();
    }
}
