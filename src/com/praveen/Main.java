package com.praveen;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner in=new Scanner(System.in);
        List<task> al=new ArrayList<task>();

        functions c=new functions();
        while(true) {
            System.out.print("------------\nMenu\n1.Add\n2.Display\n3.Delete\n4.Search\n5.Exit\n");
            System.out.println("Enter choice:");
            int k=in.nextInt();
            switch (k) {
                case 1:
                    task n=c.input();
                    c.add(n, al);
                    break;
                case 2:
                    c.display(al);
                    break;
                case 3:
                    System.out.println("Enter task name to delete:");
                    String name=in.next();
                    c.delete(name, al);
                    break;
                case 4:
                    System.out.println("Enter task name to search:");
                    if(!c.search(in.next(), al))
                        System.out.println("Not Found");

                    break;
                case 5:exit(0);
                default:System.out.println("Invalid Input");
            }
        }
    }
}


class functions{
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

    public void add(task n,List<task> al){
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
}
