package animals;

public interface Vertebrate extends Comparable<Vertebrate>  {
    void voice();
    double getWeight();
}
