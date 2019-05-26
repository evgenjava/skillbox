package animals;

public class Ostrich extends Flightless {
    @Override
    public void voice() {
        System.out.println("Кричит СТРАУС, вес =  " + getWeight() + " грамм");
    }
}
