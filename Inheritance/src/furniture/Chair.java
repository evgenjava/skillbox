package furniture;

public class Chair extends Furniture {

    private String type;

   public Chair(String type, String material, String color) {
        super(material, color);
        this.type = type;
   }

    public String getType() {
        return type;
    }
}
