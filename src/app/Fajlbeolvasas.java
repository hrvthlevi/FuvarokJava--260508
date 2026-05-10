package app;

import Modell.Fuvar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fajlbeolvasas {

    private static List<Fuvar> fuvarok = new ArrayList<>();
    private static double aktualisForintArfolyam = 356.24;

    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");

        List<String> sorok = Files.readAllLines(path);

        for (String sor : sorok) {
            String[] s = sor.split(";");
            //System.out.println("sor: " + sor);
            String rsz = s[0];
            int idomp = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String fizmod = s[3];

            Fuvar fuvar = new Fuvar(rsz, idomp, osszeg, fizmod);
            fuvarok.add(fuvar);
        }

        osszesFuvarErteke();
        legdragabbFuvarRendszama();
        legolcsobbFuvarForintban();
        hanyKartyasFizetesVolt();
        mindenFizetesiModMeghatarozott();
        hanyDbAutoVanARendszerben();
        hanyFeleFizetesiModVan();

    }

    private static void osszesFuvarErteke() {
        int n = fuvarok.size();
        int i = 0;
        double osszeg = 0;
        while (i < n) {
            osszeg += fuvarok.get(i).getOsszeg();
            i++;
        }
        System.out.println("Összes fuvar értéke: " + osszeg);
    }

    private static void legdragabbFuvarRendszama() {
        int n = fuvarok.size();
        int i = 1;
        int maxIndex = 0;

        while (i < n) {
            if (fuvarok.get(i).getOsszeg() > fuvarok.get(maxIndex).getOsszeg()) {
                maxIndex = i;
            }
            i++;
        }
        System.out.println("Összege: " + fuvarok.get(maxIndex).getOsszeg());
        System.out.println("Legdrágább fuvar rendszáma: " + fuvarok.get(maxIndex).getRsz());

    }

    private static void legolcsobbFuvarForintban() {
        int n = fuvarok.size();
        int i = 1;
        int minIndex = 0;
        while (i < n) {
            if (fuvarok.get(i).getOsszeg() < fuvarok.get(minIndex).getOsszeg()) {
                minIndex = i;
            }
            i++;
        }
        double forintban = fuvarok.get(minIndex).getOsszeg() * aktualisForintArfolyam;
        System.out.println("Legolcsóbb fuvar rendszáma: " + fuvarok.get(minIndex).getRsz());
        System.out.println("Összege forintban: " + forintban);
    }

    private static void hanyKartyasFizetesVolt() {
        int n = fuvarok.size();
        int i = 0;
        int db = 0;
        while (i < n) {
            if (fuvarok.get(i).getFizMod().equals("kártya")) {
                db++;
            }
            i++;
        }
        System.out.println("Kártyás fizetések száma: " + db);
    }

    private static void mindenFizetesiModMeghatarozott() {
        int n = fuvarok.size();
        int i = 0;
        while (i < n && !fuvarok.get(i).getFizMod().equals("-")) {
            i++;
        }

        String valasz = i >= n ? "igen" : "nem";
        System.out.println("Minden fizetési mód meghatározott: " + valasz);
    }

    private static void hanyDbAutoVanARendszerben() {
        int n = fuvarok.size();
        int i = 0;
        Set<String> rszHalmaz = new HashSet<>();
        while (i < n) {
            rszHalmaz.add(fuvarok.get(i).getRsz());
            i++;
        }
        System.out.println("Autók száma a rendszerben: " + rszHalmaz.size());
    }

    private static void hanyFeleFizetesiModVan() {
        int n = fuvarok.size();
        int i = 0;
        Set<String> fizModHalmaz = new HashSet<>();
        while (i < n) {
            fizModHalmaz.add(fuvarok.get(i).getFizMod());
            i++;
        }
        System.out.println("Féle fizetési mód: " + fizModHalmaz.size());
    }
}
