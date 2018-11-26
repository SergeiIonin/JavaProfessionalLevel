public class Main {

    public static void main(String[] args) {

        Box appleBox1 = new Box(new Apple(), "appleBox1");
        Box appleBox2 = new Box(new Apple(), "appleBox2");
        Box orangeBox1 = new Box(new Orange(), "orangeBox1");
        Box orangeBox2 = new Box(new Orange(), "orangeBox2");

        try {
            appleBox1.addFruit(new Apple(), 4);
            appleBox2.addFruit(new Apple(), 3);

            orangeBox1.addFruit(new Orange(), 2);
            orangeBox2.addFruit(new Orange(), 7);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println("Capacity of " + appleBox1.getName() + " is " + appleBox1.getNumberFruits());
        System.out.println("Capacity of " + appleBox2.getName() + " is " + appleBox2.getNumberFruits());
        System.out.println("Capacity of " + orangeBox1.getName() + " is " + orangeBox1.getNumberFruits());
        System.out.println("Capacity of " + orangeBox2.getName() + " is " + orangeBox2.getNumberFruits() + "\n");

        System.out.println("Weight of the " + appleBox1.getName() + " is " + appleBox1.getBoxWeight());
        System.out.println("Weight of the " + orangeBox2.getName() + " is " + orangeBox2.getBoxWeight() + "\n");

        int takeFruits = 1;
        try {
            appleBox1.takeFruit(takeFruits);
            appleBox1.printFruitMessage(takeFruits);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        takeFruits = 3;
        try {
            orangeBox2.takeFruit(takeFruits);
            orangeBox2.printFruitMessage(takeFruits);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nCompare " + appleBox1.getName() + " and " + orangeBox2.getName() + ":");
        Box.compare(appleBox1, orangeBox2);

        System.out.println("\nPut fruits from " + orangeBox1.getName() + " to " + orangeBox2.getName() + ": ");
        orangeBox1.pourToOtherBox(orangeBox1, orangeBox2);

        System.out.println("\nCapacity of " + orangeBox1.getName() + " now is " + orangeBox1.getNumberFruits());
        System.out.println("Capacity of " + orangeBox2.getName() + " now is " + orangeBox2.getNumberFruits());
    }
}
