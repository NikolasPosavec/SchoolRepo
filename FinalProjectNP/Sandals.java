package FinalProjectNP;

public class Sandals extends FootWearSuper{
    private boolean hasStraps;

public Sandals(){
    super();
    this.hasStraps = true;
}
public Sandals(String brand, double size, String color, boolean hasStraps){
    super(brand, size, color);
    this.hasStraps = hasStraps;
}

public boolean hasStraps(){
    return hasStraps;
}
public void hasStraps(boolean hasStraps){
    this.hasStraps = hasStraps;
}
@Override
public double getPrice() {
    double basePrice = super.getPrice();
    double strapsCost = hasStraps ? 5 : 0;
    return basePrice + strapsCost;
}
}
