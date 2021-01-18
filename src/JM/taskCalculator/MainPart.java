package JM.taskCalculator;

// Класс MainPart является основным классом, в нём содерждится метод main (поток ввода символов, логика управления
// включением классов и методов в засисимости от введённых значений)
// Метод StringDelimiter производит разделение строки на подстроки и заполняет массив символов item,
// определяет чтобы подстрок было не более трёх.
// Метод checkString проверяет арабские цифры или другие символы были введены.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPart {

    private static String[] item;
    public static int result;

    public static void main (String[] args) throws IOException, NumberFormatException, HandleException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringDelimiter(br.readLine());

        br.close();

        boolean mainRelay = checkString(item[0]);

        if (mainRelay == true) {
            WorkWithDigit.digitAnalysis(item);
            System.out.println(result);
        }

        if (mainRelay == false) {
            WorkWithRim.rimToInteger(item);
            System.out.println(WorkWithRim.integerToRim(result));
        }
    }
    public static void StringDelimiter(String d) {
        String delimiter = " ";
        item = d.split(delimiter);
        if (item.length != 3) {
            try {
                throw new HandleException();
            } catch (HandleException e) {
                e.printStackTrace();
                System.err.println("Ошибка ввода: > или < 3");
            }

        }
    }
    public static boolean checkString(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
