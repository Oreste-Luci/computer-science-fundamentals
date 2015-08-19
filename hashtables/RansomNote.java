import java.util.HashMap;

/**
 * Determines is a ransom note can be written form the magazine;
 *
 * @author Oreste Luci
 */
public class RansomNote {

    public static void main(String[] args) {

        String note = RansomNote.getRansomNote();
        String magazine = RansomNote.getMagazine();

        System.out.println(RansomNote.canRansomNoteBeWritten(note,magazine));
    }

    public static boolean canRansomNoteBeWritten(String note, String magazine) {

        String[] noteWords = note.split(" ");
        HashMap<String,Integer> magazineMap = getMapFromString(magazine);

        for (String word : noteWords) {

            Integer count = magazineMap.get(word.toUpperCase());

            if (count == null || count.intValue() == 0) {
                return false;
            }

            count = new Integer(count.intValue() - 1);

            magazineMap.put(word.toUpperCase(),count);
        }

        return true;
    }

    public static HashMap<String,Integer> getMapFromString(String message) {

        HashMap<String,Integer> map = new HashMap<>();

        if (message == null || message.length()==0) {
            return map;
        }

        String[] words = message.split(" ");

        for (String word : words) {

            Integer count = map.get(word);

            if (count == null) {
                map.put(word.toUpperCase(),new Integer(1));
            } else {
                map.put(word.toUpperCase(),new Integer(count.intValue() + 1));
            }
        }

        return map;
    }

    public static String getRansomNote() {
        return "You will die";
    }

    public static String getMagazine() {
        return "die all the colours you will";
    }
}
