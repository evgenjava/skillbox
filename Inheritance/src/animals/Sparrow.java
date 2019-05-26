package animals;

public class Sparrow extends Flying {
    @Override
    public void voice() {
        System.out.println("Чирик - Чирик - Чирик, вес =  " + getWeight() + " грамм");
    }
}
