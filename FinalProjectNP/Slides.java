package FinalProjectNP;

public class Slides extends Sandals{
    private boolean hasBackStrap;

public Slides(){
    super();
    this.hasBackStrap = false;
}
public Slides(String brand, double size, String color, boolean hasStraps, boolean hasBackStrap){
    super(brand, size, color, hasStraps);
    this.hasBackStrap = hasBackStrap;
}

public boolean hasBackStrap(){
    return hasBackStrap;
}
public void setHasBackStrap(boolean hasBackStrap){
    this.hasBackStrap = hasBackStrap;
}
@Override
public double getPrice() {
    double basePrice = super.getPrice();
    double backStrapCost = hasBackStrap ? 3 : 0;
    return basePrice + backStrapCost;
}
}
