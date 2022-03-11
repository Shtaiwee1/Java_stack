

public class CalculatorTest {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.setNum1(2.5);
        calculator.setNum2(3.5);
        calculator.setOperation("-");
        calculator.performOperation();
        calculator.getResult();
        
        


    } 
}
