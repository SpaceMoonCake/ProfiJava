package HomeWork01;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args){
        //для задания 1-2
        Character[] arrayChar = {'a', '1', '@', ')'};
        changePosition(arrayChar, 0,1);
        printArray(arrayChar);
        System.out.println(arrayToList(arrayChar).get(3));

        //для задания 3
        BoxForFruit<Apple> appleBoxForFruit = new BoxForFruit<>(10, new Apple(), new Apple());
        BoxForFruit<Apple> appleBoxForFruit1 = new BoxForFruit<>(5, new Apple(), new Apple());
        BoxForFruit<Orange> orangeBoxForFruit = new BoxForFruit<>(5, new Orange(), new Orange());
        appleBoxForFruit.addFruit(new Apple());
        orangeBoxForFruit.addFruit(new Orange());
        System.out.println(appleBoxForFruit.getWeightBox());
        System.out.println(appleBoxForFruit.weightBoxCompare(appleBoxForFruit));
        System.out.println(appleBoxForFruit.weightBoxCompare(appleBoxForFruit1));
        appleBoxForFruit.TransferFruitsToAnotherBox(appleBoxForFruit1);
    }

    //Написать метод, который меняет два элемента массива местами (массив может быть любого
    //ссылочного типа);
    public static <T> void changePosition(T[] array, int numberSellOne, int numberSellTwo){
        try{
            T sellOne = array[numberSellOne];
            array[numberSellOne] = array[numberSellTwo];;
            array[numberSellTwo] = sellOne;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Элемента с индексом " + e.getMessage() + " нет в массиве");
        }
    }

    //Написать метод, который преобразует массив в ArrayList;
    public static <T> List<T> arrayToList (T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> void printArray(T[] array){
        for(int i = 0; i <array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
