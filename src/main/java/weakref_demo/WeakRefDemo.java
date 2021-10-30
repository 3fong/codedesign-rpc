package weakref_demo;

import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.WeakHashMap;

public class WeakRefDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            WeakRefDemo.valueOf(i);
            if(new Random().nextInt()%3==0){
                WeakRefDemo.valueOf(i);
            }

        }
        System.out.println(IntegerCache.cache);
    }

    public static Integer valueOf(int i) {
        final WeakReference<Integer> cached = IntegerCache.cache.get(i);
        if (cached != null) {
            final Integer value = cached.get();
            if (value != null) {
                System.out.println("fit cache: "+value);
                return value;
            }
        }
        WeakReference<Integer> val = new WeakReference<>(i);
        System.out.println("put cache: "+i);
        IntegerCache.cache.put(i, val);
        return val.get();
    }

    private static class IntegerCache {
        //也可以提前分配容量
        public static final WeakHashMap<Integer, WeakReference<Integer>> cache = new WeakHashMap<>();
        private IntegerCache() {
        }
    }
}



