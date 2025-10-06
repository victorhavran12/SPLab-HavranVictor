import java.util.ArrayList;
import java.util.List;

public class Book {
    String title;

    Author author;                      
    TableOfContents tableOfContents;    
    List<Chapter> chapters = new ArrayList<>(); 

    public void print() {
    }
}
