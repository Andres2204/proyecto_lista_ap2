public class Nodo {
    private Nodo previous, next;
    private int data;

    public Nodo() {
        this.previous = null;
        this.next = null;
        this.data = 0;
    }

    public Nodo(int d) {
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
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    
}
