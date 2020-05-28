import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

    public  class CoffeeMachine{
         private int milk;
         private int coffee;
         private int water;
         private int money;

        public  int getCoffee() {
            return coffee;
        }

        public  int getWater() {
            return water;
        }

        public  int getMoney() {
            return money;
        }

        public  int getMilk() {
            return milk;
        }

        public CoffeeMachine(int milk, int coffee, int water, int money){
            this.milk = milk;
            this.coffee = coffee;
            this.water = water;
            this.money = money;
        }

        public void makeCoffee(String coffeType){
            switch (coffeType) {
                case ("latte"):{
                    coffee-=50;
                    milk-=30;
                    water-=70;
                    money+=50;
                    break;
                }
                case("capuccino"):{
                    coffee-=50;
                    milk-=50;
                    water-=50;
                    money+=50;
                    break;
                }
                case("americano"):{
                    coffee-=50;
                    water-=100;
                    money+=40;
                    break;
                }
                case("espresso"):{
                    coffee-=50;
                    water-=50;
                    money+=30;
                    break;
                }
            }
        }

        public enum Coffee{
            capuccino,
            latte,
            espresso,
            americano
        }

        public void fill(String product, int count){
            switch (product){
                case("milk"):
                    milk+=count;
                    break;
                case("coffee"):
                    coffee+=count;
                    break;
                case("water"):
                    water+=count;
                    break;
                case("money"):
                    money+=count;
                    break;
            }
        }


    }

class  MyProgram{
    public static void main(String[] args) {
        var coffeeMachine = new CoffeeMachine(400,400, 400, 0);
        var exit = false;


        var coffeeTypes = CoffeeMachine.Coffee.values();
        var tempBuffer = new StringBuffer();
        Arrays.stream(coffeeTypes).forEach(type -> tempBuffer.append(type.toString() + ' '));
        while (!exit){
            System.out.println("What will we do?: fill, makeCoffee, exist, exit");
            Scanner input = new Scanner(System.in);
            switch (input.nextLine()){
                case ("fill"):
                    System.out.println("What unit and count do you want to fill?");
                    var result = input.nextLine().split(" ");
                    coffeeMachine.fill(result[0], Integer.parseInt(result[1]));
                    break;

                case ("makeCoffee"):

                    System.out.println("What coffee do you want?: " + coffeeTypes);
                    coffeeMachine.makeCoffee(input.nextLine());
                    break;

                case("exist"):
                    System.out.println("The CoffeeMachine contains: \n" +
                            "milk: " + coffeeMachine.getMilk() + '\n' +
                            "water: " + coffeeMachine.getWater() + '\n' +
                            "coffee: " + coffeeMachine.getCoffee() + '\n' +
                            "money: " + coffeeMachine.getMoney() + '\n');
                    break;
                case("exit"):
                    exit = true;
            }

        }
    }
}


