package it.contrader.utils;

public class GestoreEccezioni {
    private static GestoreEccezioni ourInstance = new GestoreEccezioni();

    public static GestoreEccezioni getInstance() {
        return ourInstance;
    }

    private GestoreEccezioni() {
    }

    public void gestisciEccezione(Throwable e){
        e.printStackTrace();
    }


}
