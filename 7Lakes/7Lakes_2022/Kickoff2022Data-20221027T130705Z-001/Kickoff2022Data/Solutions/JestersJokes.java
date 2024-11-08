import java.util.Scanner;

public class JestersJokes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String ans = "Fungeon List:\n";
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            name = name.substring(0, name.length() - 1);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.replaceAll(" ", "").length() == 0) {
                    break;
                }
                if (line.toLowerCase().contains("stroud") && !name.equals("Jester") && !ans.contains(name)) {
                    ans += name + "\n";
                }
            }
        }

        System.out.println(ans);
    }
}
