package ohtu.verkkokauppa;

/**
 * Created by jeeb on 23.3.2014.
 */
public interface VarastoInterface {
    Tuote haeTuote(int id);

    int saldo(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);
}
