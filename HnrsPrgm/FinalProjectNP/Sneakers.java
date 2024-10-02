

public class Sneakers extends Shoes{
    private boolean hasArchSupport;

public Sneakers(){
    super();
    hasArchSupport = true;
}
public Sneakers(String brand, double size, String color, double price, String material, boolean laces, boolean hasArchSupport){
    super(brand, size, color, price, material, laces);
    this.hasArchSupport = hasArchSupport;
}

public boolean hasArchSupport(){
    return hasArchSupport;
}
public void setHasArchSupport(boolean hasArchSupport){
    this.hasArchSupport = hasArchSupport;
}
@Override
public double getPrice() {
    double basePrice = super.getPrice();
    double archSupportCost = hasArchSupport ? 10 : 0; 
    return basePrice + archSupportCost;
}
@Override
public String toString() {
    return "Sneakers{" +
            "brand='" + getBrand() + '\'' +
            ", size=" + getSize() +
            ", color='" + getColor() + '\'' +
            ", price=" + getPrice() +
            ", material='" + getMaterial() + '\'' +
            ", laces=" + hasLaces() +
            ", hasArchSupport=" + hasArchSupport +
            '}';
}

}
