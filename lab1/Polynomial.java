package lab1;

/**
 * This object aims to store a polynoial expression as an object.
 * 
 * @author Mehmet Akif Yavuz
 * Last update: 15.02.2024
 */
public class Polynomial{
    //Declaration of necessary variables
    private double[] coefficients;
    private int[] powers;

    /**
     * Generates an initial array for each object.
     * @param size The number of elements in the polynomial.
     */
    private Polynomial(int size){
        this.coefficients = new double[size];
        this.powers = new int[size];
    }

    /**
     * Constructs the object with 1 element.
     * @param coefficient The coefficient of the element
     * @param power The power of the element
     */
    public Polynomial(double coefficient, int power){
        this(1);

        this.coefficients[0] = coefficient;
        this.powers[0] = power;
    }
    
    /**
     * Constructs the zero polynomial.
     */
    public Polynomial(){
        this(1);

        this.coefficients[0] = 0;
        this.powers[0] = 0;
    }

    /**
     * Constructs the polynomial with the size of the given coefficients
     * @param coefficients a array of doubles represents the coefficients. 
     */
    public Polynomial(double[] coefficients){
        this( coefficients.length);

        for ( int i = 0; i < coefficients.length; i++ )
        {
            this.coefficients[i] = coefficients[i];
            this.powers[i] = i; 
        } 
    }

    /**
     * This method finds the degree of the highest non-zero term in a polynomial
     * @return the polynomial degree
     */
    public int getDegree (){
        int biggest = powers[0];

        //Compares all degrees with the first one
        for ( int i = 1; i < this.powers.length; i++ )
        {
            if ( biggest < powers[i] && this.coefficients[i] != 0)
            {
                biggest = powers[i];
            }
        }
        return biggest;
    }

    /**
     * This method makes the toString method more client friendly.
     * @return the appropriate form of the polynomial
     */
    @Override
    public String toString (){
        String result = "";
        String element = "";
        boolean isPseudoZero = true;

        //Handles the zero polynomial
        if ( this.coefficients.length == 1 && this.coefficients[0] == 0)
        {
            result = result + "0";
        }
        else
        {
            //Visits every element and composes it
            for ( int i = 0; i < this.coefficients.length; i ++)
            {
                double number = this.coefficients[i];
                int power = this.powers[i];

                //Processes only non-zero elements
                if ( number != 0 )
                {
                    isPseudoZero = false;
                    //Put sign at the beginning and also handles the first element
                    if ( number < 0 && i != 0)
                    {
                        element = element + " - ";
                        number = number * -1;
                    }
                    else{
                        //Handles the first element
                        if ( i != 0)
                        {
                            element = element + " + ";
                        }
                    }

                    element = element + number;

                    //Add the power
                    if ( power != 0 )
                    {
                        element = element + "x^"+ power;
                    }

                    result = result + element;

                    element = "";
                }
            }

            //If the all coefficients are equals to 0, returns 0
            if ( isPseudoZero )
            {
                result = "0";
            }
        }

        return result;
    }

    /**
     * This method evaluates the polynomial at x.
     * @param x a double for evaluation
     * @return the result as double
     */
    public double eval(double x){
        double result = 0;
        double element = 0;

        //Visits all elements one by one and add the partial results to main one
        for ( int i = 0; i < this.coefficients.length; i++)
        {   
            element = Math.pow(x, this.powers[i]) * this.coefficients[i];
            result = result + element; 
        }

        return result;
    }

    /**
     * This method evaluates the polynomial at x by using Horner's method.
     * @param x a double for evaluation
     * @return the result as double
     */
    public double elval2(double x){
        double result = 0;

        //Visits all the coefficients one by one from the biggest power.
        for ( int i = this.coefficients.length; i > 0; i--)
        {
            result = result + ((coefficients[i] * x) + coefficients[i - 1]);
        }

        result = result + coefficients[0];

        return result;
    }
}

class PolynomialTester{
    public static void main(String[] args){
        double[] array1 = {-12.3, 5, 25.4, 0};
        double[] array2 = {3, -5, 2};

        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial(5, 3);
        Polynomial pol3 = new Polynomial(array1);
        Polynomial pol4 = new Polynomial(array2);

        int deg1 = pol1.getDegree();
        int deg2 = pol2.getDegree();
        int deg3 = pol3.getDegree();
        int deg4 = pol4.getDegree();

        double evaluation_1_1 = pol1.eval(5);
        double evaluation_1_2 = pol2.eval(-3);
        double evaluation_1_3 = pol3.eval(7.4);
        double evaluation_1_4 = pol4.eval(10);

        double evaluation_2_1 = pol1.eval(5);
        double evaluation_2_2 = pol2.eval(-3);
        double evaluation_2_3 = pol3.eval(7.4);
        double evaluation_2_4 = pol4.eval(10);
        
        System.out.println("The given polynomial is: " + pol1 + " \nWith the degree of " + deg1 + "\n");
        System.out.println("The given polynomial is: " + pol2 + " \nWith the degree of " + deg2 + "\n");
        System.out.println("The given polynomial is: " + pol3 + " \nWith the degree of " + deg3 + "\n");
        System.out.println("The given polynomial is: " + pol4 + " \nWith the degree of " + deg4 + "\n\n");

        System.out.println("The result of evaluation 1: " + evaluation_1_1 + "\n" + 
                           "The result of evaluation 2: " + evaluation_2_1 + "\n" +
                           "Are they same: " + (evaluation_1_1 == evaluation_2_1) + "\n\n");

        System.out.println("The result of evaluation 1: " + evaluation_1_2 + "\n" + 
                           "The result of evaluation 2: " + evaluation_2_2 + "\n" +
                           "Are they same: " + (evaluation_1_2 == evaluation_2_2) + "\n\n");

        System.out.println("The result of evaluation 1: " + evaluation_1_3 + "\n" + 
                           "The result of evaluation 2: " + evaluation_2_3 + "\n" +
                           "Are they same: " + (evaluation_1_3 == evaluation_2_3) + "\n\n");

        System.out.println("The result of evaluation 1: " + evaluation_1_4 + "\n" + 
                           "The result of evaluation 2: " + evaluation_2_4 + "\n" +
                           "Are they same: " + (evaluation_1_4 == evaluation_2_4) + "\n\n");
    }
}