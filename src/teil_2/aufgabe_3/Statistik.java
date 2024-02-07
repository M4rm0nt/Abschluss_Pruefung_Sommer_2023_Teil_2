package teil_2.aufgabe_3;

public class Statistik {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int summe = 0;
    private int anzahl = 0;

    void updateStatistik(int nutzung) {
        if (nutzung < min) min = nutzung;
        if (nutzung > max) max = nutzung;
        summe += nutzung;
        anzahl++;
    }

    @Override
    public String toString() {
        return "Minimale Nutzung: " + min +
                "\nMaximale Nutzung: " + max +
                "\nDurchschnittlich: " + (summe / anzahl) +
                "\nGesamtanzahl Tickets: " + anzahl;
    }
}