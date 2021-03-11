import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5_1 {
    static Stream<String> resultstream = Stream.empty();

    public static void main(String[] args) {
        Stream<String> s1 = Arrays.stream(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"});
        Stream<String> s2 = Arrays.stream(new String[]{"L", "M", "N", "O", "P", "Q", "R"});
        System.out.println(zipp(s1, s2).collect(Collectors.toList()).toString());
    }

    public static <String> Stream<java.lang.String> zipp(Stream<String> first, Stream<String> second) {

        Thread thread1 = new Thread(new MyThread<java.lang.String>((Stream<java.lang.String>) first));
        Thread thread2 = new Thread(new MyThread<java.lang.String>((Stream<java.lang.String>) second));

        Thread[] threads = new Thread[]{thread1, thread2};

        for (Thread thr : threads) {
            thr.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException i) {
                System.out.println(i.toString());
            }
        }

        return resultstream;
    }

    static class MyThread<T> implements Runnable {

        Stream<String> stream;

        public MyThread(Stream<String> str) {
            this.stream = str;
        }

        private final static Object MONITOR = new Object();

        @Override
        public void run() {
            stream.forEach((t) -> {
                synchronized (MONITOR) {
                    addElementsFromStreramToResultStream(t);
                }
                sleepThread(50);
            });
        }

        public void addElementsFromStreramToResultStream(String t) {
                resultstream = Stream.concat(resultstream, Stream.of(t));
        }

        public void sleepThread(int millis) {
            try {
                Thread.sleep(millis);
            } catch (IllegalStateException | InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

}
