

public class Boots extends Shoes{
    private int height;

public Boots(){
    super();
    this.height = 0;
}
public Boots(String brand, double size, String color, double price, String material, boolean laces, int height){
    super(brand, size, color, price, material, laces);
    this.height = height;
}

public int getHeight(){
    return height;
}
public void setHeight(int height){
    this.height = height;
}
@Override
public double getPrice() {
    double basePrice = super.getPrice();
    if (height > 10) {
        return basePrice + 20; 
    } else {
        return basePrice;
    }
}
@Override
public String toString() {
    return "Boots{" +
            "brand='" + getBrand() + '\'' +
            ", size=" + getSize() +
            ", color='" + getColor() + '\'' +
            ", price=" + getPrice() +
            ", material='" + getMaterial() + '\'' +
            ", laces=" + hasLaces() +
            ", height=" + height +
            '}';
}

}
