package com.developer.rambo.mytodolist;

import java.util.Date;

/**
 * Created by Administrator on 2017-06-21.
 */

public class Task {
    private int taskID;
    private String taskTitle;
    private Date taskDelayTime;
    private boolean isSolved;
    public Task()
    {
        taskDelayTime=new Date();
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }


    public Date getTaskDelayTime() {
        return taskDelayTime;
    }
    public void setTaskDelayTime(Date date)
    {
        taskDelayTime=date;
    }
}
