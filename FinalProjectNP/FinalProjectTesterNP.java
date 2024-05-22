import java.util.*;
import FinalProjectNP.Boots;
import FinalProjectNP.FlipFlops;
import FinalProjectNP.Sandals;
import FinalProjectNP.Shoes;
import FinalProjectNP.Slides;
import FinalProjectNP.Sneakers;
import FinalProjectNP.FootwearSuper;

public class FinalProjectTesterNP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<FootwearSuper> footwearList = new ArrayList<>();

        footwearList.add(new Shoes("Sperry", 9.5, "Black", "leather", true));
        footwearList.add(new Shoes("Nike", 10.0, "Brown", "canvas", true));
        footwearList.add(new Sneakers("Adidas", 8.5, "White", "mesh", true, true));
        footwearList.add(new Boots("Timberland", 11.0, "Brown", "leather", true, 12));
        footwearList.add(new Sandals("Sketchers", 7.0, "Blue", true));
        footwearList.add(new Slides("Under Armor", 8.0, "Red", true, false));
        footwearList.add(new FlipFlops("J Crew", 9.0, "Green", true, true));

        for (FootwearSuper footwear : footwearList) {
            displayFootwearInfo(footwear);
        }
    }
}
