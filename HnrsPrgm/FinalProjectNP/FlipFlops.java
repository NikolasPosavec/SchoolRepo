public class FlipFlops extends Sandals{
    private boolean waterproof;

public FlipFlops(){
    super();
    this.waterproof = false;
}
public FlipFlops(String brand, double size, String color, double price, boolean hasStraps, boolean waterproof){
    super(brand, size, color, price, hasStraps);
    this.waterproof = waterproof;
}

public boolean isWaterproof(){
    return waterproof;
}
public void setWaterproof(boolean waterproof){
    this.waterproof = waterproof;
}
@Override
public double getPrice() {
    double basePrice = super.getPrice();
    double waterproofCost = waterproof ? 10 : 0; 
    return basePrice + waterproofCost;
}
@Override
public String toString() {
    return "FlipFlops{" +
            "brand='" + getBrand() + '\'' +
            ", size=" + getSize() +
            ", color='" + getColor() + '\'' +
            ", price=" + getPrice() +
            ", hasStraps=" + hasStraps() +
            ", waterproof=" + waterproof +
            '}';
}

}
