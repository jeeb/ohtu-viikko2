package ohtu.verkkokauppa;

/**
 * Created by jeeb on 23.3.2014.
 */
public interface OstoskoriInterface {
    void lisaa(Tuote t);

    void poista(Tuote t);

    int hinta();
}
