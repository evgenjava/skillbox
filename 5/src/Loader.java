public class Loader {

    private static String[] colors = {
           "Красный", "Оранжевый", "Жёлтый", "Зелёный",
            "Голубой", "Синий", "Фиолетовый"
    };
    public static void main(String[] args) {

        System.out.println("В прямом порядке :");
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("В обратном порядке :");
        for (int i = colors.length - 1; i >= 0; i--) {
            System.out.println(colors[i]);
        }
    }
}
