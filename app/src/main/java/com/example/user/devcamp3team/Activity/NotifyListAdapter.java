package com.example.user.devcamp3team.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.devcamp3team.R;

import java.util.ArrayList;

/**
 * Created by User on 2017-09-24.
 */

public class NotifyListAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private ArrayList<NotifyList> notifyListss = null;


    public NotifyListAdapter(){}

    public NotifyListAdapter(Context context, ArrayList<NotifyList> notifyLists){
        mContext = context;
        notifyListss = notifyLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        final View view = LayoutInflater.from(mContext).inflate(R.layout.list_notify_item, parent, false);
        return new NotifyListAdapter.NotifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final NotifyList notifyList = notifyListss.get(position);

        NotifyViewHolder viewHolder = (NotifyViewHolder)holder;
        viewHolder.txtTitle.setText(notifyList.getTitle());
        viewHolder.txtSub.setText(notifyList.getDescription());

        viewHolder.item_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getApplicationContext(),ScheduleDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    /* item count */
    public int getBasicItemCount() {
        return notifyListss == null ? 0 : notifyListss.size();
    }


    @Override
    public int getItemCount() {
        return getBasicItemCount();
    }

    public void addItem(String title,String description){

        NotifyList notifyitem = new NotifyList();

        notifyitem.setTitle(title);
        notifyitem.setDescription(description);

        Log.d("title",notifyitem.getTitle());
        Log.d("des",notifyitem.getDescription());

        notifyListss.add(notifyitem);
    }


    public class NotifyViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtSub;
        CardView item_notify;

        public NotifyViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView)itemView.findViewById(R.id.txtNotify_name);
            txtSub = (TextView)itemView.findViewById(R.id.txtNotify_Sub);
            item_notify = (CardView)itemView.findViewById(R.id.item_notify);

        }
    }

}