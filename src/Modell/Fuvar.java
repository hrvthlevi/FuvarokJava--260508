package Modell;

public class Fuvar {

    public enum FizMod {
        KÁRTYA, KÉSZPÉNZ, UTALÁS, CSEKK, ISMERETLEN
    }

    private String rsz;
    private int idomp;
    private double osszeg;
    private FizMod fizMod;

    public String getRsz() {
        return rsz;
    }

    public int getIdomp() {
        return idomp;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public FizMod getFizMod() {
        return fizMod;
    }

}
