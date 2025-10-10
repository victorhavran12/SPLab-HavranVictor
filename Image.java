public class Image implements Element {
    private String url;

    public Image() { }

    public Image(String url) {
        this.url = url;
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
