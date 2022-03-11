public class Calculator {
    private double num1;
    private double num2;
    private String operation;
    private double result;

    //constructor

    public Calculator() {
    }


    //setters and getters

    public double getNum1() {
        return this.num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return this.num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void getResult() {
        System.out.println("num1 is :" + getNum1() );
        System.out.println("num2 is :" + getNum2() );
        System.out.println("The operation is :" + getOperation() );
        System.out.println("The result is :" + this.result );
        
    }

    

    //methods
    public double performOperation(){
        if(this.operation.equals("+")){
            this.result = num1 + num2 ;
        }else if(this.operation.equals("-")){
            this.result = num1 - num2 ;
        }
        return this.result;
    }
}


//when you override you make a new method with the same name that overrides the parent class// this needs confirmation from the video
//when you ovverload you use two methods that has the same name but with different parameters in the same child class.