package animals;

public class Duck extends Flying {
    @Override
    public void voice() {
        System.out.println("Кря - Кря - Кря, вес =  " + getWeight()  + " грамм");
    }
}
