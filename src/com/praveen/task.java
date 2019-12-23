package com.praveen;

import java.text.SimpleDateFormat;
import java.util.Date;
enum taskStatus{
    CREATED,IN_PROGRESS,DONE;
}

class task{
    private String name;
    private String description;
    private Date date;
    private taskStatus status;


    public task(String name, String description, Date date, taskStatus status) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public taskStatus getStatus() {
        return status;
    }

    public void setStatus(taskStatus status) {
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
        return "Name:"+getName()+"\nDescription:"+getDescription()+"\nDate:"+sf.format(getDate())+"\nStatus:"+getStatus()+"\n";
    }
}
