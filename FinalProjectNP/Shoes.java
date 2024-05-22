package FinalProjectNP;

public class Shoes extends FootWearSuper {
    private String material;
    private boolean laces;

public Shoes(){
    super();
    this.material = "unknown";
    this.laces = true;
}
public Shoes(String brand, double size, String color, String material, boolean laces){
    super(brand, size, color);
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
}
