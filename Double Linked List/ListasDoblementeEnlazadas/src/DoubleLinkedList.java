public class DoubleLinkedList {
    private Nodo start, end;
    private boolean sortAsc = true;

    // ##### Sort #####
    public void sort(boolean asc) { // circular
        sortAsc = asc;
        Nodo p = start;
        Nodo q = p;
        float aux;
        do {
            q = start;
            do {
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
            } while (q != start);
            p = p.getNext();
        } while (p != start);

    }

    // ############### Append methods ###############
    public void appendSort(float d, boolean asc) { // circualr
        sortAsc = asc;
        Nodo p = start, x = new Nodo(d);
        if (!isEmpty()) {

            // Loop through the list until some condition is met
            do {
                if (sortAsc && p.getData() > d)
                    break; // exit to while
                else if (!sortAsc && p.getData() < d)
                    break; // exit to while
                p = p.getNext();
            } while (p != start); 

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

    public void appendToStart(float d) { // circular
        Nodo newNodo = new Nodo(d);
        if (isEmpty()) {
            newNodo.setNext(newNodo);
            newNodo.setPrevious(newNodo);
            start = newNodo;
            end = newNodo;
        } else {
            newNodo.setNext(start);
            newNodo.setPrevious(end);
            start.setPrevious(newNodo);
            end.setNext(newNodo);
            start = newNodo;
        }
    }

    public void appendToEnd(float d) { // circular
        Nodo newNodo = new Nodo(d);
        if (isEmpty()) {
            newNodo.setNext(newNodo);
            newNodo.setPrevious(newNodo);
            start = newNodo;
            end = newNodo;

        } else {
            newNodo.setNext(start);
            newNodo.setPrevious(end);
            start.setPrevious(newNodo);
            end.setNext(newNodo);
            end = newNodo;
        }
    }

    // ############### Search ###############
    public MixedType search(float d, int action, int remplaceNumber) { // circular
        MixedType output = new MixedType();
        Nodo p = start, x;

        do {
            if (p.getData() == d)
                output.INT++;

            switch (action) {
                case 1: // Show
                    output.STRING += "<" + d + "> \n";
                    break;

                case 2: // Delete
                    x = start;
                    do {
                        if (x.getData() == d) {
                            Nodo previousNode = x.getPrevious();
                            Nodo nextNode = x.getNext();
                            previousNode.setNext(nextNode);
                            nextNode.setPrevious(previousNode);
                            if (x == start) { // Delete Start
                                start = nextNode;
                            }
                            if (x == end) { // Delete End
                                end = previousNode;
                                x = end;
                            }
                        }
                        x = x.getNext();
                    } while (x != start);

                    output.STRING = "Number Deleted.";
                    break;

                case 3: // Replace d
                    x = start;
                    do {
                        if (x.getData() == d) {
                            x.setData(remplaceNumber);
                            output.STRING += "<- [ " + x.getData() + " ] ->";
                            output.STATUS = true;
                        }
                        x = x.getNext();
                    } while (x != start);
                    break;

                default:
                    break;
            }
            p = p.getNext();
        } while (p != start);
        return output;
    }

    // ############### Math Operations ############### (circular)

    public String additionSubtract(DoubleLinkedList A, DoubleLinkedList B, boolean add) {
        Nodo b, a;
        if (A.isEmpty() && B.isEmpty()) {
            return "Empty Lists";
        }
        if (A.size() > B.size()) {

            if (B.isEmpty()) {
                B.appendToEnd(0);
            }
            b = B.getStart();
            while (A.size() != B.size()) {

                if (b == B.getEnd()) {
                    B.appendToEnd(0);
                }
                b = b.getNext();
            }
        } else if (A.size() < B.size()) {
            if (A.isEmpty()) {
                A.appendToEnd(0);
            }
            a = A.getStart();
            while (A.size() != B.size()) {
                if (a == A.getEnd()) {
                    A.appendToEnd(0);
                }
                a = a.getNext();
            }
        }
        b = B.getStart();
        a = A.getStart();
        do {
            appendToEnd(add ? a.getData() + b.getData() : a.getData() - b.getData());
            a = a.getNext();
            b = b.getNext();
        } while (a != A.getStart() || b != B.getStart());

        return showList();
    }

    public String multiply(DoubleLinkedList A, DoubleLinkedList B) {
        if (A.isEmpty() && !B.isEmpty()) {
            return B.showList();
        }
        if (B.isEmpty() && !A.isEmpty()) {
            return A.showList();
        }
        if (A.isEmpty() && B.isEmpty()) {
            return "Empty List";
        }

        Nodo b = B.getStart(), a = A.getStart();
        if (A.size() > B.size()) {
            while (A.size() != B.size()) {
                if (b == B.getEnd()) {
                    B.appendToEnd(1);
                }
                b = b.getNext();
            }
        } else if (A.size() < B.size()) {
            while (A.size() != B.size()) {
                if (a == A.getEnd()) {
                    A.appendToEnd(1);
                }
                a = a.getNext();
            }
        }

        b = B.getStart();
        a = A.getStart();
        do {
            appendToEnd(a.getData() * b.getData());
            a = a.getNext();
            b = b.getNext();
        } while (a != A.getStart() || b != B.getStart());
        return showList();
    }

    public String divide(DoubleLinkedList A, DoubleLinkedList B) {
        if (A.isEmpty() && !B.isEmpty()) {
            return B.showList();
        }
        if (B.isEmpty() && !A.isEmpty()) {
            return A.showList();
        }
        if (A.isEmpty() && B.isEmpty()) {
            return "Empty List";
        }

        Nodo b = B.getStart(), a = A.getStart();
        if (A.size() > B.size()) {
            while (A.size() != B.size()) {
                if (b == B.getEnd()) {
                    B.appendToEnd(1);
                }
                b = b.getNext();
            }
        } else if (A.size() < B.size()) {
            while (A.size() != B.size()) {
                if (a == A.getEnd()) {
                    A.appendToEnd(1);
                }
                a = a.getNext();
            }
        }

        b = B.getStart();
        a = A.getStart();
        do {
            appendToEnd(a.getData() / b.getData());
            a = a.getNext();
            b = b.getNext();
        } while (a != A.getStart() || b != B.getStart());
        return showList();
    }

    // ############### Utility ###############
    public int size() {
        if (!isEmpty()) {

            int size = 0;
            Nodo p = start;

            do {
                size++;
                p = p.getNext();
            } while (p != start);
            return size;
        } else {
            return 0;
        }
    }

    public boolean isEmpty() { // return true if the list is empty
        return start == null ? true : false;
    }

    public String showList() {
        Nodo p = start;
        String nextText, previousText, output = "Is Empty";
        if (!isEmpty()) {
            output = "";
            do {
                nextText = p.getNext() == null ? " / " : " | -> ";
                previousText = p.getPrevious() == null ? " / " : " <- | ";
                output += previousText + p.getData() + nextText;
                p = p.getNext();
            } while (p != start);
        }
        return output;
    }

    public void copyList(DoubleLinkedList A) {
        start = null;
        end = null;
        System.gc();
        Nodo a = A.getStart();
        if (!A.isEmpty()) {
            do {
                appendToEnd(a.getData());
                a = a.getNext();
            } while (a != A.getStart());
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
