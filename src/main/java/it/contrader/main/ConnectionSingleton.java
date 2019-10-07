package it.contrader.main;

import java.io.FileInputStream;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * La Classe ConnectionSingleton implementa il pattern di progettazione Singleton, PER DETTAGLI VEDI GUIDA SEZIONE n. 10
 * Nello specifico implementa è fornisce un metodo sicuro ed efficace per la connessione con il nostro database
 */

public class ConnectionSingleton {

	/*
	 * private : indica una funzione/variabile il cui scope ( ovvero visibilità ) è delineato all'interno della classe in cui
	 * viene creato.
	 * static : indica che il valore della variabile in questione è unico per tutte le instanze della classe
	 * Connection : è un tipo di oggetto
	 */
    private static Connection connection = null;

    /*
     * Costruttore vuoto in quanto esso non ha mai bisogno di essere instanziato
     */
    private ConnectionSingleton() {
    }

    /*
     * La funzione getInstance() è il cuore del pattern Singleton , essa infatti restituisce in output sempre la stesso dato
     * che quindi se modificato verrà modificato la modifica avverrà a tutte le chiamate.
     * All'interno della funzione si spiega passo per passo l'implementazione attuale
     */
    public static Connection getInstance() {
    	// eseguo un controllo per assicurarmi che non sia la prima instanza del dato
        if (connection == null) {
        	// nel caso sia la prima volta procedo con l'eseguire la connessione al database che rimarrà quindi la stessa
        	// per tutto il corso del programma.
        	// & il costrutto try/catch è utilizzato principalmente per la gestione degli errori, maggiori info SEZIONE 1.
            try {
            	// creo un nuovo oggetto properties
                Properties properties = new Properties();
                // tramite un inputStream, nello specifico un FileInputStream, carico le proprietà presenti nel file specificato
                InputStream inputStream = new FileInputStream("config.properties");
                properties.load(inputStream);
                /*
                *a questo punto recupero dalle proprietà le varie specifiche di cui necessitiamo
                * a seconda del database utilizzato esse saranno diverse di volta in volta
                * le varie specifiche sono facilmente recuperabili sulla rete, modificare di conseguenza il file config.properties
                * PS: quelle di base necessitano solo la modifica del nome del database 
                */
                String vendor = properties.getProperty("db.vendor");
                String driver = properties.getProperty("db.driver");
                String host = properties.getProperty("db.host");
                String port = properties.getProperty("db.port");
                String dbName = properties.getProperty("db.name");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                String jdbcAdditionalParams=properties.getProperty("db.jdbc_params");
                
    			Class<?> c = Class.forName(driver);
    			System.out.println("Ho caricato: " + c.getName());
    			// compongo la stringa di connessione al database
                String url = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName+"?"+jdbcAdditionalParams;
                // eseguo la connessione al database
    			connection = (Connection) DriverManager.getConnection(url, username, password);

            
            } catch (Exception e) {
        
            }
        }
        // restituisco in output la connessione al database
        // essendo la classe un Singleton una volta creata la prima instanza restituira sempre la stessa
        return connection;
    }

}
