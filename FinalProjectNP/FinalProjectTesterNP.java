import java.util.*;

public class FinalProjectTesterNP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<FootWearSuper> footwearList = new ArrayList<FootWearSuper>();

        footwearList.add(new Shoes("Sperry", 9.5, "Black", 50.00, "leather", true));
        footwearList.add(new Shoes("Nike", 10.0, "Brown", 60.00,  "canvas", true));
        footwearList.add(new Sneakers("Adidas", 8.5, "White", 65.00, "mesh", true, true));
        footwearList.add(new Boots("Timberland", 11.0, "Brown", 70.00, "leather", true, 12));
        footwearList.add(new Sandals("Sketchers", 7.0, "Blue", 35.00, true));
        footwearList.add(new Slides("Under Armor", 8.0, "Red", 30.00, true, false));
        footwearList.add(new FlipFlops("J Crew", 9.0, "Green", 30.00, true, true));

        for (FootWearSuper footwear : footwearList) {
            displayFootwearInfo(footwear);
        }
    }

    public static void displayFootwearInfo(FootWearSuper footwear) {
        System.out.println("Brand: " + footwear.getBrand());
        System.out.println("Size: " + footwear.getSize());
        System.out.println("Color: " + footwear.getColor());
        if (footwear instanceof Shoes) {
            Shoes shoes = (Shoes) footwear;
            System.out.println("Material: " + shoes.getMaterial());
            System.out.println("Has Laces: " + shoes.hasLaces());
            System.out.println("Price: $" + shoes.getPrice());
        } else if (footwear instanceof Sneakers) {
            Sneakers sneakers = (Sneakers) footwear;
            System.out.println("Material: " + sneakers.getMaterial());
            System.out.println("Has Laces: " + sneakers.hasLaces());
            System.out.println("Has Arch Support: " + sneakers.hasArchSupport());
            System.out.println("Price: $" + sneakers.getPrice());
        } else if (footwear instanceof Boots) {
            Boots boots = (Boots) footwear;
            System.out.println("Material: " + boots.getMaterial());
            System.out.println("Has Laces: " + boots.hasLaces());
            System.out.println("Height: " + boots.getHeight() + " inches");
            System.out.println("Price: $" + boots.getPrice());
        } else if (footwear instanceof Sandals) {
            Sandals sandals = (Sandals) footwear;
            System.out.println("Has Straps: " + sandals.hasStraps());
            System.out.println("Price: $" + sandals.getPrice());
        } else if (footwear instanceof Slides) {
            Slides slides = (Slides) footwear;
            System.out.println("Has Straps: " + slides.hasStraps());
            System.out.println("Has Back Strap: " + slides.hasBackStrap());
            System.out.println("Price: $" + slides.getPrice());
        } else if (footwear instanceof FlipFlops) {
            FlipFlops flipFlops = (FlipFlops) footwear;
            System.out.println("Is Waterproof: " + flipFlops.isWaterproof());
            System.out.println("Has Straps: " + flipFlops.hasStraps());
            System.out.println("Price: $" + flipFlops.getPrice());
        }
        System.out.println();
    }
}
