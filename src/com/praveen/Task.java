package com.praveen;

import java.text.SimpleDateFormat;
import java.util.Date;

class Task {
    private int id;
    private String name;
    private String description;
    private Date date;
    private TaskStatus status;

    public Task(int id, String name, String description, Date date, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
        return "ID:"+getId()+"\nName:"+getName()+"\nDescription:"+getDescription()+"\nDate:"+sf.format(getDate())+"\nStatus:"+getStatus()+"\n";
    }
}
