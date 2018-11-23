import java.util.ArrayList;

public class Box<T extends Fruit> {

    private String type;
    private String name;
    private ArrayList<T> box;
    private T fruit;

    public Box(T fruit, String name) {
        this.type = fruit.getName();
        this.name = name;
        this.box = new ArrayList<>();
        this.fruit = fruit;
    }

    public static void compare(Box box1, Box box2) {
        float weight1 = box1.getBoxWeight(box1.getFruitType());
        float weight2 = box2.getBoxWeight(box2.getFruitType());

        if (weight1 > weight2)
            System.out.println(box1.getName() + " is on " + (weight1 - weight2) + " heavier");
        else if (Math.abs(weight1 - weight2) < 0.0001)
            System.out.println("Boxes are equal in weight");
        else
            System.out.println(box2.getName() + " is on " + (weight2 - weight1) + " heavier");
    }

    public float getBoxWeight(T fruit) {
        return box.size() * fruit.getWeight();
    }

    public void takeFruit(int howMuchFruits) {
        if (box.size() > howMuchFruits) {
            for (int i = 0; i < howMuchFruits; i++) {
                box.remove(box.size() - 1 - i);
            }
        } else throw new IllegalArgumentException();
    }

    public void addFruit(T fruit, int howMuchFruits) {
        if (fruit.getName().equals(this.getType())) {
            for (int i = 0; i < howMuchFruits; i++) {
                box.add(fruit);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void pourToOtherBox(Box box1, Box box2) {
        if (box1.getType().equals(box2.getType())) {
            for (int i = 0; i < box2.box.size(); i++) {
                box1.box.add(box2.box.get(i));
            }
            box2.box.clear();
        } else throw new IllegalArgumentException();
    }

    public void printFruitMessage(int number, T fruit) {
        System.out.println("After taking " + number + " " + this.getType() + "s from " + this.getName() +
                " the number of " + this.getType() + "s there becomes " + this.getNumberFruits() +
                " and the weight is " + this.getBoxWeight(fruit));
    }

    public String getType() {
        return type;
    }

    public T getFruitType() {
        return fruit;
    }

    public String getName() {
        return name;
    }

    public int getNumberFruits() {
        return box.size();
    }

}
