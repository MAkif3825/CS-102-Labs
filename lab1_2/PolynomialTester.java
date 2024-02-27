package lab1_2;

import java.util.Arrays;

public class PolynomialTester {
    public static void main(String[] args){
        //Initialize coefficients for polynomials
        double[] array1 = {3, 4, 5, 2};
        double[] array2 = {2, 4, 1};
        double[] array3 = {3, 4, 1};
        double[] array4 = {2, 1};
        double[] array5 = {3, 4, 1, 3, 0, 2};
        double[] array6 = {0, 1, 0, 0, 1};
        double[] array7 = {16, 1};

        //Initialize polynomials
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial(3, 5);
        Polynomial pol3 = new Polynomial(array1);
        Polynomial pol4 = new Polynomial(array2);
        Polynomial pol5 = new Polynomial(array3);
        Polynomial pol6 = new Polynomial(array4);
        Polynomial pol7 = new Polynomial(array5);
        Polynomial pol8 = new Polynomial(array6);
        Polynomial pol9 = new Polynomial(array7);

        //Looks degrees
        int deg1 = pol1.getDegree();
        int deg2 = pol2.getDegree();
        int deg3 = pol3.getDegree();
        int deg4 = pol4.getDegree();
        int deg5 = pol5.getDegree();
        int deg6 = pol6.getDegree();
        int deg7 = pol7.getDegree();

        /*
        //Uses eval function
        double evaluation_1_1 = pol1.eval(5);
        double evaluation_1_2 = pol2.eval(-3);
        double evaluation_1_3 = pol3.eval(7.4);
        double evaluation_1_4 = pol4.eval(10);

        //Uses eval2 function
        double evaluation_2_1 = pol1.eval2(5);
        double evaluation_2_2 = pol2.eval2(-3);
        double evaluation_2_3 = pol3.eval2(7.4);
        double evaluation_2_4 = pol4.eval2(10);
        */
        
        //Prints the results and compares them
        System.out.println("The given polynomial is: " + pol1 + " \nWith the degree of " + deg1 + "\n");
        System.out.println("The given polynomial is: " + pol2 + " \nWith the degree of " + deg2 + "\n");
        System.out.println("The given polynomial is: " + pol3 + " \nWith the degree of " + deg3 + "\n");
        System.out.println("The given polynomial is: " + pol4 + " \nWith the degree of " + deg4 + "\n");
        System.out.println("The given polynomial is: " + pol5 + " \nWith the degree of " + deg5 + "\n");
        System.out.println("The given polynomial is: " + pol6 + " \nWith the degree of " + deg6 + "\n");
        System.out.println("The given polynomial is: " + pol7 + " \nWith the degree of " + deg7 + "\n\n");

        /*
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
        

        /*
        for ( int i = 0; i < 2; i++)
        {
            System.out.println("The " + i + ". coefficient of pol 1: " + pol1.getCoefficient(i));
        }

        System.out.println("");
        
        for ( int i = 0; i < 4; i++)
        {
            System.out.println("The " + i + ". coefficient of pol 2: " + pol2.getCoefficient(i));
        }
    
        System.out.println("");

        for ( int i = 0; i < 5; i++)
        {
            System.out.println("The " + i + ". coefficient of pol 3: " + pol3.getCoefficient(i));
        }

        System.out.println("");
    
        for ( int i = 0; i < 8; i++)
        {
            System.out.println("The " + i + ". coefficient of pol 4: " + pol4.getCoefficient(i));
        } */

        System.out.println("P(x) + Q(x) = " + pol3.add(pol4));
        System.out.println("P(x) - Q(x) = " + pol3.sub(pol4));
        System.out.println("P(x) * Q(x) = " + pol3.mul(pol4));

        System.out.println("P(Q(x)) = " + pol5.compose(pol6));
        
        System.out.println("P(x) / Q(x) = " + pol7.div(pol6));


        int[] result = pol8.findEqual(pol9);
        System.out.println("Solve for P(X)=Q(x): " + Arrays.toString(result));
    }
}
