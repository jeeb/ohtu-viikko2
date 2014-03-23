package ohtu.verkkokauppa;

/**
 * Created by jeeb on 23.3.2014.
 */
public interface PankkiInterface {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
