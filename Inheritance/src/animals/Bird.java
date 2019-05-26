package animals;

public abstract class Bird implements Vertebrate{
    private double weight;

    public Bird() {
        this.weight = 50 + 200 * Math.random();
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Vertebrate o) {
        return new Double(this.weight).compareTo(o.getWeight());
    }

}
