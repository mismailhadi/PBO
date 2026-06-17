package Ewallet;

public abstract class Payment {
    protected String methodName;

    public Payment(String methodName){
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public abstract double calculateFee(double amount);
    public abstract boolean validate(double amount);
}