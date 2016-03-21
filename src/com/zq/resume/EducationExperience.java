package com.zq.resume;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/3
 * Time: 20:42
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class EducationExperience {
    private LocalDate beginDate;
    private LocalDate endDate;
    private String university;
    private String major;
    private String degree;


    public LocalDate getBeginDate() {
        return beginDate;
    }

    public EducationExperience setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public EducationExperience setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getUniversity() {
        return university;
    }

    public EducationExperience setUniversity(String university) {
        this.university = university;
        return this;
    }

    public String getMajor() {
        return major;
    }

    public EducationExperience setMajor(String major) {
        this.major = major;
        return this;
    }

    public String getDegree() {
        return degree;
    }

    public EducationExperience setDegree(String degree) {
        this.degree = degree;
        return this;
    }

    @Override
    public String toString() {
        return "EducationExperience{" +"\n"+
                "\t beginDate=" + beginDate +"\n"+
                "\t endDate=" + endDate +"\n"+
                "\t university='" + university + "\'\n" +
                "\t major='" + major + "\'\n" +
                "\t degree='" + degree + "\'\n" +
                '}';
    }
}
