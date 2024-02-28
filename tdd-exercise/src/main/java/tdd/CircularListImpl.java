package tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    
    ArrayList<Integer> list;
    int currentIndex;
    private static final int LIST_NEVER_USED = -1;

    public CircularListImpl(){
        list = new ArrayList<>();
        currentIndex = LIST_NEVER_USED;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(list.isEmpty()){
            return Optional.empty();
        }
        currentIndex++;
        if(currentIndex >= list.size()){
            currentIndex = 0;
        }
        return Optional.of(list.get(currentIndex));
    }

    @Override
    public Optional<Integer> previous() {
        if(list.isEmpty()){
            return Optional.empty();
        }
        currentIndex--;
        if(currentIndex < 0){
            currentIndex = list.size()-1;
        }
        return Optional.of(list.get(currentIndex));

    }

    @Override
    public void reset() {
        currentIndex = LIST_NEVER_USED;
    }

}
