
public class Sandals extends FootWearSuper{
    private boolean hasStraps;

public Sandals(){
    super();
    this.hasStraps = true;
}
public Sandals(String brand, double size, String color, double price, boolean hasStraps){
    super(brand, size, color, price);
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
