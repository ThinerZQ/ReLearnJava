package com.zq.ionio.io.inputstream.execptionhandlewithio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Intellij IDEA
 * Date: 16-4-30
 * Time: 下午11:25
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

/**
 * http://tutorials.jenkov.com/java-exception-handling/exception-handling-templates.html
 * 流中异常的处理模板类
 */
abstract class InputStreamProcessingTemplate {

    public void process(String fileName) throws MyException {
        IOException processException = null;
        InputStream input = null;
        try{
            input = new FileInputStream(fileName);

            doProcess(input);
        } catch (IOException e) {
            processException = e;
        } finally {
            if(input != null){
                try {
                    input.close();
                } catch(IOException e){
                    if(processException != null){
                        throw new MyException(processException, e,
                                "Error message..." +
                                        fileName);
                    } else {
                        throw new MyException(e,
                                "Error closing InputStream for file " +
                                        fileName);
                    }
                }
            }
            if(processException != null){
                throw new MyException(processException,
                        "Error processing InputStream for file " +
                                fileName);
            }
        }
    }

        //override this method in a subclass, to process the stream.
    public abstract void doProcess(InputStream input) throws IOException;

    public class MyException extends Exception {
        public MyException(IOException processException, IOException e, String s) {

        }

        public MyException(IOException processException, String s) {

        }
    }

}
public class SubClassHandle{
    public static void main(String[] args) {

        //这是真正的文件处理的地方
        try {
            new InputStreamProcessingTemplate(){
                public void doProcess(InputStream input) throws IOException{
                    int inChar = input.read();
                    while(inChar != -1){
                        //do something with the chars...
                    }
                }
            }.process("someFile.txt");
        } catch (InputStreamProcessingTemplate.MyException e) {
            e.printStackTrace();
        }

    }
}