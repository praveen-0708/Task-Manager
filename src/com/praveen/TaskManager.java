package com.praveen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class TaskManager{
    Scanner in=new Scanner(System.in);

    public task input() throws ParseException {
        System.out.println("Enter task name:");
        String name=in.nextLine();
        System.out.println("Enter description:");
        String description=in.nextLine();
        System.out.println("Enter date(dd/MM/yyyy):");
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
        System.out.println("Enter status(CREATED,IN_PROGRESS,DONE):");
        taskStatus s=taskStatus.valueOf(in.nextLine());
        task n=new task(name,description,date,s);
        return n;
    }

    public void add(task n, List<task> al){
        al.add(n);
    }
    public void delete(String name,List<task> al){
        for(task i:al) {
            if (i.getName().equals(name)) {
                al.remove(i);
                break;
            }
        }
    }
    public void display(List<task> al){

        for(task s:al){
            System.out.println(s);
        }
    }
    public boolean search(String name,List<task> al){

        for(task s:al) {
            if (s.getName().equals(name)) {
                System.out.println(s);
                return true;
            }
        }
        return false;
    }
    public void listByStatus(taskStatus s,List<task> al){
        for(task i:al){
            if(i.getStatus().equals(s))
                System.out.println(i);
        }
    }
}