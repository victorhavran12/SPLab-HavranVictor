public class TableOfContents implements Element {
    private String title;

    public TableOfContents() {
        this.title = "Table of Contents";
    }

    public TableOfContents(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
    }

    @Override
    public void add(Element e) {
    }

    @Override
    public void remove(Element e) {
    }

    @Override
    public Element get(int index) {
        return null;
    }
}
