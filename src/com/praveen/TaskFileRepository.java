package com.praveen;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskFileRepository implements TaskRepository {
    private static final String TASKS_JSON_FILE = "/home/praveenc/IdeaProjects/Task Manegement/src/com/praveen/tasks.json";

    private ObjectMapper objectMapper = new ObjectMapper();

    List<Task> tasks;
    File file = new File(TASKS_JSON_FILE);

    public TaskFileRepository() {
        tasks=readFromFile();
    }

    private void writeToFile(List<Task> tasks) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new FileWriter(TASKS_JSON_FILE), tasks);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private List<Task> readFromFile() {
        if (file.exists()) {
            try {
                return objectMapper.readValue(file, TaskList.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        writeToFile(tasks);
    }

    @Override
    public boolean deleteFromList(int taskId) {
        for(Task task: tasks) {
            if (task.getId()==taskId) {
                tasks.remove(task);
                writeToFile(tasks);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Task> getList() {
        return readFromFile();
    }

    @Override
    public Task searchById(int taskId) {
        for(Task task: tasks) {
            if (task.getId()==taskId) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<Task> listByStatus(TaskStatus status) {
        List<Task> listOfStatus=new ArrayList<Task>();
        for(Task task: tasks){
            if(task.getStatus().equals(status))
                listOfStatus.add(task);
        }
        return listOfStatus;
    }

    @Override
    public int getTotalTasks() {
        return tasks.size();
    }

    @Override
    public void updateStatus(TaskStatus status, int taskId) {
        for(Task task: tasks){
            if(task.getId()==taskId){
                task.setStatus(status);
                writeToFile(tasks);
            }
        }
    }
}
