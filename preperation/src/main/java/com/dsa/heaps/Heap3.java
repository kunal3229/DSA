package com.dsa.heaps;

import java.util.ArrayList;

public class Heap3<T extends Comparable<T>>{

    private ArrayList<T> heap;

    public Heap3(){
        this.heap = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int left(int index){
        return index * 2 + 1;
    }

    private int right(int index){
        return index * 2 + 2;
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public void add(T value){
        heap.add(value);
        upheap(heap.size() - 1);
    }
    private void upheap(int index){
        if(index == 0) return;
        int parent = parent(index);

        if(heap.get(index).compareTo(heap.get(parent)) < 0){
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception{
        if (heap.isEmpty()) throw new Exception("Heap is empty");
        else if (heap.size() == 1) return heap.remove(0);

        T temp = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        downheap(0);
        return temp;
    }
    private void downheap(int index){
        if (index >= heap.size()) return;
        int left = left(index);
        int right = right(index);
        int min = index;

        if (left < heap.size() && heap.get(min).compareTo(heap.get(left)) > 0){
            min = left;
        }
        if (right < heap.size() && heap.get(min).compareTo(heap.get(right)) > 0){
            min = right;
        }
        if (min != index){
            swap(min, index);
            downheap(min);
        }
    }

}
