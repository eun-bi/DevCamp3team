package com.example.user.devcamp3team.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.devcamp3team.R;
import com.example.user.devcamp3team.Activity.dummy.DummyContent;
import com.example.user.devcamp3team.Activity.dummy.DummyContent.DummyItem;

import java.util.ArrayList;


public class NotifyFragment extends Fragment {

    private ArrayList<NotifyList> notifyLists = new ArrayList<>();
    private RecyclerView notity_List;
    public static NotifyListAdapter notifyListAdapter;      // 구현 위주 (수정
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("create","");
//        notifyListAdapter = new NotifyListAdapter();
//        mLinearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
//
//        notity_List.setAdapter(notifyListAdapter);
//        notity_List.setLayoutManager(mLinearLayoutManager);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        notifyListAdapter = new NotifyListAdapter(getContext(),notifyLists);
        mLinearLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());



        notity_List.setAdapter(notifyListAdapter);
        notity_List.setLayoutManager(mLinearLayoutManager);

        notifyListAdapter.notifyDataSetChanged();

//        notifyLists.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState==null){
            View view = inflater.inflate(R.layout.fragment_notify, container, false);
            initView(view);
            Log.d("fragment","new");

            return view;
        }
        notifyListAdapter.notifyDataSetChanged();

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    private void initView(View view) {
        notity_List = (RecyclerView)view.findViewById(R.id.Notify_list_recycler);
    }
}
