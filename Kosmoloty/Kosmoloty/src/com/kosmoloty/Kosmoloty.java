package com.kosmoloty;
public class Kosmoloty extends Obliczenia {

    public static void main(String[] args) {

        wielkoscTourosaX = Integer.parseInt(args[0]);
        wielkoscTourosaY = Integer.parseInt(args[1]);
        boolean y = isInWielkoscTourosaRange(wielkoscTourosaY);
        boolean x = isInWielkoscTourosaRange(wielkoscTourosaX);
        if (x && y) {
            readFile();
            sprawdzenieDanychZPliku();
            if (kosmoloty.size() == 0) {
                klops();
            } else if (kosmoloty.size() == 1) {
                log(kosmoloty.get(0).getNazwa());
            } else {
                /** wiedzac, ze wyscig trwa 24h,a co sekunde zachodzi zmiana pozycji kosmolotu
                 * nalezy docelowo przyjac 86400 iteracji (60s*60m*24h)
                 */
                for (int i = 0; i < 86400; i++) {
                    //logseparator();
                    porownaniePozycjiUsuniecieDuplikatow();
                    obliczanieNowejPozycji();
                    //log(String.valueOf(kosmoloty.size()));
                    if (kosmoloty.size() == 1) {
                        break;
                    }
                }
                if (!(kosmoloty.size() == 1)) {
                    obliczaniePrzebytegoDystansu();
                    szukanieMaxWartosci();
                    remisTakNie();
                    if (wynik == null) {
                        klops();
                    } else {
                        ogloszenieWyniku();
                    }
                } else if (kosmoloty.size() == 1) log(kosmoloty.get(0).getNazwa());
            }
        } else {
            klops();
        }
    }
}