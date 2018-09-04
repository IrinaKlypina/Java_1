package Lesson_1;

public class MainClass {

    public static void main(String[] args) {
        vars();
        
        System.out.println(calc(10, 15, 40, 5));
        
        System.out.println(amountIsInTheRange(10, 5));
        
        positiveOrNegative(-4);
        
        System.out.println(isNegative(-2));
        
        greeting("Irina");
        
        System.out.println(isALeapYear(2018));
    }
    
    static void vars(){
        byte b = 10;
        short s = 100;
        int i = 1000;
        long l = 10000L;
        
        float f = 3.14f;
        double d = 125.46;
        
        boolean bool = true;
        char c = 'i';
        
        String str = "Hello";
    }
    
    static int calc(int a, int b, int c, int d){
        return a * (b + (c / d));
    }
    
    static boolean amountIsInTheRange(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    
    static void positiveOrNegative(int a){
        if(a >= 0){
            System.out.println("Positive");
        }else{
            System.out.println("Negative");
        }
    }
    
    static boolean isNegative(int a){
        return a < 0;
    }
    
    static void greeting(String name){
        System.out.println("Привет, " + name + "!");
    }
    
    static boolean isALeapYear(int year){
        if(year % 400 == 0){
            return true;
        }else if(year % 100 == 0){
            return false;
        }else if(year % 4 == 0){
            return true;
        }else return false;
    }
}
