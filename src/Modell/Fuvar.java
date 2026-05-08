package Modell;

public class Fuvar {

//    public enum FizMod {
//        KÁRTYA, KÉSZPÉNZ, UTALÁS, CSEKK, ISMERETLEN
//    }

    private String rsz;
    private int idomp;
    private double osszeg;
    private String fizMod;

    public Fuvar(String rsz, int idomp, double osszeg, String fizMod) {
        this.rsz = rsz;
        this.idomp = idomp;
        this.osszeg = osszeg;
        this.fizMod = fizMod;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdomp() {
        return idomp;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizMod() {
        return fizMod;
    }

}
