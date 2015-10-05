import java.util.*;
import java.io.Console;

/**
 * Produces all the letter combinations for a given phone number
 *
 * @author Oreste Luci
 */
public class TelefoneNumberWords {

    public static void main(String[] args) {

        TelefoneNumberWords tnw = new TelefoneNumberWords();

        tnw.run();
    }

    private void run() {

        System.out.println("Enter the phone number: ");

        Console console = System.console();
        String number = console.readLine();

        words(number, 0, "");
    }

    private static final Map<String, String> keyMapping;
    static
    {
        keyMapping = new HashMap<String, String>();
        keyMapping.put("0", "");
        keyMapping.put("1", "1");
        keyMapping.put("2", "ABC");
        keyMapping.put("3", "DEF");
        keyMapping.put("4", "GHI");
        keyMapping.put("5", "JKL");
        keyMapping.put("6", "MNO");
        keyMapping.put("7", "PQRS");
        keyMapping.put("8", "TUV");
        keyMapping.put("9", "WXYZ");
    }

    private void words(String number, int position, String word) {

        if (number.length() == position) {
            System.out.println(word.toString());
            return;
        }

        char n = number.charAt(position);
        String letters = keyMapping.get("" + n);

        for (int i=0; i<letters.length(); i++) {
            String word2 = word + letters.charAt(i);
            words(number, position + 1, word2);
        }
    }
}
