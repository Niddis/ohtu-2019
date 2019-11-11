package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface iKirjanpito {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
