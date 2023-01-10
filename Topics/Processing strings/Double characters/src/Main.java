import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) + String.valueOf(s.charAt(i));
        }

        System.out.println(result);
    }
}