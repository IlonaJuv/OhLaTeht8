import TimeUtils.TimeUtils;

public class Main {
     public static void main(String[] args) {
         int aika = 86399;
         String tulos = TimeUtils.secToTime(aika);
         System.out.println("Aika: " + tulos);

    }
}
