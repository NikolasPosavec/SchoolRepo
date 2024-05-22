package FinalProjectNP;

public class Boots extends Shoes{
    private int height;

public Boots(){
    super();
    this.height = 0;
}
public Boots(String brand, double size, String color, String material, boolean laces, int height){
    super(brand, size, color, material, laces);
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
}
