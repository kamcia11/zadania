package com.kosmoloty;
import java.util.*;

public class Obliczenia {

    public static List<String> readedFile = new ArrayList<>();
    public static Integer wielkoscTourosaX;
    public static Integer wielkoscTourosaY;
    public static List<String> listaWartosci = new ArrayList<>();
    public static List<Kosmolot> kosmoloty = new ArrayList<>();
    public static List<Kosmolot> kosmolotyFiltr = new ArrayList<>();
    public static Integer index;
    public static Integer maxValue;
    public static String wynik = null;
    public static Integer size;

    protected static void log(String text) {
        System.out.println(text);
    }

    protected static void logseparator() {
        log("----------");
    }

    private static boolean isNazwaAlphaNumeric(String nazwa) {
       /*if (nazwa != null && nazwa.matches("^[a-zA-Z0-9]*$") && nazwa.length() <= 10) {
            log("nazwa jest w zakresie");
        } else {
            log("nazwa nie jest w zakresie");
        }
        */
        return nazwa != null && nazwa.matches("^[a-zA-Z0-9]*$") && nazwa.length() <= 10;
    }

    private static boolean isInPredkoscRange(Integer predkosc) {
        /*if (predkosc != null && predkosc >= -10000 && predkosc <= 10000) {
            log("predkosc jest w zakresie");
        } else {
            log("predkosc nie jest w zakresie");
        }
         */
        return predkosc != null && (predkosc >= -10000 && predkosc <= 10000);
    }

    public static boolean isInWielkoscTourosaRange(Integer wielkosc) {
        /*if (wielkosc != null && wielkosc >= 1 && wielkosc <= 100000) {
            log("wielkosc jest w zakresie");
        } else {
            log("wielkosc nie jest w zakresie");
        }
         */
        return wielkosc != null && (wielkosc >= 1 && wielkosc <= 100000);
    }

    private static boolean isInPozycjaRange(Integer pozycja, Integer wielkosc_tourosa) {
        /*if (pozycja != null && pozycja >= 0 && pozycja <= wielkosc_tourosa - 1) {
            log("pozycja jest w zakresie");
        } else {
            log("pozycja nie jest w zakresie");
        }
         */
        return pozycja != null && (pozycja >= 1 && pozycja <= wielkosc_tourosa - 1);
    }

    public static void readFile() {
        try {
            Scanner myReader = new Scanner(System.in);
            while (myReader.hasNextLine()) {
                readedFile = List.of((myReader.nextLine().split("\\\\n")));
                String wiersz = (String.valueOf(readedFile)).substring(1);
                wiersz = wiersz.substring(0, (wiersz.length() - 1));
                listaWartosci.add(wiersz);
            }
            myReader.close();

        } catch (Exception e) {
            //System.out.println("An error occurred.");
            klops();
            //e.printStackTrace();
        }
    }

    public static void sprawdzenieDanychZPliku() {

        for (int z = 0; z < listaWartosci.size(); z++) {
            String[] pojedynczyWiersz = (listaWartosci.get(z)).split(",", 5);
            String part1 = pojedynczyWiersz[0];
            int part2 = Integer.parseInt(pojedynczyWiersz[1]);
            int part3 = Integer.parseInt(pojedynczyWiersz[2]);
            int part4 = Integer.parseInt(pojedynczyWiersz[3]);
            int part5 = Integer.parseInt(pojedynczyWiersz[4]);

            Kosmolot kosmolot = new Kosmolot(part1, part2, part3, part4, part5);

            if (isNazwaAlphaNumeric(part1)
                    && isInPredkoscRange(part2)
                    && isInPredkoscRange(part3)
                    && isInPozycjaRange(part4, wielkoscTourosaX)
                    && isInPozycjaRange(part5, wielkoscTourosaY)
            ) {
                kosmoloty.add(kosmolot);
            }
        }

    }

    public static void porownaniePozycjiUsuniecieDuplikatow() {
        size = kosmoloty.size();
        Set<Kosmolot> filtrowaneKosmoloty = new HashSet<>();

        // log("kosmoloty przed: ");
        //for (Kosmolot kosmolot: kosmoloty){log(kosmolot.getNazwa());}

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((((kosmoloty.get(i).getAktualnaPozycjaX() == kosmoloty.get(j).getAktualnaPozycjaX())
                        && ((kosmoloty.get(i).getAktualnaPozycjaY() == kosmoloty.get(j).getAktualnaPozycjaY())))
                        || (kosmoloty.get(i).getNazwa().equals(kosmoloty.get(j).getNazwa())))) {
                    filtrowaneKosmoloty.add(kosmoloty.get(i));
                    filtrowaneKosmoloty.add(kosmoloty.get(j));
                }

            }
        }
        kosmolotyFiltr = new ArrayList<>(filtrowaneKosmoloty);

       /* log("kosmoloty filtr: ");
        for (Kosmolot kosmolot : kosmolotyFiltr) {
            log(kosmolot.getNazwa());
        }
        log("filtr rozmiar " + kosmolotyFiltr.size());*/

        for (int c = 0; c < kosmolotyFiltr.size(); c++) {
            String nazwa = kosmolotyFiltr.get(c).getNazwa();
            int zxc = kosmoloty.size() - 1;
            for (int a = kosmoloty.size() - 1; a >= 0; a--) {
                String nazwak = kosmoloty.get(a).getNazwa();
                if (nazwak.equals(nazwa)) {
                    kosmoloty.remove(a);
                }
            }
        }
        /*log("kosmoloty po: ");
        for (Kosmolot kosmolot : kosmoloty) {
            log(kosmolot.getNazwa());
        }
        log(String.valueOf(size));*/
    }


    public static void obliczanieNowejPozycji() {
        for (Kosmolot kosmolot : kosmoloty) {
            kosmolot.obliczOrazUstawNowePozycje();
        }
    }

    public static void obliczaniePrzebytegoDystansu() {
        for (Kosmolot kosmolot : kosmoloty) {
            kosmolot.obliczPrzebytyDystans();
        }
    }

    public static Integer szukanieMaxWartosci() {
        int maxValue = kosmoloty.get(0).getPrzebytyDystans();
        index = 0;

        for (int i = 1; i < kosmoloty.size(); i++) {
            int vvv = kosmoloty.get(i).getPrzebytyDystans();
            if (vvv > maxValue) {
                maxValue = kosmoloty.get(i).getPrzebytyDystans();
                index = i;
            }
        }
        //log(""+maxValue);
        //log(kosmoloty.get(index).getNazwa());
        return index;
    }

    public static String remisTakNie() {
        maxValue = kosmoloty.get(index).getPrzebytyDystans();
        for (int i = 0; i < kosmoloty.size(); i++) {
            for (int j = i + 1; j < kosmoloty.size(); j++) {
                int xxx = kosmoloty.get(j).getPrzebytyDystans();
                if ((maxValue == xxx) && (!(j == index))) {
                    wynik = "remis";
                    break;

                } else {
                    wynik = "brak remisu";
                }
            }
            if (wynik.equals("remis")) break;
        }
        return wynik;
    }

    public static void ogloszenieWyniku() {
        if (wynik.equals("brak remisu") && !wynik.equals(null)) {
            //logseparator();
            log(kosmoloty.get(index).getNazwa());
            //logseparator();
        } else if (wynik.equals("remis") && !wynik.equals(null)) {
            // logseparator();
            log("remis");
            // logseparator();
        } else {
            klops();
        }
    }

    public static void klops() {
        log("klops");
    }
}