public class Paragraph implements Element {
    private String text;

    public Paragraph() { }

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        // leaf print
    }

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
