import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        /* Docs */
        
        ListaDobleEnlazada A = new ListaDobleEnlazada();
        ListaDobleEnlazada B = new ListaDobleEnlazada();
        ListaDobleEnlazada C = new ListaDobleEnlazada();
        boolean selectedList = true, sortAsc = true; // True = A, False = B
        int d = 0, configOpc = 0, times = 0;
        while (true) {
            switch (menu()) {
                case 1: // append to start
                    d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: "));
                    if (selectedList)
                        A.appendToStart(d);
                    else
                        B.appendToStart(d);
                    break;

                case 2: // appent to end
                    d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: "));
                    if (selectedList)
                        A.appendToEnd(d);
                    else
                        B.appendToEnd(d);
                    break;

                case 3: // append sort
                    d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: "));
                    if (selectedList)
                        A.appendSort(d, sortAsc);
                    else
                        B.appendSort(d, sortAsc);
                    break;

                case 4: // Sort List
                    if (selectedList)
                        A.sort(sortAsc);
                    else
                        B.sort(sortAsc);
                    break;

                case 5: // Search
                    d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: "));
                    times = A.search(d);
                    JOptionPane.showMessageDialog(null, "The number was found" + times + "times");
                    break;

                case 6: // Math

                    break;

                case 7: // show list
                    JOptionPane.showMessageDialog(null, selectedList ? A.showList() : B.showList());
                    break;
                case 8:
                    configOpc = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            1. Change Selected List.
                            2. Change Sort Direction.
                            """));
                    if (configOpc == 1) { // Swich dont work in swich

                        String list = JOptionPane.showInputDialog(null, """
                                A. First List.
                                B. Second List.
                                """).toLowerCase();
                        if (list.toCharArray()[0] == "a".toCharArray()[0])
                            selectedList = true;
                        else if (list.toCharArray()[0] == "b".toCharArray()[0]) {
                            selectedList = false;
                        }

                        else
                            JOptionPane.showMessageDialog(null, "Invalid Option");

                    } else if (configOpc == 2) {

                        if (JOptionPane.showInputDialog(null, """
                                1. Ascending sort.
                                2. Descending sort.
                                """).toLowerCase() == "1")
                            sortAsc = true;
                        else
                            sortAsc = false;

                    } else
                        JOptionPane.showInputDialog(null, "Invalid Option");

                    break;

                case 9:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Select an option.");
                    break;

            }
        }
    }

    public static int menu() {

        return Integer.parseInt(JOptionPane.showInputDialog(null, """
                \n
                1. Append to start.
                2. Append to end.
                3. Append sorted.
                4. Sort list.
                5. Search data.
                6. Math operatios with two lists.
                7. Show list.
                8. Config
                9. exit
                """));
    }
}
