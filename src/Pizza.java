public class Pizza {
    private int price;
    private Boolean veg;
    private int extraCheesePrice = 100;
    private int extraToppingsPrice = 150;
    private int bagPrice = 20;
    private int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isOptedForTakeAway = false;

    public Pizza(Boolean veg) {
        this.veg = veg;
        if(this.veg){
            this.price = 300;
        }
        else{
            this.price = 400;
        }
        basePizzaPrice = this.price;
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
        String bill = "Pizza: "+basePizzaPrice + "\n";
        if(isExtraCheeseAdded){
            bill += "Extra cheese added: "+extraCheesePrice +"\n";
        }
        if(isExtraToppingsAdded){
            bill += "Extra Toppings added: "+extraToppingsPrice +"\n";
        }
        if(isOptedForTakeAway){
            bill += "Take Away: "+bagPrice + "\n";
        }
        bill += "Total Bill: "+this.price + "\n";
        System.out.println(bill);
    }
}
