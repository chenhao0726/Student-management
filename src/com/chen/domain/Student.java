package com.chen.domain;

import java.util.Date;

public class Student {

    private Long id;
    private String name;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private String address;
    private Long class_id;
    private String className;

    public Student() {
    }

    public Student(Long id, String name, String password, Integer age, Integer gender, String phone, String address, Long class_id ,String className) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.class_id = class_id;
        this.className = className;
    }

    public Student(String name, String password, Integer age, Integer gender, String phone, String address, Long class_id ,String className) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.class_id = class_id;
        this.className = className;
    }

    public Student(Long id, String name, String password, Integer age, Integer gender, String phone, String address, Long class_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.class_id = class_id;
    }

    public Student(String name, String password, Integer age, Integer gender, String phone, String address, Long class_id) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.class_id = class_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", class_id=" + class_id +
                ", className='" + className + '\'' +
                '}';
    }
}
