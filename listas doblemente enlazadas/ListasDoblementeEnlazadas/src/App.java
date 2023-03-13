public class App {
    public static void main(String[] args) throws Exception {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        /* 
         
        lista.appendToEnd(8);
        lista.appendToEnd(6);
        lista.appendToEnd(4);
        lista.appendToEnd(2);
        lista.appendToEnd(1);
        */


        lista.appendToEnd(2);
        lista.appendToEnd(4);
        lista.appendToEnd(6);
        lista.appendToEnd(8);
        lista.appendToEnd(1);

        lista.sort(false);

        lista.showInConsole();
    }
}
