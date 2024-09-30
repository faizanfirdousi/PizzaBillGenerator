import java.util.Scanner;

public class Pizza {
    private int price=0;
    public boolean veg;
    private final int extraCheesePrice = 100;
    private final int extraToppingsPrice = 150;
    private final int bagPrice = 20;
    private int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isOptedForTakeAway = false;
    private boolean isVegDeluxePizza = false;
    private boolean isNonVegDeluxePizza = false;

    Scanner input = new Scanner(System.in);


    public void showMenu(){
        System.out.println("########## Welcome to Pizza Kingdom ##########");
        System.out.println("Here's our menu---");
        System.out.println("Veg Pizza      -- ₹300");
        System.out.println("Non-Veg Pizza  -- ₹400");
        System.out.println();
        System.out.println("--------------Extras--------------");
        System.out.println("Extra Cheese   -- ₹100");
        System.out.println("Extra Toppings -- ₹150");
        System.out.println();
        System.out.println("Veg Deluxe Pizza(extra cheese and toppings included) -- ₹550 ");
        System.out.println("Non-veg Deluxe Pizza(extra cheese and toppings included) -- ₹650 ");
        System.out.println();
        System.out.println("Bag charges for Take Away -- ₹20 ");

        System.out.println("Press Enter to order the food");
        input.nextLine();

        while(true){
            System.out.println("Press 1 for Veg");
            System.out.println("Press 2 for Non-Veg");
            System.out.println("Press 3 for veg deluxe pizza");
            System.out.println("Press 4 for non-veg deluxe pizza");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();  // Clear the invalid input
            }

            int i = input.nextInt();
            if(i == 1){
                veg = true;
                price += 300;
                basePizzaPrice = 300;
                showExtras();
                break;
            }
            else if(i == 2){
                veg = false;
                price += 400;
                basePizzaPrice = 400;
                showExtras();
                break;
            }
            else if(i == 3){
                vegDeluxePizza();
                break;
            }
            else if(i == 4){
                nonVegDeluxePizza();
                break;
            }
        }
    }

    public void showExtras(){
        System.out.println("press 1 to add extra cheese");
        System.out.println("press 2 to add extra toppings");
        System.out.println("press 3 for none ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            input.next();  // Clear the invalid input
        }

        int j = input.nextInt();
        if(j == 1){
            addExtraCheese();
            showTakeawayOption();
        }
        else if(j == 2){
            addExtraToppings();
            showTakeawayOption();
        }
    }

    public void showTakeawayOption(){
        System.out.println(" press 1 to get take away bag , press any other key to not take away ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            input.next();  // Clear the invalid input
        }

        int u = input.nextInt();
        if( u == 1){
            takeAway();
            getBill();
        }
        else{
            getBill();
        }
    }

    public void vegDeluxePizza(){
        price += 300;
        isVegDeluxePizza = true;
        addExtraCheese();
        addExtraToppings();
        showTakeawayOption();
    }

    public void nonVegDeluxePizza(){
        price += 400;
        isNonVegDeluxePizza = true;
        addExtraCheese();
        addExtraToppings();
        showTakeawayOption();
    }

    public void addExtraCheese(){
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;
    }

    public void addExtraToppings(){
        isExtraToppingsAdded = true;
        this.price += extraToppingsPrice;
    }

    public void takeAway(){
        isOptedForTakeAway = true;
        this.price += bagPrice;
    }

    public void getBill(){
        String bill = "";
        if(basePizzaPrice != 0){
            bill = "Pizza: "+basePizzaPrice + "\n";
        }

        if(isNonVegDeluxePizza){
            System.out.println("Non-Veg Deluxe Pizza: 650");
        }

        if(isVegDeluxePizza){
            System.out.println("Veg Deluxe Pizza: 550");
        }

        if(!isVegDeluxePizza && !isNonVegDeluxePizza){
            if(isExtraCheeseAdded){
                bill += "Extra cheese added: "+extraCheesePrice +"\n";
            }
            if(isExtraToppingsAdded){
                bill += "Extra Toppings added: "+extraToppingsPrice +"\n";
            }
        }

        if(isOptedForTakeAway){
            bill += "Take Away: "+bagPrice + "\n";
        }
        bill += "Total Bill: "+this.price + "\n";
        System.out.println(bill);
    }
}
