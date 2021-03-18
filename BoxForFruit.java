package HomeWork01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxForFruit <T extends Fruit & DifrentFruits> {

    private List<T> box;
    private int boxSize;
    private float boxWeight = 0.0f;

    public BoxForFruit( int size_box, T ... fruits) {
        if(fruits.length <= size_box) {
            this.box = new ArrayList<>(Arrays.asList(fruits));
            this.boxSize = size_box - fruits.length;
        }
    }

    public float getWeightBox(){
        for (T fruit : box) {
            boxWeight += fruit.getWEIGHT();
        }
        return boxWeight;
    }

    public boolean weightBoxCompare(BoxForFruit<T> anotherBoxForFruit){
        return (this.getWeightBox() - anotherBoxForFruit.getWeightBox() < 0.001);
    }

    public void TransferFruitsToAnotherBox(BoxForFruit<T> anotherBoxForFruit){
        if(this == anotherBoxForFruit) {
            return;
        }
        int countSizeBox = Math.min(this.box.size(), anotherBoxForFruit.boxSize);

        List<T> fruits = box.subList(0,countSizeBox - 1);
        anotherBoxForFruit.box.addAll(fruits);
        this.box.removeAll(fruits);

        anotherBoxForFruit.boxSize -= countSizeBox;
        this.boxSize += countSizeBox;
    }

    public void addFruit(T fruit){
        if (boxSize - 1 > 0){
            box.add(fruit);
            boxSize--;
        }

    }
}
