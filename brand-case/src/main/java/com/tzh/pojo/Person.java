package com.tzh.pojo;

public class Person {
    // 员工编号
    private Integer id;
    // 员工姓名
    private String personName;
    // 员工性别
    private String gender;
    // 文化水平
    private String education;
    // 婚姻状况
    private String marriage;
    // 职称
    private String title;
    // 每月工资
    private Integer wages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", gender='" + gender + '\'' +
                ", education='" + education + '\'' +
                ", marriage='" + marriage + '\'' +
                ", title='" + title + '\'' +
                ", wages=" + wages +
                '}';
    }
}




