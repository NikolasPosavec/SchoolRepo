package FinalProjectNP;
class FootWearSuper{
    private String brand;
    private double size;
    private String color;

public FootWearSuper(){
    String brand = "unknown";
    double size = 0;
    String color = "unknown";
}
public FootWearSuper(String brand, double size, String color){
    this.brand = brand;
    this.size = size;
    this.color = color;
}

public String getBrand(){
    return brand;
}
public void setBrand(String brand){
    this.brand = brand;
}
public double getSize(){
    return size;
}
public void setSize(double size){
    this.size = size;
}
public String getColor(){
    return color;
}
public void setColor(String color){
    this.color = color;
}
}