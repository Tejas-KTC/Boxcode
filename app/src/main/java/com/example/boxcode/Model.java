package com.example.boxcode;

public class Model {
    int id;
    String task_name,task_des,task_starttime,task_endtime;

    public Model(int id, String task_name, String task_des, String task_starttime, String task_endtime) {
        this.id = id;
        this.task_name = task_name;
        this.task_des = task_des;
        this.task_starttime = task_starttime;
        this.task_endtime = task_endtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_des() {
        return task_des;
    }

    public void setTask_des(String task_des) {
        this.task_des = task_des;
    }

    public String getTask_starttime() {
        return task_starttime;
    }

    public void setTask_starttime(String task_starttime) {
        this.task_starttime = task_starttime;
    }

    public String getTask_endtime() {
        return task_endtime;
    }

    public void setTask_endtime(String task_endtime) {
        this.task_endtime = task_endtime;
    }
}
