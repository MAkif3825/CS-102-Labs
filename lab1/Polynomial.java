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
    public Polynomial(int power, double coefficient){
        this(power + 1);

        for ( int i = 0; i < power; i++)
        {
            this.coefficients[i] = 0;
            this.powers[i] = i;
        }

        this.coefficients[power] = coefficient;
        this.powers[power] = power;
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
     * This method takes the degree and returns the coefficient of the term with that degree.
     * @param degree an integer
     * @return the coefficient of the term with that degree
     */
    public double getCoefficient(int degree)
    {
        int indexOfDegree = 0;
        double coefficient = 0;
        boolean isFound = false;

        for ( int i = 0; i < this.powers.length && !isFound; i++ )
        {
            if ( this.powers[i] == degree )
            {
                indexOfDegree = i;
                isFound = true;
            } 
        }
        if ( isFound )
        {
            coefficient = coefficients[indexOfDegree];
        }

        return coefficient;
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
        boolean isStarted = false;

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
                        if ( i != 0 && isStarted)
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

                    if (!element.equals(""))
                    {
                        isStarted = true;
                    }
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
    public double eval2(double x){
        double result = 0;


        //Visits all the coefficients one by one from the biggest power.
        for ( int i = this.coefficients.length - 1; i >= 0; i--)
        {
            result = (result * x) + coefficients[i];
        }

        //There might be some problems from time to time. Ask to TA.
        result = result * Math.pow(10, 10);
        result = Math.floor(result);
        result = result / Math.pow(10, 10);
        
        return result;
    }

    public Polynomial add(Polynomial p2){
        Polynomial result;
        Polynomial bigger;
        Polynomial smaller;
        double[] resultCoefficients;

        if ( this.getDegree() <= p2.getDegree() )
        {
            bigger = this;
            smaller = p2;
        }
        else
        {
            bigger = p2;
            smaller = this;
        }

        resultCoefficients = new double[bigger.getDegree()];

        int i = 0;
        while ( i < smaller.getDegree() )
        {
            resultCoefficients[i] = smaller.getCoefficient(i) + bigger.getCoefficient(i);
            i++;
        }
        while ( i < bigger.getDegree() )
        {
            resultCoefficients[i] = bigger.getCoefficient(i);
        }

        result = new Polynomial(resultCoefficients);
        

        return result;
    }

    public Polynomial sub(Polynomial p2){
        Polynomial result;
        Polynomial minusPol;
        double[] minusPolCo = new double[p2.getDegree()] ;

        for ( int i = 0; i < minusPolCo.length; i++)
        {
            minusPolCo[i] = p2.getCoefficient(i) * -1;
        }

        minusPol = new Polynomial(minusPolCo);

        result = this.add(minusPol);

        return result;
    }

    public Polynomial mul(Polynomial p2){
        Polynomial result = new Polynomial();

        return result;
    }

    public Polynomial compose(Polynomial p2){
        Polynomial result = new Polynomial();

        return result;
    }

    public Polynomial div(Polynomial p2){
        Polynomial result = new Polynomial();

        return result;
    }

    public Polynomial findEqual(Polynomial p2){
        Polynomial result = new Polynomial();

        return result;
    }
}
