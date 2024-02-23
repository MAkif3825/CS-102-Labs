package lab1;

public class PolynomialTester {
    public static void main(String[] args){
        //Initialize coefficients for polynomials
        double[] array1 = {-12.3, 5, 25.4, 0};
        double[] array2 = {0, 3, 0, -5, 2};

        //Initialize polynomials
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial(3, 5);
        Polynomial pol3 = new Polynomial(array1);
        Polynomial pol4 = new Polynomial(array2);

        //Looks degrees
        int deg1 = pol1.getDegree();
        int deg2 = pol2.getDegree();
        int deg3 = pol3.getDegree();
        int deg4 = pol4.getDegree();

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
        
        //Prints the results and compares them
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
        }
    }
}
