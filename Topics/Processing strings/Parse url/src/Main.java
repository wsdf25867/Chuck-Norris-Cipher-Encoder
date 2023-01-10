import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s.split("\\?")[1];
        String[] split = s1.split("&");

        for (String s2 : split) {
            String[] strings = s2.split("=");
            if (strings.length > 1) {
                System.out.println(strings[0] + " : " + strings[1]);
            } else {
                System.out.println(strings[0] + " : not found");
            }
        }

        for (String s2 : split) {
            String[] strings = s2.split("=");
            if ("pass".equals(strings[0])) {
                System.out.println("password : " + strings[1]);
            }
        }
    }
}