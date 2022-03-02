import java.util.*;

public class Main {
    public static void main(String[] args) {

        final String j = "Je";
        final String ja = "J'";
        final String t = "Tu";
        final String i = "Il";
        final String n = "Nous";
        final String v = "Vous";
        final String is = "Ils";
        final String sp = " ";

        List<String[]> data = CSV.get("verbs.csv");
        Random rng = new Random();

        Scanner scanner = new Scanner(System.in);

        int check = 0;
        int check2 = 0;

        while (true) {
            int dt1, dt2;
            String unc, answerCheck, cc1, cc2;
            boolean japstrophe = false;

            dt1 = rng.nextInt(data.size());
            dt2 = rng.nextInt(7);

            String[] work = data.get(dt1);

            if (dt1 == check && dt2 == check2) continue;
            if (dt2 == 0) continue;

            unc = " (" + work[0] + ")";
            answerCheck = work[dt2];

            switch (dt2) {
                case 1:
                    unc = j + unc;
                    if (Objects.equals(work[1], "ai") || Objects.equals(work[1], "ecris")) answerCheck = ja + answerCheck;
                    else answerCheck = j + answerCheck;
                    break;
                case 2:
                    unc = t + unc;
                    answerCheck = t + answerCheck;
                    break;
                case 3:
                    unc = i + unc;
                    answerCheck = i + answerCheck;
                    break;
                case 4:
                    unc = n + unc;
                    answerCheck = n + answerCheck;
                    break;
                case 5:
                    unc = v + unc;
                    answerCheck = v + answerCheck;
                    break;
                case 6:
                    unc = is + unc;
                    answerCheck = is + answerCheck;
                    break;
                default:
                    unc = "ERROR";
                    answerCheck = "ERROR";
            }

            System.out.println(unc);
            String answer = scanner.nextLine();

            cc1 = answer.toUpperCase();
            cc2 = answerCheck.toUpperCase();

            if (answer.equals("111")) break;
            if (cc1.equals(cc2)) {
                System.out.println("Correcte");
                System.out.println();
            }
            else {
                System.out.println("Mauvais");
                System.out.println(answerCheck);
                System.out.println();
            }

            check = dt1;
            check2 = dt2;

        }
    }
}
