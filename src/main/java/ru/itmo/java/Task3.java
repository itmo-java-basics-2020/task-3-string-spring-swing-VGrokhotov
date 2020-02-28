package ru.itmo.java;
import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0){
            return new int[]{};
        }
        int last = inputArray[0];
        int current = inputArray[1];
        for (int i = 1; i < inputArray.length; i++){
            current=inputArray[i];
            inputArray[i] = last;
            last = current;
        }
        inputArray[0] = current;
        return  inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            return 0;
        if (inputArray.length == 1)
            return inputArray[0];
        int negativeMax = 0;
        int negativeNextMax = 0;
        int max = -1;
        int nextMax = -1;
        for (int number: inputArray) {
            if (number >= 0){
                if (number > max){
                    nextMax = max;
                    max = number;
                } else if(number > nextMax){
                    nextMax = number;
                }
            } else{
                if (number < negativeMax){
                    negativeNextMax = negativeMax;
                    negativeMax = number;
                } else if(number < negativeNextMax){
                    negativeNextMax = number;
                }
            }
        }
        return Math.max(nextMax * max, negativeMax * negativeNextMax);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.isEmpty())
            return 0;

        var str = input.toCharArray();
        int result = 0;
        for (char letter: str) {
            if (letter == 'b' || letter == 'B' || letter == 'a' || letter == 'A'){
                result++;
            }
        }
        result *= 100;
        return result /str.length;
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;

        var str = input.toCharArray();
        for (int i = 0; i < str.length/2; i++) {
            if (str[i] != str[str.length - 1 - i])
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.isEmpty())
            return "";

        StringBuilder result = new StringBuilder();
        int currentAmount = 1;
        char currentletter = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (currentletter == input.charAt(i)){
                currentAmount += 1;
            }else {
                result.append(currentletter);
                result.append(currentAmount);
                currentAmount = 1;
                currentletter = input.charAt(i);
            }
        }

        result.append(currentletter);
        result.append(currentAmount);

        return result.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.isEmpty() ||one.length() != two.length())
            return false;

        var str1 = one.toCharArray();
        var str2 = two.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < str1.length; i++){
            if (str1[i] != str2[i])
                return false;
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if ( s == null || s.isEmpty())
            return false;

        for (int i = 0; i < s.length(); i++){
            if (s.indexOf(s.charAt(i), i+1) != -1){
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null)
            return new int[][]{{}};
        int n =  m[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;

    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null)
            return "";
        if (separator == null)
            separator = ' ';

        StringBuilder result = new StringBuilder();
        for ( String str: inputStrings) {
            result.append(str);
            if (!str.equals(inputStrings[inputStrings.length -1])){
                result.append(separator);
            }
        }

        return result.toString();

    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null || inputStrings.length == 0 || prefix.length() == 0)
            return 0;
        int result = 0;
        for (String str: inputStrings) {
            if (str.startsWith(prefix)){
                result++;
            }
        }
        return result;
    }
}
