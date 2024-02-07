package aufgabe_3;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public String getJahr() {
        return jahr;
    }

    public void setJahr(String jahr) {
        this.jahr = jahr;
    }

    public int getNutzungsZaehler() {
        return nutzungsZaehler;
    }

    public void setNutzungsZaehler(int nutzungsZaehler) {
        this.nutzungsZaehler = nutzungsZaehler;
    }
}
