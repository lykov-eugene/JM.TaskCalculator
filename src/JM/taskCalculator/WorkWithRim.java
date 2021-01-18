package JM.taskCalculator;

// В классе WorkWithRim производится работа с римскими цифрами. В этом классе проводится определение соответсвия
//  условиям задачи и перевод римских цифр в арабские, и после проведения вычислений в классе WorkWithDigit
//  обратный перевод в римские цифры.
// Метод rimToInteger принимает массив символов из условия и передлаёт их последовательно:
//  в метод rimToIntegerAnalysis, в класс WorkWithDigit.
// Метод rimToIntegerAnalysis проверяет римские цифры на соответсвие условиям, правилам написания римских
//  цифр и переводит в арабские цифры.
// Метод integerToRim переводит арабские цифры в римские.

    public class WorkWithRim {

        public static void rimToInteger (String[] str) throws HandleException {

            char[] char1 = str[0].toCharArray();
            char[] char2 = str[2].toCharArray();

            int digit1 = rimToIntegerAnalysis(char1);
            int digit2 = rimToIntegerAnalysis(char2);

            str[0] = String.valueOf(digit1);
            str[2] = String.valueOf(digit2);

            WorkWithDigit.digitAnalysis(str);
        }

        private static int rimToIntegerAnalysis(char[] ch) throws HandleException {
            int digit = 0;

            for (int x = ch.length - 1; x > -1; x--) {
                int y = 0;

                if (ch.length > 3 && x > 2 && ch[x] == ch[x-3]) {
                    throw new HandleException("Неверный формат IIIII, VVVV, XXXX)");
                }

                if (ch[x] == 'I') {   //Это 1?
                    y = 1;
                    if ((x + 2) < ch.length && (ch[x + 2] == 'V' || ch[x + 2] == 'X'))
                        y = -1;
                }

                if (ch[x] == 'V') { //Это 5?
                    y = 5;
                    if (x != 0 && (ch[x - 1] == 'I')) {
                        y = 4;
                        x--;
                    }
                }

                if (ch[x] == 'X') { //Это 10?
                    y = 10;
                    if (x != 0 && ch[x - 1] == 'I') {
                        y = 9;
                        x--;
                    }
                }
                if (y == 0) {
                    throw new HandleException("Неверный формат (не I, V, X)");
                }
                digit = digit + y;
            }
            //System.out.println("Прочтённое число из римских :" + digit);
            return digit;
        }

        public static String integerToRim(int i) {
            StringBuilder result = new StringBuilder();
            if (i < 0) {
                result = new StringBuilder("-");
                i = i * -1;
            }
            if (i == 100) {
                result.append("C");
                i = i - 100;
            }
            if (i > 89) {
                result.append("XC");
                i = i - 90;
            }

            if (i > 49) {
                result.append("L");
                i = i - 50;
            }

            if (i > 9) {
                while (i > 9) {
                    result.append("X");
                    i = i - 10;
                }
            }
            if (i > 4) {
                result.append("V");
                i = i - 5;

            }
            if (i == 4) {
                result.append("IV");
                i = i - 4;
            }
            if (i > 0) {
                while (i > 0) {
                    result.append("I");
                    i = i - 1;
                }
            }

            return result.toString();
        }
}

