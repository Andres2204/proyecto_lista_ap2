public class ListaDobleEnlazada {
    private Nodo start, end;
    private boolean sortAsc = true;

    // ##### Sort #####
    public void sort(boolean asc) {
        sortAsc = asc;
        Nodo p = start;
        Nodo q = p;
        int aux;
        while (p != null) {
            q = start;
            while (q != null) {
                if (sortAsc && p.getData() < q.getData()) {
                    aux = p.getData();
                    p.setData(q.getData());
                    q.setData(aux);
                } else if (!sortAsc  && p.getData() > q.getData()) {
                    aux = p.getData();
                    p.setData(q.getData());
                    q.setData(aux);
                }
                q = q.getNext();
            }
            p = p.getNext();
        }

    }

    // ############### Append methods ###############
    public void appendSort(int d, boolean asc) {
        sortAsc = asc;
        Nodo p = start, x = new Nodo(d);
        if (!isEmpty()) {

            // loop through the list until some condition is met
            while (p != null) {
                if (sortAsc && p.getData() > d)
                    break; // exit to while
                else if (!sortAsc && p.getData() < d)
                    break; // exit to while
                p = p.getNext();
            }

            if (p == start) {
                this.appendToStart(d);
            } else if (p == null) {
                this.appendToEnd(d);
            } else {
                x.setNext(p);
                x.setPrevious(p.getPrevious());
                p.getPrevious().setNext(x);
                p.setPrevious(x);
            }

        } else {
            this.appendToStart(d);
        }

    }

    public void appendToStart(int d) {
        Nodo newNodo = new Nodo(d);
        if (isEmpty()) {
            start = newNodo;
            end = newNodo;
        } else {
            newNodo.setNext(start);
            start.setPrevious(newNodo);
            start = newNodo;
        }
    }

    public void appendToEnd(int d) {
        Nodo newNodo = new Nodo(d);
        if (isEmpty()) {
            start = newNodo;
            end = newNodo;
        } else {
            newNodo.setPrevious(end);
            end.setNext(newNodo);
            end = newNodo;
        }

    }

    // ############### Search ###############
    public int search(int d) {
        int counter = 0;
        Nodo p = start;
        do {
            if (p.getData() == d) {
                counter ++;
            }
        } while (p!=start);
        

        return counter;
    }
    // ############### Math Operations ###############
    public String addition(ListaDobleEnlazada A, ListaDobleEnlazada B) {
        Nodo a = A.getStart(), b = B.getStart();

        return showList();
    } 

    public String subtract(ListaDobleEnlazada A, ListaDobleEnlazada B) {
        Nodo a = A.getStart(), b = B.getStart();

        return showList();
    } 

    public String multiply(ListaDobleEnlazada A, ListaDobleEnlazada B) {
        Nodo a = A.getStart(), b = B.getStart();

        return showList();
    } 

    public String divide(ListaDobleEnlazada A, ListaDobleEnlazada B) {
        Nodo a = A.getStart(), b = B.getStart();

        return showList();
    }       



    // ############### Utility ###############
    public boolean isEmpty() { // return true if the list is empty
        return start == null ? true : false;
    }

    public String showList() {
        Nodo p = start;
        String nextText, previousText, output = "Is Empty";
        if (!isEmpty()) {
            output = "";
            while (p != null) {
                nextText = p.getNext() == null ? " / " : " | -> ";
                previousText = p.getPrevious() == null ? " / " : " <- | ";
                output += previousText + p.getData() + nextText;
                p = p.getNext();
            }
        }
        return output;
    }

    // ############### Getters and Setters ###############
    public Nodo getStart() {
        return start;
    }

    public void setStart(Nodo start) {
        this.start = start;
    }

    public Nodo getEnd() {
        return end;
    }

    public void setEnd(Nodo end) {
        this.end = end;
    }
}
