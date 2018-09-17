package Lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        guessNumber();
//        guessWord();
//        simpleCalculator();
        proCalculator();
    }

    static void guessNumber() {
        int number, userAnswer, repeat;
        boolean winner;
        do {
            number = random.nextInt(10);
            winner = false;
            for (int i = 0; i < 3; i++) {
                System.out.println("Угадайте число:");
                userAnswer = scanner.nextInt();
                if (userAnswer == number) {
                    winner = true;
                    break;
                } else if (userAnswer > number) {
                    System.out.println("Указанное число больше чем загаданное");
                } else {
                    System.out.println("Указанное число меньше чем загаданное");
                }
            }
            System.out.println(winner ? "Вы победили!" : "Вы проиграли :(");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            repeat = scanner.nextInt();
        } while (repeat == 1);
    }

    static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[random.nextInt(words.length)];
        String userAnswer;

        while (true) {
            System.out.println("Угадайте слово:");
            userAnswer = scanner.nextLine();

            if (word.equals(userAnswer)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                System.out.println("Вы не угадали, попробуйте еще.");
                System.out.println("Отгаданные буквы: " + findGuessedLetters(word, userAnswer));
            }
        }
    }
    
    static String findGuessedLetters(String str1, String str2){
        int len = str1.length() < str2.length() ? str1.length() : str2.length();
        char[] result = new char[15];
        
        for(int i = 0; i < result.length; i++){
            result[i] = '#';
        }
        
        for(int i = 0; i < len; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                result[i] = str1.charAt(i);
            }
        }
        
        return String.valueOf(result);
    }
    
    static void simpleCalculator(){
        int numb1 = scanner.nextInt();
        String op = scanner.next();
        int numb2 = scanner.nextInt();
        switch(op){
            case "+":             
                System.out.println(numb1 + numb2);
                break;
            case "-":
                System.out.println(numb1 - numb2);
                break;
            case "*":
                System.out.println(numb1 * numb2);
                break;
            case "/":
                System.out.println(numb2 == 0 ? "На 0 делить нельзя!" : numb1 / numb2);
                break;
            default:
                System.out.println("Введены неверные значения");
        }
    }
    
    static void proCalculator(){
        String strExercise = scanner.nextLine();
        String[] exercise = strExercise.split(" ");
        int index = 0, numb1, numb2, res;
        
        for(int i = 0; i < exercise.length; i++){
            if(exercise[i].equals("*")){
                res = Integer.parseInt(exercise[i-1]) * Integer.parseInt(exercise[i+1]);
                exercise[i-1] = String.valueOf(res);
                exercise[i+1] = String.valueOf(res);
                index = i + 1;
            }
            if(exercise[i].equals("/")){
                res = Integer.parseInt(exercise[i-1]) / Integer.parseInt(exercise[i+1]);
                exercise[i-1] = String.valueOf(res);
                exercise[i+1] = String.valueOf(res);
                index = i + 1;
            }
        }
        
        for(int i = 0; i < exercise.length; i++){
            if(exercise[i].equals("+")){
                res = Integer.parseInt(exercise[i-1]) + Integer.parseInt(exercise[i+1]);
                exercise[i-1] = String.valueOf(res);
                exercise[i+1] = String.valueOf(res);
                index = i + 1;
            }
            if(exercise[i].equals("-")){
                res = Integer.parseInt(exercise[i-1]) - Integer.parseInt(exercise[i+1]);
                exercise[i-1] = String.valueOf(res);
                exercise[i+1] = String.valueOf(res);
                index = i + 1;
            }
        }
        
        System.out.println(exercise[index]);
    }
}
