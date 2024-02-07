package aufgabe_2;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class ParkVisitorCounter {

    // Wenn man die Datei "visitorCount.csv" in einem Tabellenkalkulationsprogramm öffnet, bekommt man eine geordnete Ausgabe!

    public static void main(String[] args) {

        try {
            ComeLeave[] entries = generateRandomEntries(2023, Calendar.MAY);
            Integer[][] visitorCount = countVisitors(entries);

            try (PrintWriter writer = new PrintWriter("visitorCount.csv")) {
                StringBuilder sb = getStringBuilder(visitorCount);
                writer.write(sb.toString());
            }

            System.out.println("Daten wurden in 'visitorCount.csv' gespeichert.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getStringBuilder(Integer[][] visitorCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("Tag/std,");
        for (int i = 9; i < 19; i++) {
            sb.append(i + ":00-" + i + ":59,");
        }
        sb.setLength(sb.length() - 1);
        sb.append("\n");

        for (int i = 0; i < visitorCount.length; i++) {
            sb.append((i + 1) + ",");
            for (int j = 0; j < visitorCount[i].length; j++) {
                sb.append(visitorCount[i][j] + ",");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        return sb;
    }

    public static Integer[][] countVisitors(ComeLeave[] entries) {
        int daysInMonth = getDaysOfMonth(entries[0].getDate());
        Integer[][] visitorCount = new Integer[daysInMonth][10];

        for (int i = 0; i < daysInMonth; i++) {
            for (int j = 0; j < 10; j++) {
                visitorCount[i][j] = 0;
            }
        }

        int[] currentVisitors = new int[daysInMonth];

        for (ComeLeave entry : entries) {
            int day = getDay(entry.getDate()) - 1;
            int hour = getHour(entry.getDate()) - 9;

            if (hour >= 0 && hour < 10) {
                if (entry.getComeInOut() == 0) {
                    currentVisitors[day] += entry.getNoPeople();
                } else {
                    currentVisitors[day] = Math.max(0, currentVisitors[day] - entry.getNoPeople());
                }
                visitorCount[day][hour] = currentVisitors[day];
            }
        }

        return visitorCount;
    }

    private static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    private static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    private static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

public static ComeLeave[] generateRandomEntries(int year, int month) {
    Random random = new Random();
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, 1);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    int estimatedEntriesPerDay = 10;
    ComeLeave[] entries = new ComeLeave[daysInMonth * estimatedEntriesPerDay];

    for (int i = 0; i < entries.length; i++) {
        int day = random.nextInt(daysInMonth) + 1;
        int hour = 9 + random.nextInt(10);
        int minute = random.nextInt(60);

        calendar.set(year, month, day, hour, minute);
        Date date = calendar.getTime();

        int comeInOut = random.nextInt(2);
        int noPeople = 1 + random.nextInt(5);

        entries[i] = new ComeLeave(date, comeInOut, noPeople);
    }

    return entries;
}

    public static class ComeLeave {

        private Date date;
        private Integer comeInOut;
        private Integer noPeople;

        public ComeLeave(Date date, Integer comeInOut, Integer noPeople) {
            this.date = date;
            this.comeInOut = comeInOut;
            this.noPeople = noPeople;
        }

        public Date getDate() {
            return date;
        }
        public Integer getComeInOut() {
            return comeInOut;
        }
        public Integer getNoPeople() {
            return noPeople;
        }
        public void setNoPeople(Integer noPeople) {
            this.noPeople = noPeople;
        }

    }

}
