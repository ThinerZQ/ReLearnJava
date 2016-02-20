package com.zq.resume;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/3
 * Time: 20:48
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class Award {
    private LocalDate awardDate;
    private String awardName;

    public String getAwardName() {
        return awardName;
    }

    public Award setAwardName(String awardName) {
        this.awardName = awardName;
        return this;
    }

    public LocalDate getAwardDate() {
        return awardDate;
    }

    public Award setAwardDate(LocalDate awardDate) {
        this.awardDate = awardDate;
        return this;
    }

    @Override
    public String toString() {
        return "Award{" +"\n"+
                "\t awardDate=" + awardDate +"\n"+
                "\t awardName='" + awardName + "\'\n" +
                '}';
    }
}
