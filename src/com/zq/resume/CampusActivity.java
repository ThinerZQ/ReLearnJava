package com.zq.resume;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/3
 * Time: 20:46
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class CampusActivity {
    private LocalDate activityBeginDate;
    private LocalDate activityEndDate;
    private String activityName;
    private String activityDescription;


    public LocalDate getActivityBeginDate() {
        return activityBeginDate;
    }

    public CampusActivity setActivityBeginDate(LocalDate activityBeginDate) {
        this.activityBeginDate = activityBeginDate;
        return this;
    }

    public LocalDate getActivityEndDate() {
        return activityEndDate;
    }

    public CampusActivity setActivityEndDate(LocalDate activityEndDate) {
        this.activityEndDate = activityEndDate;
        return this;
    }

    public String getActivityName() {
        return activityName;
    }

    public CampusActivity setActivityName(String activityName) {
        this.activityName = activityName;
        return this;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public CampusActivity setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
        return this;
    }

    @Override
    public String toString() {
        return "CampusActivity{" +"\n"+
                "\t activityBeginDate=" + activityBeginDate +"\n"+
                "\t activityEndDate=" + activityEndDate +"\n"+
                "\t activityName='" + activityName + "\'\n" +
                "\t activityDescription='" + activityDescription +"\'\n" +
                '}';
    }
}
