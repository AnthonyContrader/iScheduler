package it.contrader.main;

/*
 * Ogni applicazione java necessita di una funzione main() 
 * Essa sarà di fatto la prima funzione chiamata dalla JVM, la sua mancanza verrà infatti notata dall'interprete che 
 * quindi non permetterà l'avvio del programma.
 * Banalmente qualsiasi applicazione a cascata ( stile C ) potrebbe essere interamente scritta all'interno del main
 * ma questo non avrebbe senso all'interno di un linguaggio di programmazione ad oggetti.
 * Per ulteriori dettagli GUIDA SEZIONE 1.
*/
public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Login", "doControl", null);
    }

}
