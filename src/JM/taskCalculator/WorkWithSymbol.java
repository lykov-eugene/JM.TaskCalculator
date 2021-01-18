package JM.taskCalculator;

// Класс WorkWithSymbol содержит единственный класс SymbolAnalysis, который определяет валидность введённого символа.

public class WorkWithSymbol {

    public static boolean SymbolAnalysis(String[] str) throws HandleException {
        if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
            return true;
        } else throw new HandleException("Неверный символ математического действия");
    }
}
