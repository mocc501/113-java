public class Calculator {
    class Opertion{
        public int add(int a, int b){
            return a + b;
        }
        public int subtract(int a, int b){
            return a - b;
        }
        public int multiply(int a, int b){
            return a * b;
        }
        public int divide(int a, int b){
            return a / b;
        }
    }

    public void  performOperation(int a, int b, String operator){
        Opertion op = new Opertion();
        switch(operator){
            case "+" ->System.out.println(op.add(a, b));
            case "-" ->System.out.println(op.subtract(a, b));
            case "*" ->System.out.println(op.multiply(a, b));
            case "/" ->System.out.println(op.divide(a, b));
            default -> System.out.println("Invalid operator");
        }
    }
}
