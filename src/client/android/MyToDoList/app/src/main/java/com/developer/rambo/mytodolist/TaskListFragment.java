package com.developer.rambo.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017-06-22.
 */

public class TaskListFragment extends Fragment{

    private RecyclerView mTaskRecyclerView;
    private TaskAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_task_list,container,false);

        mTaskRecyclerView=(RecyclerView)view.findViewById(R.id.task_recycler_view);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }
    private void updateUI()
    {
        TaskLab taskLab=TaskLab.get(getActivity());
        List<Task> tasks=taskLab.getTaskList();
        if(mAdapter==null) {
            mAdapter = new TaskAdapter(tasks);
            mTaskRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Task mTask;
        private TextView mdelayTimeTextView;
        private TextView mTitleTextView;
        private CheckBox mSolvedCheckBox;
        public TaskHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            mdelayTimeTextView=(TextView)itemView.findViewById(R.id.list_item_task_delayTime);
            mTitleTextView=(TextView)itemView.findViewById(R.id.list_item_task_title);
            mSolvedCheckBox=(CheckBox) itemView.findViewById(R.id.list_item_task_solved);


        }
        public void bindTask(Task task)
        {
           mTask=task;
            mdelayTimeTextView.setText(mTask.getTaskDelayTime().toString());
            mTitleTextView.setText(mTask.getTaskTitle());
            mSolvedCheckBox.setChecked(mTask.isSolved());
        }

        @Override
        public void onClick(View v) {
            Intent intent=TaskPagerActivity.newIntent(getActivity(),mTask.getTaskID());
            startActivity(intent);
        }
    }
    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{
        private List<Task> mTasks;
        public TaskAdapter (List<Task> tasks)
        {
            mTasks=tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.list_item_task,parent,false);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            Task task=mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}
