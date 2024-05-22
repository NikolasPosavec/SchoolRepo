package FinalProjectNP;
class FootWearSuper{
    private String brand;
    private double size;
    private String color;
    private double price;

public FootWearSuper(){
    String brand = "unknown";
    double size = 0;
    String color = "unknown";
    double price = 0;
}
public FootWearSuper(String brand, double size, String color, double price){
    this.brand = brand;
    this.size = size;
    this.color = color;
    this.price = price;
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
public double getPrice(){
    return price;
}
public void setPrice(double price){
    this.price = price;
}
public static void displayFootwearInfo(FootwearSuper footwear) {
    System.out.println("Brand: " + footwear.getBrand());
    System.out.println("Size: " + footwear.getSize());
    System.out.println("Color: " + footwear.getColor());
    System.out.println("Price: $" + footwear.getPrice());
    if (footwear instanceof Shoes) {
        Shoes shoes = (Shoes) footwear;
        System.out.println("Material: " + shoes.getMaterial());
        System.out.println("Has Laces: " + shoes.hasLaces());
    } else if (footwear instanceof Sneakers) {
        Sneakers sneakers = (Sneakers) footwear;
        System.out.println("Material: " + sneakers.getMaterial());
        System.out.println("Has Laces: " + sneakers.hasLaces());
        System.out.println("Has Arch Support: " + sneakers.hasArchSupport());
    } else if (footwear instanceof Boots) {
        Boots boots = (Boots) footwear;
        System.out.println("Material: " + boots.getMaterial());
        System.out.println("Has Laces: " + boots.hasLaces());
        System.out.println("Height: " + boots.getHeight() + " inches");
    } else if (footwear instanceof Sandals) {
        Sandals sandals = (Sandals) footwear;
        System.out.println("Has Straps: " + sandals.hasStraps());
    } else if (footwear instanceof Slides) {
        Slides slides = (Slides) footwear;
        System.out.println("Has Straps: " + slides.hasStraps());
        System.out.println("Has Back Strap: " + slides.hasBackStrap());
    } else if (footwear instanceof FlipFlops) {
        FlipFlops flipFlops = (FlipFlops) footwear;
        System.out.println("Is Waterproof: " + flipFlops.isWaterproof());
        System.out.println("Has Straps: " + flipFlops.hasStraps());
    }
    System.out.println();
}
}