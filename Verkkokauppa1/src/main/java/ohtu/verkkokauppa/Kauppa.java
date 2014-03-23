package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private VarastoInterface varastoInterface;
    private PankkiInterface pankkiInterface;
    private OstoskoriInterface ostoskoriInterface;
    private ViitegeneraattoriInterface viitegeneraattoriInterface;
    private String kaupanTili;

    @Autowired
    public Kauppa(PankkiInterface pankki, VarastoInterface varasto,
                  ViitegeneraattoriInterface viitegen) {
        varastoInterface = varasto;
        pankkiInterface = pankki;
        viitegeneraattoriInterface = viitegen;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskoriInterface = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varastoInterface.haeTuote(id);
        varastoInterface.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varastoInterface.saldo(id)>0) {
            Tuote t = varastoInterface.haeTuote(id);
            ostoskoriInterface.lisaa(t);
            varastoInterface.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattoriInterface.uusi();
        int summa = ostoskoriInterface.hinta();
        
        return pankkiInterface.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
