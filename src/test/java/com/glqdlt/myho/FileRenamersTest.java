package com.glqdlt.myho;

import org.junit.Test;

import java.io.File;
import java.util.concurrent.*;

public class FileRenamersTest {

    @Test
    public void name() throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(6);
        File d = new File("aaa");
        FileRenamers fileRenamers = new FileRenamers();
        for (File c : d.listFiles()) {
            Future<Boolean> aaaaa = pool.submit(() -> {
                System.out.println(c.getParent());
                String aaa = fileRenamers.converRename(c);
                boolean ddd = c.renameTo(new File(c.getParent() + File.separator + aaa));
                return ddd;
            });
        }

        pool.awaitTermination(10, TimeUnit.MINUTES);


    }
}