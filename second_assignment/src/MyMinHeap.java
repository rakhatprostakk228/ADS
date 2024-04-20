import java.util.NoSuchElementException;

class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void insert(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    public T deleteMin() {
        if (list.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = list.get(0);
        if (list.size() == 1) {
            list.clear();
        } else {
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            heapifyDown(0);
        }
        return min;
    }

    public T getMin() {
        if (list.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftChildIdx = 2 * index + 1;
            int rightChildIdx = 2 * index + 2;
            int smallest = index;

            if (leftChildIdx < list.size() && list.get(leftChildIdx).compareTo(list.get(smallest)) < 0) {
                smallest = leftChildIdx;
            }
            if (rightChildIdx < list.size() && list.get(rightChildIdx).compareTo(list.get(smallest)) < 0) {
                smallest = rightChildIdx;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}