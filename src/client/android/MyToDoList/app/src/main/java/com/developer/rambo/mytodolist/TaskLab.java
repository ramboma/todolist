package com.developer.rambo.mytodolist;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-06-22.
 */

public class TaskLab {
    private static TaskLab sTaskLab;
    private List<Task> lstTaskList;
    public static TaskLab get(Context context)
    {
        if(sTaskLab==null)
        {
            sTaskLab=new TaskLab(context);
        }
        return sTaskLab;
    }
    private TaskLab(Context context)
    {
        lstTaskList=new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            Task t=new Task();
            t.setTaskID(i);
            t.setTaskTitle("task#"+i);
            t.setSolved((i%2)==0);
            lstTaskList.add(t);
        }
    }
    public List<Task> getTaskList()
    {
        return lstTaskList;
    }
    public Task getTaskById(int taskid)
    {
        for(Task task :lstTaskList)
        {
            if(task.getTaskID()==taskid)
            {
                return task;
            }
        }
        return null;
    }
}
