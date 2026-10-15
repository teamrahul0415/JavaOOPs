package com.kiet.student.Model;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String branch;
    private int year;
    private double cgpa;


    public Student(){

    }

    public Student(Long id,String name, String email,String branch,int year,double cgpa){
        this.id=id;
        this.name=name;
        this.email=email;
        this.branch=branch;
        this.year=year;
        this.cgpa=cgpa;
    }

    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }
    public String getBranch(){
        return branch;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getYear(){
        return year;
    }
    public void setCgpa(double cgpa){
        this.cgpa=cgpa;
    }
    public double getCgpa(){
        return cgpa;
    }
    
}
