package com.zq.designpattern.templatemethod;

/**
 * Created by zhengshouzi on 2015/10/22.
 */
public class TemplateMethod {
    public static void main(String[] args) {
        int[] array = {1, 23, 18, 22, 99, 45, 0, -1, -19};
        ConcreteSort concreteSort = new ConcreteSort();
        concreteSort.showSortResult(array);
    }
}

abstract class AbstractSort {
    protected abstract void sort(int[] array);

    public void showSortResult(int[] array) {
        this.sort(array);
        for (int val : array) {
            System.out.printf("%3d", val);
        }
    }
}

class ConcreteSort extends AbstractSort {

    @Override
    protected void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            selectSort(array, i);
        }
    }

    private void selectSort(int[] array, int index) {
        int minValue = 32767;
        int minIndex = 0;
        int temp;
        for (int i = index; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        temp = array[index];
        array[index] = array[minIndex];
        array[minIndex] = temp;
    }
}
