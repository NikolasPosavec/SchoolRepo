    class PizzaParlor{
        // instance variables
        private int myNumCheesePizzas; //# of cheese pizzas
        private int myNumPeppPizzas; // # of pepperoni pizzas
        private int myNumVegPizzas; //# of veggie pizzas
        private int myCheeseSupply; // ounces of cheese
        private int myPepperoniSupply;// ounces of pepperoni
        private int myVeggieSupply; // ounces of veggies
        private double myRevenue; // dollars collected
        private double myOrigAcctBal;//original bank account balance
      
        // constructor
        PizzaParlor(){
          myNumCheesePizzas = 0;
          myNumPeppPizzas = 0;
          myNumVegPizzas = 0;
          myCheeseSupply = 400;  
          myPepperoniSupply = 200;
          myVeggieSupply = 200;
          myRevenue = 0; 
          myOrigAcctBal = 1000;
        }
      
        // methods
        void orderCheese(){
          myNumCheesePizzas++;
          myRevenue += 8;// cheese pizza price:$8
          myCheeseSupply -= 12;//cheese needed per cheese pizza
        }
      
        void orderPepperoni(){
          myNumPeppPizzas++;
          myRevenue += 10;//pepperoni pizza price:$10
          myCheeseSupply -= 8;//cheese needed per pepp pizza
          myPepperoniSupply -= 6;//pepperoni needed per pepp pizza
        }
      
        void orderVeggie(){
          myNumVegPizzas++;
          myRevenue += 11;//veggie pizza price:$11
          myCheeseSupply -= 8;//cheese needed per veggie pizza
          myVeggieSupply -= 12;//veggies needed per veggie pizza
        }
      
        int getNumCheesePizzas(){
          return myNumCheesePizzas;
        }
      
        int getNumPepperoniPizzas(){
          return myNumPeppPizzas;
        }
      
        int getNumVeggiePizzas(){
          return myNumVegPizzas;
        }
      
        int getCheeseSupply(){
          return myCheeseSupply;
        }
      
        int getPepperoniSupply(){
          return myPepperoniSupply;
        }
      
        int getVeggieSupply(){
          return myVeggieSupply;
        }
      
        double getRevenueTotal(){
          return myRevenue;
        }
      
        double getBankAccountBalance(){
          return myOrigAcctBal + myRevenue;
        }
      }
      
      //-------------------- End of PizzaParlor class --------------------//
      
      
      public class PizzaTester{
        public static void main(String[] args){
      
          PizzaParlor diner = new PizzaParlor();
          
          diner.orderCheese();
          diner.orderCheese();
          diner.orderPepperoni();
          diner.orderCheese();
          diner.orderPepperoni();
          diner.orderVeggie();
          diner.orderCheese();
          diner.orderVeggie();
          diner.orderPepperoni();
          diner.orderCheese();
      
          System.out.println("# of Cheese ordered is " 
            + diner.getNumCheesePizzas());
          System.out.println("# of Pepperoni ordered is " 
            + diner.getNumPepperoniPizzas());
          System.out.println("# of Veggie ordered is " 
            + diner.getNumVeggiePizzas());
      
          System.out.print("\nRemaining supply of cheese in ounces is: ");
          System.out.println(diner.getCheeseSupply());
          System.out.print("Remaining supply of pepperoni in ounces is: ");
          System.out.println(diner.getPepperoniSupply());
          System.out.print("Remaining supply of veggies in ounces is: ");
          System.out.println(diner.getVeggieSupply());
      
          System.out.println("\nRevenue is $" + diner.getRevenueTotal());
          System.out.println("Bank balance is now $" 
            + diner.getBankAccountBalance());
        }
      }
      
    
      

