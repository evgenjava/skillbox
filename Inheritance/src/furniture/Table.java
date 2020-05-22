package furniture;

public class Table extends Furniture {

    private String form;
    private int lenght;
    private int width;
    private int height;


    public Table(String form, String material, String color) {
        super(material, color);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
