import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class Exercise5_1 {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        Stream<String> s1 = Arrays.stream(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K"});
        Stream<String> s2 = Arrays.stream(new String[]{"L", "M", "N", "O", "P", "Q", "R"});

        System.out.println(zipp(s1, s2).collect(Collectors.toList()).toString());
    }

    public static <String> Stream<java.lang.String> zipp(Stream<String> first, Stream<String> second) {

        Thread thread1 = new Thread(new MyThread<java.lang.String>((Stream<java.lang.String>) first));
        Thread thread2 = new Thread(new MyThread<java.lang.String>((Stream<java.lang.String>) second));

        Thread[] threads = new Thread[] {thread1, thread2};
        thread1.start();
        thread2.start();

        for (Thread thread : threads) {
            try {
                thread.join();
            }catch (InterruptedException i){
                System.out.println(i.toString());
            }
        }

        return result.stream();
    }


    static class MyThread<T> implements Runnable {

        Stream<String> stream;

        public MyThread(Stream<String> str) {
            this.stream = str;
        }

        private final static Object MONITOR = new Object();
        @Override
        public void run() {
            stream.parallel().iterator().forEachRemaining((t) -> {
                synchronized (MONITOR) {
                    addElementsFromStreramToList(t);
                }

                sleepThread();
            });

        }

        public void addElementsFromStreramToList(String t){
            result.add(t);
        }

        public void sleepThread(){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
