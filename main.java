import java.util.Scanner;

// Model: stores and changes the coffee pot's data
class CoffeePot {
    private int coffee = 0;
    private final int capacity = 10;

    public void brew(int cups) {
        coffee += cups;

        if (coffee > capacity) {
            coffee = capacity;
        }
    }

    public void pour(int cups) {
        coffee -= cups;

        if (coffee < 0) {
            coffee = 0;
        }
    }

    public int getCoffee() {
        return coffee;
    }

    public int getCapacity() {
        return capacity;
    }
}

// View: displays information to the user
class CoffeeView {
    public void showMenu() {
        System.out.println("\n1. Brew coffee");
        System.out.println("2. Pour coffee");
        System.out.println("3. Show coffee amount");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    public void showAmount(int coffee, int capacity) {
        System.out.println("Coffee in pot: " + coffee + " out of " + capacity + " cups");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

// Controller: gets choices and tells the Model and View what to do
class CoffeeController {
    private CoffeePot model;
    private CoffeeView view;
    private Scanner input;

    public CoffeeController(CoffeePot model, CoffeeView view) {
        this.model = model;
        this.view = view;
        input = new Scanner(System.in);
    }

    public void run() {
        int choice = -1;

        while (choice != 0) {
            view.showMenu();
            choice = input.nextInt();

            if (choice == 1) {
                System.out.print("How many cups to brew? ");
                int cups = input.nextInt();
                model.brew(cups);
                view.showAmount(model.getCoffee(), model.getCapacity());
            } else if (choice == 2) {
                System.out.print("How many cups to pour? ");
                int cups = input.nextInt();
                model.pour(cups);
                view.showAmount(model.getCoffee(), model.getCapacity());
            } else if (choice == 3) {
                view.showAmount(model.getCoffee(), model.getCapacity());
            }
        }

        view.showMessage("Goodbye!");
    }
}

public class Main {
    public static void main(String[] args) {
        CoffeePot model = new CoffeePot();
        CoffeeView view = new CoffeeView();
        CoffeeController controller = new CoffeeController(model, view);

        controller.run();
    }
}
