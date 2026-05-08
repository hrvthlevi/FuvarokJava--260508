package app;

import Modell.Fuvar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Fajlbeolvasas {

    private static List<Fuvar> fuvarok = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");

        List<String> sorok = Files.readAllLines(path);

        for (String sor : sorok) {
            String[] s = sor.split(";");
            System.out.println("sor: " + sor);
            String rsz = s[0];
            int idomp = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String fizmod = s[3];

            Fuvar fuvar = new Fuvar(rsz, idomp, osszeg, fizmod);
            fuvarok.add(fuvar);
        }
    }

}
