package com.praveen;
import java.text.ParseException;
import java.util.*;


import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner in=new Scanner(System.in);
        List<task> al=new ArrayList<task>();

        TaskManager c=new TaskManager();
        while(true) {
            System.out.print("------------\nMenu\n1.Add\n2.Display\n3.Delete\n4.Search\n5.List By Status\n6.Exit\n");
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
                case 5:
                    System.out.println("Enter Status:");
                    taskStatus s=taskStatus.valueOf(in.next());
                    c.listByStatus(s,al);
                    break;
                case 6:exit(0);
                default:System.out.println("Invalid Input");
            }
        }
    }
}



