package deal;

import java.util.*;
import java.util.stream.*;


public class CountAggrement {
    public long countaggrement(int i, ArrayList<Integer> list){
        return list.stream().filter(number -> number == i).count();
    }
}
