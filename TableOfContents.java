public class TableOfContents implements Element {
    private String name;

    public TableOfContents() { }

    public TableOfContents(String name) {
        this.name = name;
    }

    @Override
    public void print() { }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException("Leaf cannot add children");
    }

    @Override
    public void remove(Element e) {
        throw new UnsupportedOperationException("Leaf cannot remove children");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Leaf has no children");
    }
}
