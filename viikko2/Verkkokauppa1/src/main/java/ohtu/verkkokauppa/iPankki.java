package ohtu.verkkokauppa;

public interface iPankki {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
