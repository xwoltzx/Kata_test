import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String str = calc(string);
        System.out.print(str);
        in.close();
    }
    public static String calc(String input) {
        String[] numbers = input.split(" ");
        if (numbers.length != 3) {
            throw new NullPointerException("Слишком много символов");
        }
        if (!numbers[1].equals("+") && !numbers[1].equals("-")
            && !numbers[1].equals("*") && !numbers[1].equals("/")) {
            throw new NullPointerException("Неизвестная операция");
        }
        int firstOperand = 0, secondOperand = 0;
        int firstRomanOperand = 0, secondRomanOperand = 0;
        int result = 0;
        if (numbers[0].equals("1")) {
            firstOperand = 1;
        } else if (numbers[0].equals("2")) {
            firstOperand = 2;
        } else if (numbers[0].equals("3")) {
            firstOperand = 3;
        } else if (numbers[0].equals("4")) {
            firstOperand = 4;
        } else if (numbers[0].equals("5")) {
            firstOperand = 5;
        } else if (numbers[0].equals("6")) {
            firstOperand = 6;
        } else if (numbers[0].equals("7")) {
            firstOperand = 7;
        } else if (numbers[0].equals("8")) {
            firstOperand = 8;
        } else if (numbers[0].equals("9")) {
            firstOperand = 9;
        } else if (numbers[0].equals("10")) {
            firstOperand = 10;
        } else if (numbers[0].equals("I")) {
            firstOperand = 1;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("II")) {
            firstOperand = 2;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("III")) {
            firstOperand = 3;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("IV")) {
            firstOperand = 4;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("V")) {
            firstOperand = 5;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("VI")) {
            firstOperand = 6;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("VII")) {
            firstOperand = 7;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("VIII")) {
            firstOperand = 8;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("IX")) {
            firstOperand = 9;
            firstRomanOperand = 1;
        } else if (numbers[0].equals("X")) {
            firstOperand = 10;
            firstRomanOperand = 1;
        } else {
            throw new NullPointerException("Первый операнд не является числом");
        }

        if (numbers[2].equals("1")) {
            secondOperand = 1;
        } else if (numbers[2].equals("2")) {
            secondOperand = 2;
        } else if (numbers[2].equals("3")) {
            secondOperand = 3;
        } else if (numbers[2].equals("4")) {
            secondOperand = 4;
        } else if (numbers[2].equals("5")) {
            secondOperand = 5;
        } else if (numbers[2].equals("6")) {
            secondOperand = 6;
        } else if (numbers[2].equals("7")) {
            secondOperand = 7;
        } else if (numbers[2].equals("8")) {
            secondOperand = 8;
        } else if (numbers[2].equals("9")) {
            secondOperand = 9;
        } else if (numbers[2].equals("10")) {
            secondOperand = 10;
        } else if (numbers[2].equals("I")) {
            secondOperand = 1;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("II")) {
            secondOperand = 2;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("III")) {
            secondOperand = 3;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("IV")) {
            secondOperand = 4;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("V")) {
            secondOperand = 5;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("VI")) {
            secondOperand = 6;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("VII")) {
            secondOperand = 7;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("VIII")) {
            secondOperand = 8;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("IX")) {
            secondOperand = 9;
            secondRomanOperand = 1;
        } else if (numbers[2].equals("X")) {
            secondOperand = 10;
            secondRomanOperand = 1;
        } else {
            throw new NullPointerException(
                "Второй операнд не является оператором");
        }
        if (firstRomanOperand != secondRomanOperand) {
            throw new NullPointerException("Операнды не совместимы");
        }
        if (numbers[1].equals("+")) {
            result = firstOperand + secondOperand;
        }
        if (numbers[1].equals("-")) {
            result = firstOperand - secondOperand;
        }
        if (numbers[1].equals("*")) {
            result = firstOperand * secondOperand;
        }
        if (numbers[1].equals("/")) {
            result = firstOperand / secondOperand;
        }
        if (firstRomanOperand == 0) {
            String firstString = "" + result;
            return firstString;
        }
        if (firstRomanOperand == 1) {
            if (result < 1) {
                throw new NullPointerException("Result mus be more than 1");
            }
            String secondString = arabicToRoman(result);
            return secondString;
        }
        return "";
    }
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(
                number + " не в пределах (0,4000]");
        }

        List<RomanNumeral> romanNumerals =
            RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
    enum RomanNumeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value)
                            .reversed())
                .collect(Collectors.toList());
        }
    }
}