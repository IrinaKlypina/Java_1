package Lesson_7;

public class Cat {
    private String name;
    private int appetitte;
    private boolean full;
    
    public String getName(){
        return name;
    }
    
    public int getAppetitte(){
        return appetitte;
    }
    
    public void setFull(boolean full){
        this.full = full;
    }
    
    public Cat(String name, int appetitte){
        this.name = name;
        this.appetitte = appetitte;
        full = false;
    }
    
    public void eat(Plate plate){
        plate.decreaseFood(appetitte, this);        
    }
    
    public void info(){
        System.out.println(name + (full ? " is" : " isn't") + " full");
    }
}

class Plate{
    private int food;
    
    public int getFood(){
        return food;
    }
    
    public void decreaseFood(int n, Cat cat){
        if(n > food){
            cat.setFull(false);
        }else{
            food -= n;
            cat.setFull(true);
        }
    }
    
    public Plate(int food){
        this.food = food;
    }
    
    public void addFood(int food){
        this.food += food;
    }
    
    public void info(){
        System.out.println("plate " + food);
    }
    
}

class MainClass{
    public static void main(String[] args){
        Cat[] cats = {new Cat("Barsik", 20), new Cat("Felix", 15), new Cat("Max", 40)};
        Plate plate = new Plate(50);
        
        plate.info();
        for(Cat cat : cats){
            cat.eat(plate);
        }
        plate.info();
        for(Cat cat : cats){
            cat.info();
        }
        plate.addFood(20);
        plate.info();
    }
}