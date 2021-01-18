package JM.taskCalculator;

// Класс WorkWithDigit состоит из одного метода digitAnalysis. В нём производится проверка на
// соответсвие условиям задачи, передача символа математического действия в метод WorkWithSymbol.SymbolAnalysis,
// математическое действие и получение результата вычислений.

public class WorkWithDigit {

    public static void digitAnalysis(String[] str) throws HandleException {

        if (Integer.parseInt(str[0]) > 0 && Integer.parseInt(str[0]) < 11 &&
                Integer.parseInt(str[2]) > 0 && Integer.parseInt(str[2]) < 11 &&
                WorkWithSymbol.SymbolAnalysis(str))   {

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);

            switch (str[1]) {
                case "+":
                    MainPart.result = (a + b);
                    break;
                case "-":
                    MainPart.result = (a - b);
                    break;
                case "*":
                    MainPart.result = (a * b);
                    break;
                case "/":
                    MainPart.result = (a / b);
                    break;
            }

        } else throw new HandleException("Числа больше 10 или меньше 1");
    }
}
