package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;

    private int kasvatuskoko;
    private int[] joukko;
    private int alkioidenLkm;
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen");
        }
        joukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }
    
    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }            

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)){            
            if (alkioidenLkm == joukko.length) {
                kasvataTaulukkoa();
            }            
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;           
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int indeksi = haeIndeksi(luku);
        if (indeksi != -1) {
            siirraVasemmalle(indeksi);
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    private void kasvataTaulukkoa() {    
        int uusiTaulukonKoko = alkioidenLkm + kasvatuskoko;        
        int[] uusiTaulukko = new int[uusiTaulukonKoko];
        for (int i = 0; i < joukko.length; i++) {
            uusiTaulukko[i] = joukko[i];
        }    
        joukko = uusiTaulukko;
    }
    
    private int haeIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return i;
            }
        }
        return -1;
    }
    
    private void siirraVasemmalle(int indeksi) {
        for (int j = indeksi; j < alkioidenLkm - 1; j++) {
            joukko[j] = joukko[j + 1];
        }
    }

    public int alkioita() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + joukko[0] + "}";
        } else {
            String merkkijono = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                merkkijono += joukko[i];
                merkkijono += ", ";
            }
            merkkijono += joukko[alkioidenLkm - 1];
            merkkijono += "}";
            return merkkijono;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
   
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
