package com.developer.rambo.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by Administrator on 2017-06-21.
 */

public class TaskFragment extends Fragment {
    public static final String ARG_TASK_ID="ARG_TASK_ID";
    public static final String DIALOG_DATE="delay time";
    private static final int REQUEST_DATE=0;

    private Task mTask;
    private EditText mEditText;
    private Button mDelayBtn;
    private CheckBox mSolvedChk;
    public static TaskFragment newInstance(int taskid)
    {
        Bundle args=new Bundle();
        args.putSerializable(ARG_TASK_ID,taskid);

        TaskFragment fragement=new TaskFragment();
        fragement.setArguments(args);
        return fragement;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int taskid=(int) getArguments().getSerializable(ARG_TASK_ID);
        mTask=TaskLab.get(getActivity()).getTaskById(taskid);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_task,container,false);
        mEditText=(EditText)v.findViewById(R.id.task_title);
        mEditText.setText(mTask.getTaskTitle());
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setTaskTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDelayBtn=(Button)v.findViewById(R.id.task_DelayTime);
        mDelayBtn.setText(mTask.getTaskDelayTime().toString());
        mDelayBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                DatePickerFragment dialog=DatePickerFragment.newInstance(mTask.getTaskDelayTime());
                dialog.setTargetFragment(TaskFragment.this,REQUEST_DATE);
                dialog.show(manager,DIALOG_DATE);
            }
        });

        mSolvedChk=(CheckBox)v.findViewById(R.id.task_solved);
        mSolvedChk.setChecked(mTask.isSolved());
        mSolvedChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTask.setSolved(isChecked);
                if(mTask.isSolved())
                {
                    mDelayBtn.setEnabled(true);
                }
                else
                {
                    mDelayBtn.setEnabled(false);
                }
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode!= Activity.RESULT_OK)
        {
            return;
        }
        if(requestCode==REQUEST_DATE)
        {
            Date date=(Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mTask.setTaskDelayTime(date);
            mDelayBtn.setText(mTask.getTaskDelayTime().toString());
        }

    }
}
