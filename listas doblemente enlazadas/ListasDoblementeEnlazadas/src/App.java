import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Avance lijero en el menu, despues se evaluaran mejores 
        // metodos o formas de hacerlo.
        ListaDobleEnlazada L1 = new ListaDobleEnlazada();
        while (true) {
            switch (menu()) {
                case 1:
                    L1.appendToStart(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: ")));
                    break;

                case 2:
                    L1.appendToEnd(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: ")));
                    break;

                case 3:
                    L1.appendSort(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar un numero: ")),
                            Boolean.parseBoolean(JOptionPane.showInputDialog(null,
                                    "Ingrese true, si quiere que se ordene de forma ascendente, de lo contrario, false:  ")));
                    break;

                case 8:
                    System.out.println("\n");
                    L1.showInConsole();
                    break;

                case 9:
                    System.exit(0);

                default:
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
                5. Sort list.
                6. Search data.
                7. Math operatios with two lists.
                8. Show list.
                9. exit
                """));
    }
}
