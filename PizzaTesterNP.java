    import java.util.Scanner;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
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
        PizzaParlor(int cheese, int pep, int veg, int kang, int dough){
          myNumCheesePizzas = 0;
          myNumPeppPizzas = 0;
          myNumVegPizzas = 0;
          myCheeseSupply = cheese;
          myPepperoniSupply = pep;
          myVeggieSupply = veg;
          myKangarooSupply = kang;
          myDoughSupply = dough;
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
        
        void orderCheese(int num){
          if(myCheeseSupply<12){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
            }
          }
          myNumCheesePizzas += num;
          myRevenue += 8*num;// cheese pizza price:$8
          myCheeseSupply -= 12*num;//cheese needed per cheese pizza
          myDoughSupply -= 11*num;
        }

        void supplyOrderCheese(){
          if(myRevenue+myOrigAcctBal<35){
            System.out.println("Too broke to order cheese, sorry!");
          }else{
            myCheeseSupply += 200;
            myRevenue -= 35;
          }
        }

        void supplyOrderDough(){
          if(myRevenue+myOrigAcctBal<35){
            System.out.println("Too broke to order dough, sorry!");
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

        void orderPepperoni(int num){
          if(myCheeseSupply<8){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
              if(myPepperoniSupply<6){
                supplyOrderPep();
              }
            }
          }
          myNumPeppPizzas += num;
          myRevenue += 10*num;//pepperoni pizza price:$10
          myCheeseSupply -= 8*num;//cheese needed per pepp pizza
          myPepperoniSupply -= 6*num;//pepperoni needed per pepp pizza
          myDoughSupply -= 11*num;
        }
        
        void supplyOrderPep(){
          if(myRevenue+myOrigAcctBal<30){
            System.out.println("Too broke to order peporoni, sorry!");
          }else{
            myPepperoniSupply += 150;
            myRevenue -= 30;
          }
        }
      
        void orderVeggie(){
          if(myCheeseSupply<8){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
              if(myVeggieSupply<12){
                supplyOrderVeggie();
              }
            }
          }
          myNumVegPizzas++;
          myRevenue += 11;//veggie pizza price:$11
          myCheeseSupply -= 8;//cheese needed per veggie pizza
          myVeggieSupply -= 12;//veggies needed per veggie pizza
          myDoughSupply -= 11;
        }
        
        void orderVeggie(int num){
          if(myCheeseSupply<8){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
              if(myVeggieSupply<12){
                supplyOrderVeggie();
              }
            }
          }
          myNumVegPizzas += num;
          myRevenue += 11*num;//veggie pizza price:$11
          myCheeseSupply -= 8*num;//cheese needed per veggie pizza
          myVeggieSupply -= 12*num;//veggies needed per veggie pizza
          myDoughSupply -= 11*num;
        }

        void supplyOrderVeggie(){
          if(myRevenue+myOrigAcctBal<25){
            System.out.println("Too broke to order veggies, sorry!");
          }else{
            myPepperoniSupply += 125;
            myRevenue -= 25;
          }
        }

        void orderKangaroo(){
          if(myCheeseSupply<8){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
              if(myKangarooSupply<5){
                supplyOrderVeggie();
              }
            }
          }
          myNumKangPizzas++;
          myRevenue += 15;
          myCheeseSupply -= 8;
          myKangarooSupply -= 5;
          myDoughSupply -= 11;
        }

        void orderKangaroo(int num){
          if(myCheeseSupply<8){
            supplyOrderCheese();
            if(myDoughSupply<11){
              supplyOrderDough();
              if(myKangarooSupply<5){
                supplyOrderVeggie();
              }
            }
          }
          myNumKangPizzas += num;
          myRevenue += 15*num;
          myCheeseSupply -= 8*num;
          myKangarooSupply -= 5*num;
          myDoughSupply -= 11*num;
        }

        void supplyOrderKangaroo(){
          if(myRevenue+myOrigAcctBal<35){
            System.out.println("Too broke to order kangaroo, sorry!");
          }else{
            myKangarooSupply += 125;
            myRevenue -= 35;
          }
        }

        public void setCheese (int num){
          myCheeseSupply = num;
        }
        
        public void setPep (int num){
          myPepperoniSupply = num;
        }

        public void setVeg (int num){
          myVeggieSupply = num;
        }

        public void setKang (int num){
          myKangarooSupply = num;
        }

        public void setDough (int num){
          myDoughSupply = num;
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
        public String toString() {
          return "PizzaParlor Status: " +
                  "\n Number of Cheese Pizzas Ordered=" + myNumCheesePizzas +
                  "\n Number of Pepperoni Pizzas Ordered=" + myNumPeppPizzas +
                  "\n Number of Veggie Pizzas Ordered=" + myNumVegPizzas +
                  "\n Number of Kangaroo Pizzas Ordered=" + myNumKangPizzas +
                  "\n Remaining Cheese Supply=" + myCheeseSupply +
                  "\n Remaining Pepperoni Supply=" + myPepperoniSupply +
                  "\n Remaining Veggie Supply=" + myVeggieSupply +
                  "\n Remaining Kangaroo Supply=" + myKangarooSupply +
                  "\n Remianing Dough Supply=" + myDoughSupply +
                  "\n Revenue=" + myRevenue +
                  "\n Original Account Balance=" + myOrigAcctBal +
                  "\n Final Account Balance=" + (myOrigAcctBal+myRevenue)
                  ;
      }
        
      }
      
      //-------------------- End of PizzaParlor class --------------------//
      
      
      public class PizzaTesterNP{
        public static void main(String[] args){
          
          Scanner sc = new Scanner (System.in);

          System.out.println("Which pizza parlor would you like to visit, 1 or 2? (If you would like to order many pizzas go with parlor 2)");
          int test = sc.nextInt();
          
          switch(test){
            case 1:
            System.out.println("How much cheese would you like to start with?");
            int cheese = sc.nextInt();
            System.out.println("How much pepperoni would you like to start with?");
            int pep = sc.nextInt();
            System.out.println("How many veggies would you like to start with?");
            int veg = sc.nextInt();
            System.out.println("How much kangaroo would you like to start with?");
            int kang = sc.nextInt();
            System.out.println("How much dough would you like to start with?");
            int dough = sc.nextInt();
          
            PizzaParlor diner = new PizzaParlor();
            diner.setCheese(cheese);
            diner.setPep(pep);
            diner.setVeg(veg);
            diner.setKang(kang);
            diner.setDough(dough);
            
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
            diner.orderKangaroo(5);

            System.out.println(diner.toString());
            break; 

            case 2:
            System.out.println("How much cheese would you like to start with?");
            int cheese1 = sc.nextInt();
            System.out.println("How much pepperoni would you like to start with?");
            int pep1 = sc.nextInt();
            System.out.println("How many veggies would you like to start with?");
            int veg1 = sc.nextInt();
            System.out.println("How much kangaroo would you like to start with?");
            int kang1 = sc.nextInt();
            System.out.println("How much dough would you like to start with?");
            int dough1 = sc.nextInt();
            PizzaParlor diner2 = new PizzaParlor(cheese1, pep1, veg1, kang1, dough1 );
            
            diner2.orderCheese();
            diner2.orderKangaroo();
            diner2.orderPepperoni();
            diner2.orderCheese();
            diner2.orderPepperoni();
            diner2.orderVeggie();
            diner2.orderCheese();
            diner2.orderVeggie();
            diner2.orderKangaroo();
            diner2.orderCheese();
            diner2.orderKangaroo(5);

            System.out.println(diner2.toString());
            break;

          }
          
        
          
        }
      }
      
    
      

