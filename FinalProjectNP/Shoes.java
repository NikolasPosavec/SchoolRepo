

public class Shoes extends FootWearSuper {
    private String material;
    private boolean laces;

public Shoes(){
    super();
    this.material = "unknown";
    this.laces = true;
}
public Shoes(String brand, double size, String color, double price, String material, boolean laces){
    super(brand, size, color, price);
    this.material = material;
    this.laces = laces;
}

public String getMaterial(){
    return material;
}
public void setMaterial(String material){
    this.material = material;
}
public boolean hasLaces(){
    return laces;
}
public void setLaces(boolean laces){
    this.laces = laces;
}
@Override
public double getPrice() {
    double basePrice = super.getPrice();
    double materialCost = 0;

    if (material.equals("leather")) {
        materialCost = 20;
    } else if (material.equals("canvas")) {
        materialCost = 10;
    }
    
    double lacesCost = laces ? 5 : 0;
    return basePrice + materialCost + lacesCost;
}
}
