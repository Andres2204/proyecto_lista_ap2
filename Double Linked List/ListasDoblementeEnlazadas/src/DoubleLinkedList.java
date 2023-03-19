public class DoubleLinkedList {
    private Nodo start, end;
    private boolean sortAsc = true;

    // ##### Sort #####
    public void sort(boolean asc) {
        sortAsc = asc;
        Nodo p = start;
        Nodo q = p;
        float aux;
        while (p != null) {
            q = start;
            while (q != null) {
                if (sortAsc && p.getData() < q.getData()) {
                    aux = p.getData();
                    p.setData(q.getData());
                    q.setData(aux);
                } else if (!sortAsc && p.getData() > q.getData()) {
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
    public void appendSort(float d, boolean asc) {
        sortAsc = asc;
        Nodo p = start, x = new Nodo(d);
        if (!isEmpty()) {

            // Loop through the list until some condition is met
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

    public void appendToStart(float d) {
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

    public void appendToEnd(float d) {
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
    public MixedType search(float d, int action) {
        MixedType output = new MixedType();
        Nodo p = start;
        Boolean found = false;
        
        do {
            if (p.getData() == d)
                output.INT++;

            switch (action){
                case 1: // Show d
                    output.STRING += "<" + d + "> \n";
                    break;

                case 2: // Delete d
                    while (!found && p!=null) {

                        if (p.getData() == d) {
                            Nodo previousNode = p.getPrevious();
                            Nodo nextNode = p.getNext();
                            previousNode.setNext(nextNode);
                            nextNode.setPrevious(previousNode);
                            found = true;
                        }
                        
                        p = p.getNext();
                    }
                    
                    output.STRING = "Number Deleted.";
                    break;

                case 3: // Replace d
                    p.setData(d);
                    output.STRING += "<- [ "+p.getData()+" ] ->";
                    output.STATUS = true;
                    break;

                default:
                    break;
            }
            p = p.getNext();
        } while (p != null);
        return output;
    }

    // ############### Math Operations ###############

    /**
     * @param A
     * @param B
     * @return
     */
    public String additionSubtract(DoubleLinkedList A, DoubleLinkedList B, boolean add) {
        Nodo b = B.getStart(), a = A.getStart();
        while (a != null || b != null) {
            if (a != null && b == null) {
                appendToEnd(a.getData());
                a = a.getNext();
            } else if (a == null && b != null) {
                appendToEnd(add ? b.getData() : (-1) * b.getData());
                b = b.getNext();
            } else {
                appendToEnd(add ? a.getData() + b.getData() : a.getData() - b.getData());
                a = a.getNext();
                b = b.getNext();
            }

        }
        // while (a != A.getStart() || a != null && b != B.getStart() || b != null);

        return showList();
    }

    public String multiply(DoubleLinkedList A, DoubleLinkedList B) {
        Nodo b = B.getStart(), a = A.getStart();

        while (a != null || b != null) {
            if (a != null && b == null) {
                appendToEnd(a.getData());
                a = a.getNext();
            } else if (a == null && b != null) {
                appendToEnd(b.getData());
                b = b.getNext();
            } else {
                appendToEnd(a.getData() * b.getData());
                a = a.getNext();
                b = b.getNext();
            }
        }
        return showList();
    }

    public String divide(DoubleLinkedList A, DoubleLinkedList B) {
        if (A.isEmpty()) {
            return "A is empty.";
        }
        if (B.isEmpty()) {
            return "B is empty.";
        }


        Nodo a = A.getStart(), b = B.getStart();


        while (a != null || b != null) {
            if (a == null) {
                appendToEnd(b.getData());
                b = b.getNext();

            } else if (b == null || b.getData() == 0) {
                appendToEnd(0);
                a = a.getNext();
            } else {
                appendToEnd(a.getData() / b.getData());
                a = a.getNext();
                b = b.getNext();
            }
        }

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
