import animals.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loader {

    public static void main(String[] args) {

        List<Vertebrate> animals = new ArrayList<>();
        animals.add(new Duck());
        animals.add(new Hen());
        animals.add(new Ostrich());
        animals.add(new Sparrow());
        animals.add(new Duck());
        animals.add(new Hen());
        animals.add(new Ostrich());
        animals.add(new Sparrow());

        Collections.sort(animals);

        for (Vertebrate animal : animals) {
            animal.voice();
        }

    }
}
