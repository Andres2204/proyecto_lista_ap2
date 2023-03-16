public class Nodo {
    private Nodo previous, next;
    private float data;

    public Nodo() {
        this.previous = null;
        this.next = null;
        this.data = 0;
    }

    public Nodo(float d) {
        this.previous = null;
        this.next = null;
        this.data = d;
    }

    // getter setters
    public Nodo getPrevious() {
        return previous;
    }
    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
    public float getData() {
        return data;
    }
    public void setData(float data) {
        this.data = data;
    }
}
