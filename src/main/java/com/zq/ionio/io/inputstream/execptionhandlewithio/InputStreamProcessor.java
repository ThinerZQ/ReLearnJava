package com.zq.ionio.io.inputstream.execptionhandlewithio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Intellij IDEA
 * Date: 16-4-30
 * Time: 下午11:37
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

public interface InputStreamProcessor {
    public void process(InputStream input) throws IOException;
}


class InputStreamProcessingTemplate01 {

    public void process(String fileName, InputStreamProcessor processor) throws MyException {
        IOException processException = null;
        InputStream input = null;
        try {
            input = new FileInputStream(fileName);

            processor.process(input);
        } catch (IOException e) {
            processException = e;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    if (processException != null) {
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
            if (processException != null) {
                throw new MyException(processException,
                        "Error processing InputStream for file " +
                                fileName);
            }
        }
    }

    public class MyException extends Throwable {
        public MyException(IOException processException, IOException e, String s) {
        }

        public MyException(IOException processException, String s) {

        }
    }
}

//处理类
class Test{

    public void test(){
        try {
            new InputStreamProcessingTemplate01()
                    .process("someFile.txt", new InputStreamProcessor(){
                        public void process(InputStream input) throws IOException{
                            int inChar = input.read();
                            while(inChar != -1){
                                //do something with the chars...
                            }
                        }
                    });
        } catch (InputStreamProcessingTemplate01.MyException e) {
            e.printStackTrace();

        }
    }
}