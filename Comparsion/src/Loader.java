public class Loader {
    public static void main(String[] args) {
        Integer dimaAge = 19;
        Integer mishaAge = 20;
        Integer vasiaAge = 30;

        Integer oldest = 0;
        Integer youngest = 0;
        Integer middle = 0;

        if (dimaAge > mishaAge) {
            if (dimaAge > vasiaAge) {
                oldest = dimaAge;
                if (mishaAge > vasiaAge) {
                    middle = mishaAge;
                    youngest = vasiaAge;
                }
                else {
                    middle = vasiaAge;
                    youngest = mishaAge;
                }
            }
            else {
                oldest = vasiaAge;
                middle = dimaAge;
                youngest = mishaAge;
            }
        }
        else {
            if (mishaAge > vasiaAge) {
                oldest = mishaAge;
                if (dimaAge > vasiaAge) {
                    middle = dimaAge;
                    youngest = vasiaAge;
                }
                else {
                    middle = vasiaAge;
                    youngest = dimaAge;
                }
            }
            else {
                oldest = vasiaAge;
                middle = mishaAge;
                youngest = dimaAge;
            }
        }

        System.out.println("Most old: " + oldest);
        System.out.println("Most young: " + youngest);
        System.out.println("Middle: " + middle);


    }
}
