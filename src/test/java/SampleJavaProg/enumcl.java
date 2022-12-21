package SampleJavaProg;
enum Size {
    SMALL, MEDIUM, LARGE, EXTRALARGE
}

class Test {
    Size pizzaSize;
    public Test(Size pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
    public void orderPizza() {

        switch(pizzaSize) {
            case SMALL:
                System.out.println("I ordered a small size pizza.");
                break;
            case MEDIUM:
                System.out.println("I ordered a medium size pizza.");
                break;
            case LARGE:
                System.out.println("I ordered a LARGE size pizza.");
                break;
            case EXTRALARGE:
                System.out.println("I ordered a EXTRALARGE size pizza.");
                break;
            default:
                System.out.println("I don't know which one to order.");
                break;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Test t1 = new Test(Size.EXTRALARGE);
        t1.orderPizza();
    }
}
