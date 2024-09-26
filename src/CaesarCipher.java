import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        String alphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Шаг шифровки:");
        int shift = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Сообщение для шифровки:");
        String message = scanner.nextLine().trim();
        if (message.isEmpty()) {
            message = "Фамилия Имя Отчество";
        }

        ArrayList<Integer> caseList = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i))) {
                caseList.add(i);
            }
        }
        message = message.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index != -1) {
                result.append(alphabet.charAt(index + shift));
            } else {
                result.append(c);
            }
        }

        String encoded = result.toString().toLowerCase();
        StringBuilder finalResult = new StringBuilder();

        for (int i = 0; i < encoded.length(); i++) {
            if (caseList.contains(i)) {
                finalResult.append(Character.toUpperCase(encoded.charAt(i)));
            } else {
                finalResult.append(encoded.charAt(i));
            }
        }

        System.out.println(encoded.toUpperCase());
        System.out.println("Res: " + finalResult.toString());
    }
}