package Lessonnn16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class MultiThreadRead implements Runnable {
    public static String path = "C:\\Users\\Admin\\Documents\\Ben\\Java\\sample.txt";
    public static AtomicInteger countOfKeyword = new AtomicInteger();
    List<String> string;
    Thread t;
    String keyword;

    MultiThreadRead(List<String> string, String keyword) {
        this.string = string;
        this.keyword = keyword;
        t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        for (String strings : string) {
            if (strings.contains(keyword)) {
                countOfKeyword.incrementAndGet();

            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        long count = Files.lines(Paths.get(path)).count();
        System.out.println("all lines:" + count);

        List<String> string = Files.readAllLines(Paths.get(path));
        List<String> list1 = string.subList(0, 900000);
        List<String> list2 = string.subList(900001, 1800000);
        List<String> list3 = string.subList(1800001, 3448632);

        long currentTime = System.currentTimeMillis();
        MultiThreadRead multiThreadRead = new MultiThreadRead(list1, ",");
        MultiThreadRead multiThreadRead1 = new MultiThreadRead(list2, ",");
        MultiThreadRead multiThreadRead2 = new MultiThreadRead(list3, ",");


        multiThreadRead.t.join();
        multiThreadRead1.t.join();
        multiThreadRead2.t.join();


        System.out.println("found lines " + countOfKeyword);

        long finishTime = System.currentTimeMillis();
        System.out.println("time " + (finishTime - currentTime));
    }

}