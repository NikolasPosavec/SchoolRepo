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

        boolean updateMore = true;

        while (updateMore) {
            System.out.println("Updated List of Footwear:");
            for (int i = 0; i < footwearList.size(); i++) {
                System.out.println("Footwear " + (i + 1) + ":");
                displayFootwearInfo(footwearList.get(i));
                System.out.println();
            }

            System.out.println("Enter the index of the footwear to update (1-" + footwearList.size() + "):");
            int index = sc.nextInt();
            if (index >= 1 && index <= footwearList.size()) {
                updateFootwearInfo(footwearList.get(index - 1), sc);
            } else {
                System.out.println("Invalid index!");
            }

            System.out.println("Do you want to update another footwear item? (yes/no):");
            String choice = sc.next();
            updateMore = choice.equalsIgnoreCase("yes");
        }

        for (int i = 0; i < footwearList.size(); i++) {
            System.out.println("Footwear " + (i + 1) + ":");
            displayFootwearInfo(footwearList.get(i));
            System.out.println();
        }

        System.out.println("Enter the index of the footwear to update (1-" + footwearList.size() + "):");
        int index = sc.nextInt();
        if (index >= 1 && index <= footwearList.size()) {
            updateFootwearInfo(footwearList.get(index - 1), sc);
        } else {
            System.out.println("Invalid index!");
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
    }

    public static void updateFootwearInfo(FootWearSuper footwear, Scanner sc) {
        if (footwear instanceof Shoes) {
            Shoes shoes = (Shoes) footwear;
            System.out.println("Enter new brand:");
            shoes.setBrand(sc.next());
            System.out.println("Enter new size:");
            shoes.setSize(sc.nextDouble());
            System.out.println("Enter new color:");
            shoes.setColor(sc.next());
            System.out.println("Enter new material:");
            shoes.setMaterial(sc.next());
            System.out.println("Enter new hasLaces (true/false):");
            shoes.setLaces(sc.nextBoolean());
            System.out.println("Enter new price:");
            shoes.setPrice(sc.nextDouble());
        } else if (footwear instanceof Sneakers) {
            Sneakers sneakers = (Sneakers) footwear;
            System.out.println("Enter new brand:");
            sneakers.setBrand(sc.next());
            System.out.println("Enter new size:");
            sneakers.setSize(sc.nextDouble());
            System.out.println("Enter new color:");
            sneakers.setColor(sc.next());
            System.out.println("Enter new material:");
            sneakers.setMaterial(sc.next());
            System.out.println("Enter new hasLaces (true/false):");
            sneakers.setLaces(sc.nextBoolean());
            System.out.println("Enter new hasArchSupport (true/false):");
            sneakers.setHasArchSupport(sc.nextBoolean());
            System.out.println("Enter new price:");
            sneakers.setPrice(sc.nextDouble());
        } else if (footwear instanceof Boots) {
            Boots boots = (Boots) footwear;
            System.out.println("Enter new brand:");
            boots.setBrand(sc.next());
            System.out.println("Enter new size:");
            boots.setSize(sc.nextDouble());
            System.out.println("Enter new color:");
            boots.setColor(sc.next());
            System.out.println("Enter new material:");
            boots.setMaterial(sc.next());
            System.out.println("Enter new hasLaces (true/false):");
            boots.setLaces(sc.nextBoolean());
            System.out.println("Enter new height:");
            boots.setHeight(sc.nextInt());
            System.out.println("Enter new price:");
            boots.setPrice(sc.nextDouble());
        } else if (footwear instanceof Sandals) {
            Sandals sandals = (Sandals) footwear;
            System.out.println("Enter new brand:");
            sandals.setBrand(sc.next());
            System.out.println("Enter new size:");
            sandals.setSize(sc.nextDouble());
            System.out.println("Enter new color:");
            sandals.setColor(sc.next());
            System.out.println("Enter new hasStraps (true/false):");
            sandals.hasStraps(sc.nextBoolean());
            System.out.println("Enter new price:");
            sandals.setPrice(sc.nextDouble());
        } else if (footwear instanceof Slides) {
            Slides slides = (Slides) footwear;
            System.out.println("Enter new brand:");
            slides.setBrand(sc.next());
            System.out.println("Enter new size:");
            slides.setSize(sc.nextDouble());
            System.out.println("Enter new color:");
            slides.setColor(sc.next());
            System.out.println("Enter new hasStraps (true/false):");
            slides.hasStraps(sc.nextBoolean());
            System.out.println("Enter new hasBackStrap (true/false):");
            slides.setHasBackStrap(sc.nextBoolean());
            System.out.println("Enter new price:");
            slides.setPrice(sc.nextDouble());
        } else if (footwear instanceof FlipFlops) {
            FlipFlops flipFlops = (FlipFlops) footwear;
            System.out.println("Enter new brand:");
            flipFlops.setBrand(sc.next());
            System.out.println("Enter new size:");
            flipFlops.setSize(sc.nextDouble());
            System.out.println("Enter new color:");
            flipFlops.setColor(sc.next());
            System.out.println("Enter new isWaterproof (true/false):");
            flipFlops.setWaterproof(sc.nextBoolean());
            System.out.println("Enter new hasStraps (true/false):");
            flipFlops.hasStraps(sc.nextBoolean());
            System.out.println("Enter new price:");
            flipFlops.setPrice(sc.nextDouble());
        }
        
    }
}
