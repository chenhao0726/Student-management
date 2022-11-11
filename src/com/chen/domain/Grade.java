package com.chen.domain;

public class Grade {
    private Long id;
    private String className;

    public Grade() {
    }

    public Grade(Long id, String className) {
        this.id = id;
        this.className = className;
    }

    public Grade(String className) {
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
