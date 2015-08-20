/**
 * http://www.radford.edu/~nokie/classes/360/dp-rod-cutting.html
 *
 * @author Oreste Luci
 */
public class CutRod {

    public static void main(String[] args) {

        CutRod rod = new CutRod();

        float[] prices = {1.0f, 5.0f, 8.0f, 9.0f, 10.0f, 17.0f, 17.0f, 20.0f};

        System.out.println(rod.cutRod(prices,1));
        System.out.println(rod.cutRod(prices,2));
        System.out.println(rod.cutRod(prices,3));
        System.out.println(rod.cutRod(prices,4));
        System.out.println(rod.cutRod(prices,5));
        System.out.println(rod.cutRod(prices,6));
        System.out.println(rod.cutRod(prices,7));
        System.out.println(rod.cutRod(prices,8));

        System.out.println("\nMemorized algorithm:");
        System.out.println(rod.memorizedCutRod(prices,1));
        System.out.println(rod.memorizedCutRod(prices,2));
        System.out.println(rod.memorizedCutRod(prices,3));
        System.out.println(rod.memorizedCutRod(prices,4));
        System.out.println(rod.memorizedCutRod(prices,5));
        System.out.println(rod.memorizedCutRod(prices,6));
        System.out.println(rod.memorizedCutRod(prices,7));
        System.out.println(rod.memorizedCutRod(prices,8));
    }

    public float cutRod(float[] prices, int pieces) {

        if (pieces == 0) {
            return 0;
        }

        float price = -1;

        for (int i=0; i<pieces; i++) {
            price = Math.max(price, prices[i] + cutRod(prices, pieces-(i+1)));
        }

        return price;
    }

    /**
     * This algorithm mantains the previous calculated prices in a list to avoid recalculating.
     */
    public float memorizedCutRod(float[] prices, int pieces) {

        float[] calculatedPrices = new float[prices.length];

        for (int i=0; i<calculatedPrices.length; i++) {
            calculatedPrices[i] = -1;
        }

        return memorizedCutRod(prices, pieces, calculatedPrices);
    }

    private float memorizedCutRod(float[] prices, int pieces, float[] calculatedPrices) {

        if (pieces == 0) {
            return 0;
        }

        if (calculatedPrices[pieces-1]>=0) {
            return calculatedPrices[pieces-1];
        }

        float price = -1;

        for (int i=0; i<pieces; i++) {
            price = Math.max(price, prices[i] + memorizedCutRod(prices, pieces-(i+1), calculatedPrices));
        }

        calculatedPrices[pieces-1] = price;

        return price;
    }
}
