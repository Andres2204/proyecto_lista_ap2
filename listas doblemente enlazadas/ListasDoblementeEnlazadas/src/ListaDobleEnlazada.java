public class ListaDobleEnlazada {
    private Nodo start, end;
    private boolean sortAsc = true;

    // ##### Sort #####
    public void sort(boolean asc) {
        sortAsc = asc;
        if (sortAsc) { // sort ascending

        } else { // sort descending

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

    // ############### Math Operations ###############

    // ############### Utility ###############
    public boolean isEmpty() { // return true if the list is empty
        return start == null ? true : false;
    }

    public void showInConsole() {
        Nodo p = start;
        String nextText, previousText;
        if (!isEmpty()) {
            while (p != null) {
                nextText = p.getNext() == null ? " / " : " | -> ";
                previousText = p.getPrevious() == null ? " / " : " <- | ";
                System.out.print(previousText + p.getData() + nextText);
                p = p.getNext();
            }
        } else {
            System.out.println("Empty List.");
        }
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
