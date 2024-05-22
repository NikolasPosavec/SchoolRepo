package FinalProjectNP;

public class FlipFlops extends Sandals{
    private boolean waterproof;

public FlipFlops(){
    super();
    this.waterproof = false;
}
public FlipFlops(String brand, double size, String color, boolean hasStraps, boolean waterproof){
    super(brand, size, color, hasStraps);
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
}
