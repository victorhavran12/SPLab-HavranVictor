import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private final List<Element> children = new ArrayList<>();

    public Section() { }

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        for (Element e : children) {
            e.print();
        }
    }

    @Override
    public void add(Element e) {
        if (e != null) {
            children.add(e);
        }
    }

    @Override
    public void remove(Element e) {
        children.remove(e);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}
