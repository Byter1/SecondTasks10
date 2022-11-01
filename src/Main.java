import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,3,4};

        System.out.println(repeat("hello", 5)); // 1
        System.out.println(differenceMaxMix( nums )); // 2
        System.out.println(isAvgWhole(nums)); // 3
        System.out.println( Arrays.toString(cumulativeSum(nums)) ); // 4
        System.out.println( getDecimalPlaces("400") ); // 5
        System.out.println(Fibonacci(3)); // 6
        System.out.println(isValid("333 ")); // 7
        System.out.println(isStrangePair("ratio", "orator")); // 8
        System.out.println(isPrefix("kolya", "ko-")); // 9
        System.out.println(isSuffix("kokoko", "-ko")); // 9
        System.out.println(boxSeq(2)); // 10
    }

    public static String[] remove(String[] values, int index) {
        // Создаем пустой массив размером на один меньше чем исходный
        // так как мы удаляем один элемент
        var result = new String[values.length - 1];

        for (var i = 0; i < values.length; i++) {
            if (i != index) { // Копируем все кроме index
                // Элементы стоящие дальше index смещаются влево
                var newIndex = i < index ? i : i - 1;
                result[newIndex] = values[i];
            }
        }

        return result;
    }

    public static String repeat(String str, int count) {
        String resultString = ""; // пустая результирующая строка
        String[] literals = str.split(""); // разбиваем строку по символам
        for (int i = 0; i < str.length(); i++)  { // цикл перебирает символы в исходной строке
         for (int j = 0; j < count; j++) {  // вложенный цикл добавляет в результирующую строку нужное количество символов count
             resultString += literals[i];
         }
        }
        return resultString;
    }

    public static int differenceMaxMix (int[] nums) {
        Arrays.sort(nums); // сортируем массив
        return (nums[nums.length-1] - nums[0]); // вычисляем разность между наибольшим и наименьшим элементами
    }

    public static boolean isAvgWhole (int[] nums) {
        double avg = 0;
        for (int i = 0; i < nums.length; i++) { // цикл суммирует числа в переменную avg
            avg += nums[i];
        }
        avg = avg / nums.length; // вычисляется среднее значение
        boolean result = (avg % 1 == 0) ? true : false; // если ср. зн. имеется остаток, то false, иначе true
        return result;
    }

    public static int[] cumulativeSum (int[] nums) {
        int[] resultingArray = new int[nums.length];
        resultingArray[0] = nums[0]; // записываем в результирующий массив первый элемент, т.к. он не изменяется
        for (int i = 1; i<nums.length; i++) { // в цикле добавляем в i-ую ячейку рез. массива сумму
            int sum = resultingArray[i-1] + nums[i]; // прибавляем к предыдущему элементу рез. массива текущий элемент массива nums
            resultingArray[i] = sum;
        }
        return resultingArray;
    }

    public static int getDecimalPlaces (String num) {
        String[] literals = num.split(""); // разбиваем число по символам
        int indexOfDot = num.indexOf('.'); // находим индекс точки в числе
        if (indexOfDot == -1) { // если точка не найдена, возвращаем 0
            return 0;
        }
        int k = 0; // счётчик чисел после точки
        for (int i = indexOfDot + 1; i < num.length(); i++ ) {
            k++;
        }
        return k;
    }

    public static int Fibonacci (int num) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= num; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }

    public static boolean isValid(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        if (str.contains(" ")) {
            return false;
        } else if (str.length() > 5) {
            return false;
        }

        return true;
    }

    public static boolean isStrangePair(String str1, String str2) {
        String[] letters1 = str1.split("");
        String[] letters2 = str2.split("");
        if (letters1[0].equals( letters2[(letters2.length-1)] ) && (letters1[letters1.length -1]).equals(letters2[0])) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isPrefix(String word, String prefix) {
        return (word.startsWith(prefix.substring(0, prefix.length()-1)) );
    }

    public static boolean isSuffix (String word, String suffix) {
        return (word.endsWith( suffix.substring(1)));
    }

    public static int boxSeq(int n) {
        if (n == 0) {
            return 0; // изначально их 0
        } else {
            int k = 0;
            int flag = 0; // показывает: +3 или -1
            for (int i = 0; i < n; i++) {
                if (flag % 2 == 0) {
                    k += 3;
                } else {
                    k -= 1;
                }
                flag += 1;
            }
            return k; // возвращает кол-во полей
        }
    }
}