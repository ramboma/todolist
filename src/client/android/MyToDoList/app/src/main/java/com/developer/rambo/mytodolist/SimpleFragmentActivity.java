package com.developer.rambo.mytodolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Administrator on 2017-06-22.
 */

public abstract class SimpleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if(fragment==null)
        {
            fragment=createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }
}
