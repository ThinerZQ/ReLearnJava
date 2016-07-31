package com.zq.concurrent.forjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Intellij IDEA
 * Date: 16-5-4
 * Time: 下午12:27
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class FolderProcessor extends RecursiveTask<List<String>> {

    private String path;
    private String extension;


    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();

        File file = new File(path);

        File content[] = file.listFiles();

        if (content != null) {
            for (int i = 0; i < content.length; i++) {
                if (content[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content[i].
                            getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);

                } else {
                    if (checkFile(content[i].getName())) {
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }
            if (tasks.size() > 50) {
                System.out.printf("%s: %d tasks ran.\n", file.
                        getAbsolutePath(), tasks.size());
            }
        }
        addResultsFromTasks(list, tasks);
        return list;

    }

    private void addResultsFromTasks(List<String> list,
                                     List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            list.addAll(item.join());
        }
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }


    public static void main(String[] args) {


        ForkJoinPool pool=new ForkJoinPool();
        FolderProcessor system=new FolderProcessor("/home/thinerzq/Pictures/nature",
                ".jpg");
        /*FolderProcessor apps=new
                FolderProcessor("C:\\Program Files","log");
        FolderProcessor documents=new FolderProcessor("C:\\Documents"+
                "And Settings","log");*/
        pool.execute(system);
      /*  pool.execute(apps);
        pool.execute(documents);*/

        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n",pool.
                    getParallelism());
            System.out.printf("Main: Active Threads: %d\n",pool.
                    getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n",pool.
                    getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n",pool.
                    getStealCount());
            System.out.printf("*****************************************"
                    +"\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while((!system.isDone()));
        pool.shutdown();

        List<String> results;
        results=system.join();
        System.out.printf("System: %d files found.\n",results.size());
       /* results=apps.join();
        System.out.printf("Apps: %d files found.\n",results.size());
        results=documents.join();
        System.out.printf("Documents: %d files found.\n",results.
                size());*/

    }
}







