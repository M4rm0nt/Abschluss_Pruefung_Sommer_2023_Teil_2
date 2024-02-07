package aufgabe_3;

import java.util.HashMap;
import java.util.Map;

public class TicketStatistik {

    public static void main(String[] args) {
        TicketData[] tickets = new TicketData[3];

        tickets[0] = new TicketData(0, "Januar", "2023", 31);
        tickets[1] = new TicketData(1, "Januar", "2023", 31);
        tickets[2] = new TicketData(2, "Februar", "2023", 28);

        Map<String, Statistik> monatsStatistik = new HashMap<>();
        Statistik jahresStatistik = new Statistik();

        for (TicketData ticket : tickets) {
            String monatSchluessel = ticket.getMonat() + " " + ticket.getJahr();
            monatsStatistik.putIfAbsent(monatSchluessel, new Statistik());
            Statistik monatStat = monatsStatistik.get(monatSchluessel);

            monatStat.updateStatistik(ticket.getNutzungsZaehler());
            jahresStatistik.updateStatistik(ticket.getNutzungsZaehler());
        }

        System.out.println("\nNutzungsstatistik Monatstickets\n");

        for (Map.Entry<String, Statistik> entry : monatsStatistik.entrySet()) {
            System.out.println("Auswertung für Monat " + entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
        }

        System.out.println("Auswertung für Jahr 2023");
        System.out.println(jahresStatistik);
    }
}
