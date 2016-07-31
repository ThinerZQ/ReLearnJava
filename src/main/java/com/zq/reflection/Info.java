package com.zq.reflection;

import java.util.List;

/**
 * Created by Intellij IDEA
 * Date: 16-5-1
 * Time: 下午10:00
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
@MyAnnotation(name = "my Annotation",value = "my Value")
public class Info {

    public String name = "zhengqiang";
    private int id = 10;

    public Info(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Info(int id) {
        this.id = id;
    }

    public Info(String name) {
        this.name = name;
    }

    public Info() {
    }

    public String getNameAndId() {
        return name + " " + id;
    }


    private String getNameAddId() {
        return name + "_" + id;
    }


    public List<String> getListString(){
        return null;
    }
}
