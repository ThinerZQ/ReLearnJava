package com.zq.resume;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/3
 * Time: 20:50
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class ProjectExperience {
    private LocalDate projectBeginDate;
    private LocalDate projectEndDate;
    private String projectName;
    private String projectPosition;
    private String projectDescription;

    private List<String> projectDifficulties;


    public LocalDate getProjectBeginDate() {
        return projectBeginDate;
    }

    public ProjectExperience setProjectBeginDate(LocalDate projectBeginDate) {
        this.projectBeginDate = projectBeginDate;
        return this;
    }

    public LocalDate getProjectEndDate() {
        return projectEndDate;
    }

    public ProjectExperience setProjectEndDate(LocalDate projectEndDate) {
        this.projectEndDate = projectEndDate;
        return this;
    }

    public String getProjectPosition() {
        return projectPosition;
    }

    public ProjectExperience setProjectPosition(String projectPosition) {
        this.projectPosition = projectPosition;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectExperience setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public ProjectExperience setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
        return this;
    }

    public List<String> getProjectDifficulties() {
        return projectDifficulties;
    }

    public ProjectExperience setProjectDifficulties(List<String> projectDifficulties) {
        this.projectDifficulties = projectDifficulties;
        return this;
    }

    @Override
    public String toString() {
        return "ProjectExperience{" +"\n"+
                "\t projectBeginDate=" + projectBeginDate +"\n"+
                "\t projectEndDate=" + projectEndDate +"\n"+
                "\t projectName='" + projectName + "\'\n" +
                "\t projectPosition='" + projectPosition +"\'\n" +
                "\t projectDescription='" + projectDescription + "\'\n" +
                "\t projectDifficulties=" + projectDifficulties +"\n"+
                '}';
    }
}
