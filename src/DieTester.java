import java.util.Arrays;
import java.util.LinkedList;

/**
 * Tester class for Die class.
 * 
 * 02/07/2018
 * @version 1.0
 * @author Daniel Jones
 */
public class DieTester {

    public static void main(String[] args) {
        int noSides = 6;
        int noTrials = 10000000;
        boolean defaultSettings = false;
        
        // if arguements are valid, use them
        try {
            noSides = Integer.parseInt(args[0]);
            noTrials = Integer.parseInt(args[1]);
        } catch (Exception e) {
            defaultSettings = true;
        }
        
        // usage message
        if (args.length != 2 || defaultSettings) {
            System.out.println("Usage: DieTester NUMBER_OF_SIDES " + 
                    "NUMBER_OF_TRIALS");
            System.out.println("Using default settings (" + noSides +
                    " sides, " + noTrials + " trials).\n");
        }
        
        Die die = new Die(noSides);
        noSides = die.getNoSides(); // update, in case die class has changed the value
        int[] distribution = new int[noSides];
        for (int i = 0; i < noSides; i++) // initialise to 0s
            distribution[i] = 0;
        
        double minRoll = Double.POSITIVE_INFINITY;
        double maxRoll = Double.NEGATIVE_INFINITY;
        int sumOfRolls = 0;
        
        // perform rolls
        for (int i = 0; i < noTrials; i++) {
            int value = die.rollDie();
            sumOfRolls += value;
            distribution[value - 1]++;
            
            if (value < minRoll)
                minRoll = value;
            if (value > maxRoll)
                maxRoll = value;
        }
        
        // calculate stats
        double percentages[] = new double[noSides];
        for (int i = 0; i < noSides; i++) {
            percentages[i] = (double) distribution[i] / noTrials * 100;
        }
        double averageRoll = (double) sumOfRolls / noTrials;
        LinkedList<Integer> mostCommon = new LinkedList<Integer>();
        mostCommon.add(1);
        LinkedList<Integer> leastCommon = new LinkedList<Integer>();
        leastCommon.add(1);
        for (int i = 1; i < noSides; i++) {
            if (distribution[i] > distribution[mostCommon.get(0) - 1]) {
                mostCommon.clear();
                mostCommon.add(i + 1);
            } else if (distribution[i] == distribution[mostCommon.get(0) - 1]) {
                mostCommon.add(i + 1);
            } else if (distribution[i] < distribution[leastCommon.get(0) - 1]) {
                leastCommon.clear();
                leastCommon.add(i + 1);
            } else if (distribution[i] == distribution[leastCommon.get(0) - 1]) {
                leastCommon.add(i + 1);
            }
        }
        
        // print results
        System.out.println("A " + noSides + "-sided die was rolled "
                + noTrials + " times. Here are the results.\n");
        System.out.println("DISTRIBUTION:\t" + Arrays.toString(distribution));
        System.out.print(" --> (%):\t[");
        for (int i = 0; i < noSides; i++)
            System.out.printf("%.2f, ", percentages[i]);
        System.out.print("]\n");
        System.out.println("MIN ROLL:\t" + minRoll);
        System.out.println("MAX ROLL:\t" + maxRoll);
        System.out.println("AVERAGE ROLL:\t" + averageRoll);
        System.out.print("MOST COMMON ROLL(S):\t");
        for (int i = 0; i < mostCommon.size(); i++) {
            System.out.print(mostCommon.get(i) + ", ");
        }
        System.out.print("\t(rolled " + distribution[mostCommon.get(0) - 1] + 
                " times)\n");
        System.out.print("LEAST COMMON ROLL(S):\t");
        for (int i = 0; i < leastCommon.size(); i++) {
            System.out.print(leastCommon.get(i) + ", ");
        }
        System.out.print("\t(rolled " + distribution[leastCommon.get(0) - 1] + 
                " times)\n");
    }
}
