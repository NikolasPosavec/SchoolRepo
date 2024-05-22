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
}
