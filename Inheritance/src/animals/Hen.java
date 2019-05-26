package animals;

public class Hen extends Flightless {
    @Override
    public void voice() {
        System.out.println("Ко - Ко - Ко, вес =  " + getWeight() + " грамм");
    }
}
