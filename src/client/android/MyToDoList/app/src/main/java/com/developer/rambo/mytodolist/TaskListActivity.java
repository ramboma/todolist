package com.developer.rambo.mytodolist;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017-06-22.
 */

public class TaskListActivity extends SimpleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
}
