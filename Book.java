import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private final List<Author> authors = new ArrayList<>();

    public Book() {
        super();
    }

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
        System.out.println("Book: " + getTitle());
        System.out.println();
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println();
        printChildren();
    }
}
