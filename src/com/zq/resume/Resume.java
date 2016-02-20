package com.zq.resume;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/3
 * Time: 20:04
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class Resume {

    public static void main(String[] args) {

        Resume resume = new Resume();

        //���˻�����Ϣ
        resume.setName(" ֣  ǿ ")
                .setAge(23)
                .setGender("��")
                .setLocation("�㶫������")
                .setPoliticalStatus("�й���Ա")
                .setHighestAcademic("˶ʿ")
                .setUniversity("��ɽ��ѧ")
                .setPhoneNumber("15626234928")
                .setEmail("601097836@qq.com")
                .setWorkExperience("Ӧ���ҵ����������")
                .setHomePage("http://www.thinerzq.me")
                .setGitHub("https://www.github.com/ThinerZQ")
                .setJobIntention("java����")
                .setHobby(new String[]{"����", "����", "��ë��", "����", "�Ķ�", "��Ӱ", "����", "�ֻ�", "����"})
                .setCertificate(new String[]{"Ӣ������", "������ʦ"})
                .setSelfEvaluation("����һ��ѧϰ����ǿ��" +
                        "��������������桢" +
                        "�ܶ���������⡢" +
                        "�������ġ�" +
                        "�������˹�ͨ��" +
                        "�Ȱ��˶���" +
                        "�Ȱ��������������")
                .setSelfDescription("�о����ڼ���о�������״̬����������" +
                        "Ŀǰ���ݿ�Դ��ĿApache Commons SCXML��д��һ��״̬������������BOWorkflow��" +
                        "��һֱ��ά����" +
                        "ͬʱ��ѧ��һ��ʱ��Andriod������" +
                        "�������ھ��ر����Ȥ��");


        //���˽�������
        EducationExperience university = new EducationExperience();
        university.setBeginDate(LocalDate.of(2010, 9, 30))
                .setEndDate(LocalDate.of(2014, 6, 17))
                .setUniversity("������ѧԺ")
                .setMajor("�������")
                .setDegree("����");
        EducationExperience postgraduate = new EducationExperience();
        postgraduate.setBeginDate(LocalDate.of(2014, 8, 23))
                .setEndDate(LocalDate.now())
                .setUniversity("��ɽ��ѧ")
                .setMajor("�������")
                .setDegree("˶ʿ");

        //����У԰����
        CampusActivity ccnaTrain = new CampusActivity();
        ccnaTrain.setActivityBeginDate(LocalDate.of(2012, 7, 10))
                .setActivityEndDate(LocalDate.of(2012, 8, 23))
                .setActivityName("˶��CCNA��ѵ")
                .setActivityDescription("�����ѵ������˶�蹫˾��ѧУ������" +
                        "����ṩ��" +
                        "����������ù�˾�Ĵ���·�����ͽ����������һ��С�;������Ĵ.");

        CampusActivity studentUnion = new CampusActivity();
        studentUnion.setActivityBeginDate(LocalDate.of(2012, 9, 5))
                .setActivityEndDate(LocalDate.of(2013, 9, 28))
                .setActivityName("Ժѧ����ѧϰ������")
                .setActivityDescription("����Ժѧ����ѧϰ��������" +
                        "��ξ����̻����Һܶ�����" +
                        "һ����������Լ�Ϊ�˴��µ�������" +
                        "���������˹�ͨ�ļ��ɣ�" +
                        "��һ����Ҳ�������ҵ������ġ�");

        CampusActivity familyEducation = new CampusActivity();
        familyEducation.setActivityBeginDate(LocalDate.of(2015,5,14))
                .setActivityEndDate(LocalDate.now())
                .setActivityName("C���Լҽ�")
                .setActivityDescription("����ĳ��������C���Խ�ѧ��");

        //���˻����
        Award softwareDesignAward = new Award();
        softwareDesignAward.setAwardDate(LocalDate.of(2013, 7, 28))
                .setAwardName("Ժϵ�����ƴ���һ�Ƚ�");

        Award nationalEncouragementScholarship = new Award();
        nationalEncouragementScholarship.setAwardDate(LocalDate.of(2013, 10, 11))
                .setAwardName("������־��ѧ��");

        Award schoolAward = new Award();
        schoolAward.setAwardDate(LocalDate.of(2015, 10, 16))
                .setAwardName("��ɽ��ѧ���Ƚ�ѧ��");

        //������Ŀ����
        ProjectExperience personalManagementSystem = new ProjectExperience();
        personalManagementSystem.setProjectBeginDate(LocalDate.of(2013, 3, 1))
                .setProjectEndDate(LocalDate.of(2013, 5, 28))
                .setProjectName("���¹���ϵͳ")
                .setProjectPosition("������")
                .setProjectDescription("���ǡ�������̡�������ʦ�����һ����Ŀ��" +
                        "���ҵ���С�鳤��" +
                        "�����ʦ�����һϵ��ϡ��Źֵ���Ҫ��ҳ������Ҫ���õĵ�Ajax�����ͷḻ��Jquery������������" +
                        "����һ��web���¹���ϵͳ��" +
                        "�����ջ���˰༶��һ��");

        ProjectExperience onlineShop = new ProjectExperience();
        onlineShop.setProjectBeginDate(LocalDate.of(2013, 7, 2))
                .setProjectEndDate(LocalDate.of(2013, 7, 30))
                .setProjectName("�����������̳�")
                .setProjectPosition("����ָ��")
                .setProjectDescription("��������2013�����ʵѵ����һ����Ŀ��" +
                        "��Ҫ������Ǳ�дһ�������̳ǣ�" +
                        "����ģ����è��ҳ��" +
                        "ʵ����һ��С�͵������̳ǣ�" +
                        "�����ջ����Ժϵһ�Ƚ���");

        ProjectExperience retiredStaffManagementSystem = new ProjectExperience();
        retiredStaffManagementSystem.setProjectBeginDate(LocalDate.of(2014,4,1))
                .setProjectEndDate(LocalDate.of(2013, 6, 22))
                .setProjectName("������������Ա����ϵͳ")
                .setProjectPosition("������")
                .setProjectDescription("�����ұ��Ƶı�ҵ��ƣ�" +
                        "������Ŀ����SSH2�ܹ���" +
                        "��Ҫ��������������Ա����Ϣ����")
                .setProjectDifficulties(new ArrayList<String>() {{
                    add("����������ɨ����鵵");
                    add("����������Ԥ��");
                }});

        Skill windows = new Skill();



        List<EducationExperience> educationExperiences = new LinkedList<>();
        educationExperiences.add(postgraduate);
        educationExperiences.add(university);

        List<CampusActivity> campusActivities = new LinkedList<>();
        campusActivities.add(ccnaTrain);
        campusActivities.add(studentUnion);
        campusActivities.add(familyEducation);

        List<Award> awards = new LinkedList<>();
        awards.add(softwareDesignAward);
        awards.add(nationalEncouragementScholarship);
        awards.add(schoolAward);

        List<ProjectExperience> projectExperiences  = new LinkedList<>();
        projectExperiences.add(personalManagementSystem);
        projectExperiences.add(onlineShop);
        projectExperiences.add(retiredStaffManagementSystem);


        resume.setEducationExperiences(educationExperiences)
                .setCampusActivities(campusActivities)
                .setAwardses(awards)
                .setProjectExperiences(projectExperiences);





        System.out.println(resume);
    }

    private String name;
    private int age;
    private String gender;
    private String location;
    private String politicalStatus;
    private String highestAcademic;
    private String university;
    private String phoneNumber;
    private String email;
    private String workExperience;
    private String homePage;
    private String gitHub ;
    private String jobIntention;
    private String[] hobby;
    private String[] certificate;
    private String selfEvaluation;
    private String selfDescription;
    private List<EducationExperience> educationExperiences;
    private List<CampusActivity> campusActivities;
    private List<Award> awardses;
    private List<ProjectExperience> projectExperiences;
    private List<Skill> skills;


    @Override
    public String toString() {
        return "Resume{\n" +
                "\t name='" + name + "\'\n" +
                "\t age=" + age + "\n"+
                "\t gender='" + gender + "\'\n" +
                "\t location='" + location + "\'\n" +
                "\t politicalStatus='" + politicalStatus + "\'\n" +
                "\t highestAcademic='" + highestAcademic + "\'\n" +
                "\t university='" + university + "\'\n" +
                "\t phoneNumber='" + phoneNumber + "\'\n" +
                "\t email='" + email +"\'\n" +
                "\t workExperience='" + workExperience +"\'\n" +
                "\t homePage='" + homePage +"\'\n" +
                "\t gitHub='" + gitHub + "\'\n" +
                "\t jobIntention='" + jobIntention + "\'\n" +
                "\t hobby=" + Arrays.toString(hobby) +"\n"+
                "\t certificate=" + Arrays.toString(certificate) +"\n"+
                "\t selfEvaluation='" + selfEvaluation + "\'\n" +
                "\t selfDescription='" + selfDescription + "\'\n" +
                "\t educationExperiences=" + educationExperiences +"\n"+
                "\t campusActivities=" + campusActivities +"\n"+
                "\t awardses=" + awardses +"\n"+
                "\t projectExperiences=" + projectExperiences +"\n"+
                "\t skills=" + skills +"\n"+
                '}';
    }

    public String getName() {
        return name;
    }

    public Resume setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Resume setAge(int age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Resume setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Resume setLocation(String location) {
        this.location = location; return this;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public Resume setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus; return this;
    }

    public String getHighestAcademic() {
        return highestAcademic;
    }

    public Resume setHighestAcademic(String highestAcademic) {
        this.highestAcademic = highestAcademic; return this;
    }

    public String getUniversity() {
        return university;
    }

    public Resume setUniversity(String university) {
        this.university = university; return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Resume setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber; return this;
    }

    public String getEmail() {
        return email;
    }

    public Resume setEmail(String email) {
        this.email = email; return this;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public Resume setWorkExperience(String workExperience) {
        this.workExperience = workExperience; return this;
    }

    public String getHomePage() {
        return homePage;
    }

    public Resume setHomePage(String homePage) {
        this.homePage = homePage; return this;
    }

    public String getGitHub() {
        return gitHub;
    }

    public Resume setGitHub(String gitHub) {
        this.gitHub = gitHub; return this;
    }

    public String getJobIntention() {
        return jobIntention;
    }

    public Resume setJobIntention(String jobIntention) {
        this.jobIntention = jobIntention; return this;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public Resume setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription; return this;
    }

    public String[] getHobby() {
        return hobby;
    }

    public Resume setHobby(String[] hobby) {
        this.hobby = hobby; return this;
    }

    public String[] getCertificate() {
        return certificate;
    }

    public Resume setCertificate(String[] certificate) {
        this.certificate = certificate; return this;
    }

    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public Resume setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation; return this;
    }

    public List<EducationExperience> getEducationExperiences() {
        return educationExperiences;
    }

    public Resume setEducationExperiences(List<EducationExperience> educationExperiences) {
        this.educationExperiences = educationExperiences;
        return this;
    }

    public List<CampusActivity> getCampusActivities() {
        return campusActivities;
    }

    public Resume setCampusActivities(List<CampusActivity> campusActivities) {
        this.campusActivities = campusActivities; return this;
    }

    public List<Award> getAwardses() {
        return awardses;
    }

    public Resume setAwardses(List<Award> awardses) {
        this.awardses = awardses; return this;
    }

    public List<ProjectExperience> getProjectExperiences() {
        return projectExperiences;
    }

    public Resume setProjectExperiences(List<ProjectExperience> projectExperiences) {
        this.projectExperiences = projectExperiences; return this;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Resume setSkills(List<Skill> skills) {
        this.skills = skills; return this;
    }
}
