package chucknorris;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = sc.nextLine();
            if ("encode".equals(operation)) {
                encode();
            } else if ("decode".equals(operation)) {
                decode();
            } else if ("exit".equals(operation)) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.printf("There is no '%s' operation", operation);
            }
            System.out.println();
        }
    }

    private static void encode() {
        System.out.println("Input string:");
        String s = sc.nextLine();

        char[] chars = s.toCharArray();
        String tmp = "";
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            tmp += String.format("%7s", Integer.toBinaryString(chars[i])).replace(" ", "0");
        }

        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '0') {
                result += "00 0";
            }
            if (tmp.charAt(i) == '1') {
                result += "0 0";
            }

            while (i + 1 < tmp.length() && tmp.charAt(i) == tmp.charAt(i + 1)) {
                i++;
                result += "0";
            }
            result += " ";
        }

        System.out.println("Encoded string:");
        System.out.println(result);
    }

    private static void decode() {
        System.out.println("Input encoded string:");
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String tmp = "";
        String result = "";

        // validation
        if (!s.contains("0") || !s.contains(" ")) {
            System.out.println("Encoded string is not valid.");
            return;
        }
        for (int i = 0; i < split.length; i+=2) {
            if (!"0".equals(split[i]) && !"00".equals(split[i])) {
                System.out.println("Encoded string is not valid.");
                return;
            }
        }


        if (split.length % 2 == 1) {
            System.out.println("Encoded string is not valid.");
            return;
        }


        // convert binary
        for (int i = 1; i < split.length; i += 2) {
            String add = split[i - 1].length() == 1 ? "1" : "0";
            for (int j = 0; j < split[i].length(); j++) {
                tmp += add;
            }
        }

        if (tmp.length() % 7 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        for (int i = 0; i < tmp.length(); i += 7) {
            char aChar = (char) Integer.parseInt(tmp.substring(i, i + 7), 2);
            result += String.valueOf(aChar);
        }



        System.out.println("Decoded string:");
        System.out.println(result);
    }
}