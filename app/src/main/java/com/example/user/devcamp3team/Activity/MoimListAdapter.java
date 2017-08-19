package com.example.user.devcamp3team.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.devcamp3team.R;

import java.util.ArrayList;

/**
 * Created by User on 2017-08-20.
 */

public class MoimListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Context mContext;
    private ArrayList<MoimItem> moimItems = new ArrayList<>();

    public MoimListAdapter(){}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        final View view = LayoutInflater.from(mContext).inflate(R.layout.list_moim_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,MainActivity.class);
                mContext.startActivity(intent);
            }
        });
        return new MoimViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final MoimItem moimItem = moimItems.get(position);

        MoimViewHolder viewHolder = (MoimViewHolder)holder;
        viewHolder.txtTitle.setText(moimItem.getTitle());

    }

    /* item count */
    public int getBasicItemCount() {
        return moimItems == null ? 0 : moimItems.size();
    }

    @Override
    public int getItemCount() {
        return getBasicItemCount();
    }


    public void addItem(String title){

        MoimItem moimItem = new MoimItem();

        moimItem.setTitle(title);

        moimItems.add(moimItem);

    }

    public class MoimViewHolder extends RecyclerView.ViewHolder{

        ImageView img_moim;
        TextView txtTitle;

        public MoimViewHolder(View itemView) {
            super(itemView);

            img_moim = (ImageView)itemView.findViewById(R.id.img_moim);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        }
    }


    public class MoimItem {

        String title;
        String description;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
