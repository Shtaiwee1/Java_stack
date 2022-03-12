public class CalculatorTest {
    public static void main(String[] args) {
        CalculatorSecond Multiplication = new CalculatorSecond();
        CalculatorSecond Division = new CalculatorSecond();
        CalculatorSecond Addition = new CalculatorSecond();
        CalculatorSecond Substraction = new CalculatorSecond();

        Multiplication.setFirstNumber(5);
        Multiplication.setSecondNumber(2);
        Multiplication.setOperation("*");
        Multiplication.performOperation();
        Multiplication.getResults();
        // System.out.println("The result is : " + Multiplication.getResults());

        Division.setFirstNumber(5);
        Division.setSecondNumber(2);
        Division.setOperation("/");
        Division.performOperation();
        Division.getResults();
        // System.out.println("The result is : " + Division.getResults());

        Addition.setFirstNumber(5);
        Addition.setSecondNumber(2);
        Addition.setOperation("+");
        Addition.performOperation();
        Addition.getResults();
        // System.out.println("The result is : " + Addition.getResults());

        Substraction.setFirstNumber(5);
        Substraction.setSecondNumber(2);
        Substraction.setOperation("-");
        Substraction.performOperation();
        Substraction.getResults();
        // System.out.println("The result is : " + Substraction.getResults());

    }
    
}
