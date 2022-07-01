package com.kosmoloty;
import java.util.Objects;

import static java.lang.Math.abs;

public class Kosmolot {

    private String nazwa;
    private Integer predkoscX;
    private Integer predkoscY;
    private Integer aktualnaPozycjaX;
    private Integer aktualnaPozycjaY;
    private Integer poczatkowaPozycjaX;
    private Integer poczatkowaPozycjaY;
    private Integer przebytyDystans;

    public Kosmolot(String nazwa, int predkoscX, int predkoscY, int poczatkowaPozycjaX, int poczatkowaPozycjaY) {
        this.nazwa = nazwa;
        this.predkoscX = predkoscX;
        this.predkoscY = predkoscY;
        this.aktualnaPozycjaX = poczatkowaPozycjaX;
        this.aktualnaPozycjaY = poczatkowaPozycjaY;
        this.poczatkowaPozycjaX = poczatkowaPozycjaX;
        this.poczatkowaPozycjaY = poczatkowaPozycjaY;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getPredkoscX() {
        return predkoscX;
    }

    public void setPredkoscX(Integer predkoscX) {
        this.predkoscX = predkoscX;
    }

    public Integer getPredkoscY() {
        return predkoscY;
    }

    public void setPredkoscY(Integer predkoscY) {
        this.predkoscY = predkoscY;
    }

    public Integer getAktualnaPozycjaX() {
        return aktualnaPozycjaX;
    }

    public void setAktualnaPozycjaX(Integer aktualnaPozycjaX) {
        this.aktualnaPozycjaX = aktualnaPozycjaX;
    }

    public Integer getAktualnaPozycjaY() {
        return aktualnaPozycjaY;
    }

    public void setAktualnaPozycjaY(Integer aktualnaPozycjaY) {
        this.aktualnaPozycjaY = aktualnaPozycjaY;
    }

    public Integer getPoczatkowaPozycjaX() {
        return poczatkowaPozycjaX;
    }

    public void setPoczatkowaPozycjaX(Integer poczatkowaPozycjaX) {
        this.poczatkowaPozycjaX = poczatkowaPozycjaX;
    }

    public Integer getPoczatkowaPozycjaY() {
        return poczatkowaPozycjaY;
    }

    public void setPoczatkowaPozycjaY(Integer poczatkowaPozycjaY) {
        this.poczatkowaPozycjaY = poczatkowaPozycjaY;
    }

    public Integer getPrzebytyDystans() {
        return przebytyDystans;
    }

    public void setPrzebytyDystans(Integer przebytyDystans) {
        this.przebytyDystans = przebytyDystans;
    }

    public void obliczOrazUstawNowePozycje() {
        this.aktualnaPozycjaX = this.aktualnaPozycjaX + this.predkoscX;
        this.aktualnaPozycjaY = this.aktualnaPozycjaY + this.predkoscY;
    }

    public void obliczPrzebytyDystans(){
        this.przebytyDystans = (abs(this.aktualnaPozycjaX)-abs(this.poczatkowaPozycjaX))+(abs(this.aktualnaPozycjaY)-abs(this.poczatkowaPozycjaY));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kosmolot kosmolot = (Kosmolot) o;
        return !(nazwa.equals(kosmolot.nazwa)) || !(aktualnaPozycjaX.equals(kosmolot.aktualnaPozycjaX)) && !(aktualnaPozycjaY.equals(kosmolot.aktualnaPozycjaY));
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, aktualnaPozycjaX, aktualnaPozycjaY);
    }

    @Override
    public String toString() {
        return "Kosmolot{" +
                "nazwa='" + nazwa + '\'' +
                ", predkoscX=" + predkoscX +
                ", predkoscY=" + predkoscY +
                ", aktualnaPozycjaX=" + aktualnaPozycjaX +
                ", aktualnaPozycjaY=" + aktualnaPozycjaY +
                ", poczatkowaPozycjaX=" + poczatkowaPozycjaX +
                ", poczatkowaPozycjaY=" + poczatkowaPozycjaY +
                ", przebytyDystans=" + przebytyDystans +
                '}';
    }
}