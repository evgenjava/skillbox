import java.util.Random;

public class Loader
{
    public static void main(String[] args)
    {
        int catsCount = 7;
        Cat[] cats = new Cat[catsCount];
        for (int i = 0; i < catsCount; i++) {
            cats[i] = new Cat();
            System.out.println("Weight cat " + i + " - " + cats[i].getWeight());
        }
        System.out.println("Накормим и напоем");
        for (int i = 0; i < catsCount; i++) {
            cats[i].feed(5000 * Math.random());
            cats[i].drink(5000 * Math.random());
            System.out.println("Cat " + i + " Weight - " + cats[i].getWeight() + " Status - " + cats[i].getStatus());
        }

        System.out.println("Мяучим ... ");
        for (int i = 0; i < catsCount; i++) {
            for (int j = 0; j < 7000; j++) {
                cats[i].meow();
            }
            System.out.println("Cat " + i + " Weight - " + cats[i].getWeight() + " Status - " + cats[i].getStatus());
        }
    }
}