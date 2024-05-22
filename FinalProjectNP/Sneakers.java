package FinalProjectNP;

public class Sneakers extends Shoes{
    private boolean hasArchSupport;

public Sneakers(){
    super();
    hasArchSupport = true;
}
public Sneakers(String brand, double size, String color, String material, boolean laces, boolean hasArchSupport){
    super(brand, size, color, material, laces);
    this.hasArchSupport = hasArchSupport;
}

public boolean hasArchSupport(){
    return hasArchSupport;
}
public void setHasArchSupport(boolean hasArchSupport){
    this.hasArchSupport = hasArchSupport;
}
    
}
