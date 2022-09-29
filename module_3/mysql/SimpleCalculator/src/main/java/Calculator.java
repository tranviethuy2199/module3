public class Calculator {
    public static double calculate (double firstOperand , double secondOperand , String operand) {
        switch (operand) {
            case "cong" :
                return firstOperand + secondOperand;
            case "tru" :
                return firstOperand - secondOperand;
            case "nhan" :
                return firstOperand * secondOperand;
            case "chia" :
                if (secondOperand !=0 )
                    return firstOperand/secondOperand;
                else throw new NumberFormatException("nhập sai số");
            default:
                throw new RuntimeException("Có sai sót");
        }
    }
}
