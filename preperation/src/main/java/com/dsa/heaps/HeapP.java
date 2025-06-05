package com.dsa.heaps;

import java.util.ArrayList;

public class HeapP<T extends Comparable<T>> {

    private ArrayList<T> heap;

    public HeapP(){
        this.heap = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }
    private int parent(int idx){
        return (idx-1)/2;
    }
    private int left(int idx){
        return 2*idx+1;
    }
    private int right(int idx){
        return 2*idx+2;
    }

    public void insert(T value){
        heap.add(value);
        upheap(heap.size()-1);
    }
    private void upheap(int idx) {
        if (idx == 0) return;

        int parent = parent(idx);
        if(heap.get(idx).compareTo(heap.get(parent)) > 0){
            swap(idx, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception{
        if (heap.isEmpty()) throw new Exception("Heap is Empty");

        T temp = heap.get(0);
        T last = heap.remove(heap.size()-1);

        if (!heap.isEmpty()){
            heap.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    private void downHeap(int idx) {
        if (idx >= heap.size()) return;

        int left = left(idx);
        int right = right(idx);
        int min = idx;

        if(left < heap.size() && heap.get(min).compareTo(heap.get(left)) < 0) min = left;
        if (right < heap.size() && heap.get(min).compareTo(heap.get(right)) < 0) min = right;

        if(min != idx){
            swap(min, idx);
            downHeap(min);
        }
    }
}
