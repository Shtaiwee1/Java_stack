
public class CalculatorSecond implements Processess{
    private double firstNumber;
    private double SecondNumber;
    private String operation;
    private double result;
    private static String[] math = {"+", "-", "*", "/"};


    //constructor
    public CalculatorSecond() {
    }

    //setters and getters
    public double getFirstNumber() {
        return this.firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return this.SecondNumber;
    }

    public void setSecondNumber(double SecondNumber) {
        this.SecondNumber = SecondNumber;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        if (operation.length() > 1) {
            System.out.println("Please use simple math (one operation at a time), I'm not that smart.");
            return;
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (math[i] == operation) {
                    this.operation = operation;
                }
            }
        }
    }

    public double getResult() {
        return this.result;
    }

    //Overriding interface methods

    @Override
    public void performOperation() {
        if(this.operation.equals("+")){
            this.result = getFirstNumber() + getSecondNumber();
        }else if(this.operation.equals("-")){
            this.result = getFirstNumber() - getSecondNumber();
        }else if(this.operation.equals("/")){
            this.result = getFirstNumber() / getSecondNumber();
        }else if(this.operation.equals("*")){
            this.result = getFirstNumber() * getSecondNumber();
        }
        
    }

    @Override
    public double getResults() {
        System.out.println("The result is: " + getResult());
        
        return this.result;
    }

    //methods
    
    
}