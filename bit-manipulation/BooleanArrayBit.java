/**
 * Implements a list of boolean values as an array of bits.
 *
 * @author Oreste Luci
 */
public class BooleanArrayBit {

    // 32 bits
    private int booleanArray;

    public static void main(String[] args) {

        BooleanArrayBit bol = new BooleanArrayBit();

        bol.setTrue(5);
        bol.pintArray();

        bol.setTrue(3);
        bol.pintArray();

        bol.setTrue(10);
        bol.pintArray();

        bol.setFalse(5);
        bol.pintArray();


        bol.pintArray();
    }

    public void setTrue(int position) {

        int mask = 1 << position;

        booleanArray = booleanArray | mask;
    }

    public void setFalse(int position) {

        int mask = 1 << position;
        mask = ~mask;

        booleanArray = booleanArray & mask;
    }

    public boolean getValue(int position) {

        int mask = 1 << position;

        int result = booleanArray & mask;

        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void pintArray() {
        System.out.println(Integer.toString(booleanArray,2));
    }
}
