import java.util.Arrays;
import java.util.stream.IntStream;

public class First {
    public static void main(String[] args) {
        System.out.println("1 задание: " + repeat("mice", 5)); // 1
        System.out.println("2 задание: " + differenceMaxMin(new int[] {2, 8, -2, 7, 9, 15})); // 2
        System.out.println("3 задание: " + isAvgWhole(new int[] {1, 2, 3})); // 3
        System.out.println("4 задание: " + Arrays.toString(cumulativeSum(new int[]{1, 2, 3}))); // 4 ??????
        System.out.println("5 задание: " + getDecimalPlaces("3.1")); // 5
        System.out.println("6 задание: " + Fibonacci(12)); // 6
        System.out.println("7 задание: " + isValid("555 5"));
        System.out.println("8 задание: " + isStrangePair("bush", "hubris")); // 8
        System.out.println("9 задание prefix: " + isPrefix("automation", "auto-"));
        System.out.println("9 задание suffix: " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("10 задание при n = 5: " + boxSeq(5));
        System.out.println("10 задание при n = 6: " + boxSeq(6));

    }
    public static StringBuilder repeat(String word, int n) {
        StringBuilder repeat = new StringBuilder(); // создание пустой строки
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j <= n; j++) {
                repeat.append(word.charAt(i)); // добавление символа n раз в строку
            }
        }
        return repeat;
    }
    public static int differenceMaxMin(int[] list)
    {
        Arrays.sort(list); // сортировка массива
        return list[list.length -1] - list[0]; // max - min
    }
    public static boolean isAvgWhole(int[] list) {
        double summa = IntStream.of(list).sum(); // Нахождение суммы массива
        double res = summa / list.length; // среднее знач.
        return Math.round(res) == res; // округление до целого и сравнение
    }
    public static int[] cumulativeSum(int[] list) {
        int[] answer = new int[list.length];
        int summa = list[0]; // сумма изначально равна 1ому элементу
        answer[0] = list[0]; // перед 1ым элементом нет других
        for (int i = 1; i < list.length; i++) {
            answer[i] = list[i] + summa; // запись в новый массив
            summa += list[i]; // увеличени суммы
        }
        return answer;
    }
    public static int getDecimalPlaces(String line) {
        int val = line.indexOf("."); // индекс точки в строке
        if (val != -1) {
            return line.length() - 1 - line.indexOf("."); // кол-во символов после точки
        }
        else {
            return 0; // если число целое
        }
    }
    public static int Fibonacci(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1; // первый элемент
        arr[1] = 1; // второй элемент
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2]; // получение последующих элементов
        }
        return arr[arr.length-1]; // вывод последнего элемента массива
        }

    public static boolean isValid(String index) {
        boolean flag1 = true; // флаг наличия цифр
        boolean flag2 = true; // флаг наличия пробелов
        for (int i = 0; i < index.length(); i++) {
            int askii_char = index.charAt(i); // получение askii кода
            if (askii_char < 47 | askii_char > 57) { // символ это буква или что-то ещё?
                flag1 = false;
            }
            if (askii_char ==  32) { // символ это пробел ??
                flag2 = false;
            }
        }
        return flag1 & flag2 & index.length() <= 5;
    }
    public static boolean isStrangePair(String s1, String s2) {
        return s1.charAt(0) == s2.charAt(s2.length()-1) & s2.charAt(0) == s1.charAt(s1.length()-1);
    }
    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.substring(0, prefix.length()-1); // убираем -
        return word.startsWith(prefix);
    }
    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.substring(1); // убираем -
        return word.endsWith(suffix);
    }

    public static int boxSeq(int n) {
        if (n == 0) {
            return 0; // изначально их 0
        }
        else {
            int k = 0;
            int flag = 0; // показывает: +3 или -1
            for (int i = 0; i < n; i++) {
                if (flag % 2 == 0) {
                    k += 3;
                }
                else {
                    k -= 1;
                }
                flag += 1;
            }
            return k; // возвращает кол-во полей
        }
    }
}


