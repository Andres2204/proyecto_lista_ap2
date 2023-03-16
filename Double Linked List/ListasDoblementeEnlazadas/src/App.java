import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class App {
    public static void main(String[] args) throws Exception {
        FontUIResource f = new FontUIResource("calibri", 1, 14);
        UIManager.put("OptionPane.messageFont", f);

        /* Docs */
        DoubleLinkedList A = new DoubleLinkedList();
        DoubleLinkedList B = new DoubleLinkedList();
        boolean selectedList = true, sortAsc = true; // True = A, False = B
        int d = 0, opc = 0;
        MixedType searchOutput;

        // For testing
        // A.appendToEnd(10);
        // A.appendToEnd(10);
        // A.appendToEnd(120);
        // A.appendToEnd(14*5);
        // A.appendToEnd(125);

        // B.appendToEnd(-130);
        // B.appendToEnd(120);
        // B.appendToEnd(14);
        // B.appendToEnd(-5);
        // B.appendToEnd(30);

        while (true) {
            DoubleLinkedList C = new DoubleLinkedList(); // restart the list for the new math operations
            try {

                switch (menu(selectedList, sortAsc)) {
                    case 1: // append to start
                        d = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: "));
                        if (selectedList)
                            A.appendToStart(d);
                        else
                            B.appendToStart(d);
                        break;

                    case 2: // appent to end
                        d = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: "));
                        if (selectedList)
                            A.appendToEnd(d);
                        else
                            B.appendToEnd(d);
                        break;

                    case 3: // append sort
                        d = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: "));
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
                        d = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number to search: "));
                        searchOutput = A.search(d, 1);
                        JOptionPane.showMessageDialog(null,
                                "The number was found: " + searchOutput.INT + (searchOutput.INT > 1 ? " times" : " time"));
                        JOptionPane.showMessageDialog(null, searchOutput.STRING);
                        break;

                    case 6: // Math
                        opc = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Addition.
                                2. Subtract.
                                3. Multiply (null elements are taken as 1)
                                4. Divide. (If null is nothing, then
                                    nothing can't be divisible by
                                    something, and nothing can't
                                    divide something.)
                                """));
                        if (opc == 1)
                            JOptionPane.showMessageDialog(null, C.additionSubtract(A, B, true));
                        if (opc == 2)
                            JOptionPane.showMessageDialog(null, C.additionSubtract(A, B, false));
                        if (opc == 3)
                            JOptionPane.showMessageDialog(null, C.multiply(A, B));
                        if (opc == 4)
                            JOptionPane.showMessageDialog(null, C.divide(A, B));

                        break;

                    case 7: // show list
                        JOptionPane.showMessageDialog(null, selectedList ? A.showList() : B.showList());
                        break;
                    case 8: // config
                        opc = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Change Selected List.
                                2. Change Sort Direction.
                                """));
                        if (opc == 1) { // Swich dont work in swich

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

                        } else if (opc == 2) {

                            if (JOptionPane.showInputDialog(null, """
                                    1. Ascending sort.
                                    2. Descending sort.
                                    """).toLowerCase() == "1")
                                sortAsc = true;
                            else
                                sortAsc = false;

                        } else
                            JOptionPane.showMessageDialog(null, "Invalid Option");

                        break;

                    case 9: // exit
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Select an option.");
                        break;

                }
            } catch (Exception e) {
                if (e.getMessage() == "Cannot parse null string") {
                    // JOptionPane.showMessageDialog(null, "Use the exit option");
                    // JOptionPane.showMessageDialog(null, "The exit option exists...");
                    System.exit(0);
                } else if (e.getMessage() == "For input string: \"\"") {
                    JOptionPane.showMessageDialog(null, "No option selected");
                } else {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Invalid Option");
                }
            }
        }
    }

    public static int menu(boolean currentList, boolean sortAsc) {

        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "Current List:" + (currentList ? " A " : " B ").toString()
                        + "\nSort Direction: " + (sortAsc ? "Ascending" : "Descending").toString()
                        + """
                                \n
                                1. Append to start.
                                2. Append to end.
                                3. Append sorted.
                                4. Sort list.
                                5. Search data.
                                6. Math operatios with two lists.
                                7. Show list.
                                8. Config
                                9. exit\n
                                """));
    }
}
