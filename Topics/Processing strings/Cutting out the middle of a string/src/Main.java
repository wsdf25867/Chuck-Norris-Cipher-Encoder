import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = "";
        if (s.length() % 2 == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() / 2) {
                    continue;
                }
                result += String.valueOf(s.charAt(i));
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() / 2 - 1 || i == s.length() / 2) {
                    continue;
                }
                result += String.valueOf(s.charAt(i));
            }
        }

        System.out.println(result);
    }
}