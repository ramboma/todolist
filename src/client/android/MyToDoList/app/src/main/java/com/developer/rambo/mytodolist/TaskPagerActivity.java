package com.developer.rambo.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Administrator on 2017-06-26.
 */

public class TaskPagerActivity extends FragmentActivity {
    private static final String EXTRA_TASK_ID="com.rambo.mytodolist.task_id";
    private ViewPager mViewPager;
    private List<Task> mTasks;
    public static Intent newIntent(Context packageContext, int taskId)
    {
        Intent intent=new Intent(packageContext,TaskPagerActivity.class);
        intent.putExtra(EXTRA_TASK_ID,taskId);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        int taskid=(int)getIntent().getSerializableExtra(EXTRA_TASK_ID);
        mViewPager=(ViewPager)findViewById(R.id.activity_task_pager_view_pager);
        mTasks=TaskLab.get(this).getTaskList();

        FragmentManager fragementManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragementManager) {
            @Override
            public Fragment getItem(int position) {
                Task task=mTasks.get(position);
                return TaskFragment.newInstance(task.getTaskID());
            }

            @Override
            public int getCount() {
                return mTasks.size();
            }
        });
        for(int i=0;i<mTasks.size();i++)
        {
            if(mTasks.get(i).getTaskID()==taskid)
            {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
