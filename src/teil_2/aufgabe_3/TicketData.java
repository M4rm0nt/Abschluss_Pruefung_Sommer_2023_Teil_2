package teil_2.aufgabe_3;

public class TicketData {
    private int id;
    private String monat;
    private String jahr;
    private int nutzungsZaehler;

    public TicketData(int id, String monat, String jahr, int nutzungsZaehler) {
        this.id = id;
        this.monat = monat;
        this.jahr = jahr;
        this.nutzungsZaehler = nutzungsZaehler;
    }

    public String getMonat() {
        return monat;
    }

    public String getJahr() {
        return jahr;
    }

    public int getNutzungsZaehler() {
        return nutzungsZaehler;
    }

}
