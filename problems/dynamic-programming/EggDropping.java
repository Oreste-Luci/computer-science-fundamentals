import java.io.Console;

/**
 * Two Egg Problem
 * @author Oreste Luci
 */
public class EggDropping {

    public static void main(String args[]){

        EggDropping ed = new EggDropping();

        Console console = System.console();

        System.out.println("Enter the number of floors:");
        int floors = Integer.parseInt(console.readLine());

        System.out.println("Enter the number of eggs:");
        int eggs = Integer.parseInt(console.readLine());

        int result = ed.calculateMinimumTriesI(eggs,floors);
        System.out.println("(I) The minimun tries are: " + result);

        /*
        result = ed.calculateMinimumTriesR(eggs,floors);
        System.out.println("(R) The minimun tries are: " + result);
        */
    }

    /**
     * Recursive solution is very inneficient
     */
    public int calculateMinimumTriesR(int eggs, int floors){

        if(eggs == 1){
            return floors;
        }

        if(floors == 0){
            return 0;
        }

        int min = floors + 1;

        for(int i=1; i <= floors; i++){

            int val = 1 + Math.max(calculateMinimumTriesR(eggs-1, i-1),calculateMinimumTriesR(eggs, floors-i));
            //int val = 1 + Math.max(i-1, calculateMinimumTries(eggs, floors-i));

            if(val < min){
                min = val;
            }
        }

        return min;
    }

    public int calculateMinimumTriesI(int eggs, int floors){

        int T[][] = new int[eggs+1][floors+1];
        int c =0;
        for(int i=0; i <= floors; i++){
            T[1][i] = i;
        }

        for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
                T[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }
}
