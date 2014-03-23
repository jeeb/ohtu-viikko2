package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 * Created by jeeb on 23.3.2014.
 */
public interface KirjanpitoInterface {
    void lisaaTapahtuma(String tapahtuma);

    ArrayList<String> getTapahtumat();
}
