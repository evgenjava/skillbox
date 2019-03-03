
public class Cat
{
    private static Integer count = 0;

    private Double originWeight;
    private Double weight;

    private Double minWeight;
    private Double maxWeight;
    private Double massFeed = 0.0;

    public static Integer getCatCount() {
        return count;
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public Cat(Double weight)
    {
        this.weight = weight;
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public void meow()
    {
        weight = weight - 1;
        //System.out.println("Meow");
    }

    public void gotoWC() {
        Double wc = 100.0 * Math.random();
        weight = weight - wc;
        System.out.println("Go to WC weight - " + wc);
    }

    public Double getMassFeed() {
        return massFeed;
    }
    public void feed(Double amount)
    {
        weight = weight + amount;
        massFeed = massFeed + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            count--;
            return "Dead";
        }
        else if(weight > maxWeight) {
            count--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}