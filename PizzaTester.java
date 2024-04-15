    class PizzaParlor{
        // instance variables
        private int myNumCheesePizzas; //# of cheese pizzas
        private int myNumPeppPizzas; // # of pepperoni pizzas
        private int myNumVegPizzas; //# of veggie pizzas
        private int myNumKangPizzas;
        private int myCheeseSupply; // ounces of cheese
        private int myPepperoniSupply;// ounces of pepperoni
        private int myVeggieSupply; // ounces of veggies
        private int myKangarooSupply;
        private int myDoughSupply;
        private double myRevenue; // dollars collected
        private double myOrigAcctBal;//original bank account balance
        private int supplyOrderCheese;
        private int supplyOrderDough;
        private int supplyOrderPep;
      
        // constructor
        PizzaParlor(){
          myNumCheesePizzas = 0;
          myNumPeppPizzas = 0;
          myNumVegPizzas = 0;
          myCheeseSupply = 400;  
          myPepperoniSupply = 200;
          myVeggieSupply = 200;
          myKangarooSupply = 100;
          myRevenue = 0; 
          myOrigAcctBal = 1000;
          myDoughSupply = 400;
        }
      
        // methods
        void orderCheese(){
          if(myCheeseSupply<12){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
            }
          }
          myNumCheesePizzas++;
          myRevenue += 8;// cheese pizza price:$8
          myCheeseSupply -= 12;//cheese needed per cheese pizza
          myDoughSupply -= 11;
        }

        void supplyOrderCheese(){
          if(myRevenue<35){
            System.out.println("Too broke to order cheese, sorry!");
          }else{
            myCheeseSupply += 200;
            myRevenue -= 35;
          }
        }

        void supplyOrderDough(){
          if(myRevenue<35){
            System.out.println("Too broke to order cheese, sorry!");
          }else{
            myDoughSupply += 200;
            myRevenue -= 45;
          }
        }
      
        void orderPepperoni(){
          if(myCheeseSupply<8){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
              if(myPepperoniSupply<6){
                supplyOrderPep();
              }
            }
          }
          myNumPeppPizzas++;
          myRevenue += 10;//pepperoni pizza price:$10
          myCheeseSupply -= 8;//cheese needed per pepp pizza
          myPepperoniSupply -= 6;//pepperoni needed per pepp pizza
          myDoughSupply -= 11;
        }
        
        void supplyOrderPep(){
          if(myRevenue<30){
            System.out.println("Too broke to order peporoni, sorry!");
          }else{
            myPepperoniSupply += 150;
            myRevenue -= 30;
          }
        }
      
        void orderVeggie(){
          myNumVegPizzas++;
          myRevenue += 11;//veggie pizza price:$11
          myCheeseSupply -= 8;//cheese needed per veggie pizza
          myVeggieSupply -= 12;//veggies needed per veggie pizza
          myDoughSupply -= 11;
        }

        void orderKangaroo(){
          myNumKangPizzas++;
          myRevenue += 15;
          myCheeseSupply -= 8;
          myKangarooSupply -= 5;
          myDoughSupply -= 11;
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

        int getNumKangPizzas(){
          return myNumKangPizzas;
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

        int getDoughSupply(){
          return myDoughSupply;
        }

        int getKangarooSupply(){
          return myKangarooSupply;
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
          diner.orderKangaroo();
          diner.orderPepperoni();
          diner.orderCheese();
          diner.orderPepperoni();
          diner.orderVeggie();
          diner.orderCheese();
          diner.orderVeggie();
          diner.orderKangaroo();
          diner.orderCheese();
      
          System.out.println("# of Cheese ordered is " 
            + diner.getNumCheesePizzas());
          System.out.println("# of Pepperoni ordered is " 
            + diner.getNumPepperoniPizzas());
          System.out.println("# of Veggie ordered is " 
            + diner.getNumVeggiePizzas());
          System.out.println("# of Kangaroo ordered is " 
            + diner.getNumKangPizzas());
      
          System.out.print("\nRemaining supply of cheese in ounces is: ");
          System.out.println(diner.getCheeseSupply());
          System.out.print("Remaining supply of pepperoni in ounces is: ");
          System.out.println(diner.getPepperoniSupply());
          System.out.print("Remaining supply of veggies in ounces is: ");
          System.out.println(diner.getVeggieSupply());
          System.out.print("Remaining supply of kangaroo in ounces is: ");
          System.out.println(diner.getKangarooSupply());
          System.out.print("Remaining supply of dough in ounces is: ");
          System.out.println(diner.getDoughSupply());
      
          System.out.println("\nRevenue is $" + diner.getRevenueTotal());
          System.out.println("Bank balance is now $" 
            + diner.getBankAccountBalance());
        }
      }
      
    
      

