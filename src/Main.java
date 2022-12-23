public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(calc(""));
    }

    public static String calc(String input) throws Exception{
        byte sum = 0;
        String num = "1234567890";
        String roman = "III IV V VII VIII IX X";
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+' -> {
                    if (num.contains(input.substring(0,i))&&num.contains(input.substring(i+1))) {
                        sum += Integer.parseInt(input.substring(0, i));
                        sum += Integer.parseInt(input.substring(i + 1));
                    }else if (roman.contains(input.substring(0,i))&&roman.contains(input.substring(i+1))){
                        sum += roman(input.substring(0, i));
                        sum += roman(input.substring(i+1));
                    }else {
                        throw new CalcException("используются одновременно разные системы счисления");
                    }
                }
                case '-' -> {
                    if (num.contains(input.substring(0,i))&&num.contains(input.substring(i+1))) {
                        sum += Integer.parseInt(input.substring(0, i));
                        sum -= Integer.parseInt(input.substring(i + 1));
                    }else if (roman.contains(input.substring(0,i))&&roman.contains(input.substring(i+1))){
                        sum += roman(input.substring(0, i));
                        sum -= roman(input.substring(i+1));
                        if (sum<1){
                            throw new CalcException("в римской системе нет отрицательных чисел");
                        }

                    }else {
                        throw new CalcException("используются одновременно разные системы счисления");
                    }
                }
                case '*' -> {
                    if (num.contains(input.substring(0,i))&&num.contains(input.substring(i+1))) {
                        sum += Integer.parseInt(input.substring(0, i));
                        sum *= Integer.parseInt(input.substring(i + 1));
                    }else if (roman.contains(input.substring(0,i))&&roman.contains(input.substring(i+1))){
                        sum += roman(input.substring(0, i));
                        sum *= roman(input.substring(i+1));
                        if (sum<1){
                            throw new Exception();
                        }
                    }else {
                        throw new CalcException("используются одновременно разные системы счисления");
                    }
                }
                case '/' -> {
                    if (num.contains(input.substring(0,i))&&num.contains(input.substring(i+1))) {
                        sum += Integer.parseInt(input.substring(0, i));
                        sum /= Integer.parseInt(input.substring(i + 1));
                    }else if (roman.contains(input.substring(0,i))&&roman.contains(input.substring(i+1))){
                        sum += roman(input.substring(0, i));
                        sum /= roman(input.substring(i+1));
                        if (sum<1){
                            throw new Exception();
                        }
                    }else {
                        throw new CalcException("используются одновременно разные системы счисления");
                    }
                }
            }
            if (sum==0){
                throw new CalcException("строка не является математической операцией");
            }

        }
        return String.valueOf(sum);
    }

    static int roman(String a) throws Exception {
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            switch (a.substring(i, i + 1)) {
                case "I" -> {
                    if (i<a.length()-1){
                        if (a.charAt(i+1)=='V'||a.charAt(i+1)=='X'){
                            sum-=1;
                        }else {
                            sum += 1;
                        }
                    }else {
                        sum += 1;
                    }

                }
                case "V" -> {

                    sum += 5;

                }
                case "X" -> {
                    sum += 10;
                }
                default -> {
                        if (sum==0){
                            throw new Exception();
                        }

                }
            }
        }
        return sum;
    }
}