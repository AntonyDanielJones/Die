import java.util.Random;

/**
 * A class for simulating the behaviours of a die. An instance of a die can be
 * created with a specified number of sides, n. The die can then be 'rolled' to
 * produce a (pseudo) random number from 1 to n (inclusive).
 * 
 * 02/07/2018
 * @version 1.0
 * @author Daniel Jones
 */
public class Die {
    private Random numberGenerator;
    private int numberOfSides;
    private int currentValue;
    
    /**
     * Create a new instance of a die with a specified number of sides.  
     * 
     * @param n the number of sides on the die
     */
    public Die(int n) {
        numberGenerator = new Random();
        // must be above 0
        if (n < 1) 
            n = 1;
        numberOfSides = n;
        rollDie(); // throw the die to randomly set the initial value
    }
    
    /**
     * Method to roll the die and produce a number.
     * 
     * @return the value of the die after the roll.
     */
    public int rollDie() {
        currentValue = numberGenerator.nextInt(numberOfSides) + 1;
        return currentValue;
    }
    
//    /**
//     * Method for setting the current value of the die. Used for testing 
//     * purposes.
//     * 
//     * @param v the value to set the die to.
//     */
//    public void setValue(int v) {
//        // only allow values between 1 and n (inclusive)
//        if (v > numberOfSides)
//            v = numberOfSides;
//        else if (v < 1)
//            v = 1;
//        
//        currentValue = v;
//    }
    
    /**
     * @return the current value of the die.
     */
    public int getValue() {
        return currentValue;
    }
    
    /**
     * @return the number of sides on this die.
     */
    public int getNoSides() {
        return numberOfSides;
    }
}
