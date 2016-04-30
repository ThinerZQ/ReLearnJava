package com.zq.ionio.io.inputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Intellij IDEA
 * Date: 16-4-30
 * Time: 下午10:56
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class SystemOutDemo01 {
    public static void main(String[] args) throws FileNotFoundException {

        OutputStream output = new FileOutputStream("/home/thinerzq/Workspace/IdeaWorkspace/ReLearnJava/src/main/resources/systemout.txt");

        PrintStream printOut = new PrintStream(output);

        System.setOut(printOut);

        System.out.println("i love you redirect to systemout.txt");

    }
}
