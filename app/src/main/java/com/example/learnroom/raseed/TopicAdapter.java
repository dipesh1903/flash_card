package com.example.learnroom.raseed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.learnroom.raseed.Entity.Topics;
import com.example.learnroom.raseed.Entity.User;

import java.util.List;
import java.util.zip.Inflater;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewAdapter> {

    private ClickListener clickListener;
    private LayoutInflater inflate;
    private List<Topics> topics;
    TopicAdapter(Context context) {
        inflate = LayoutInflater.from(context);

    }

    void setWords(List<Topics> topics){
        this.topics = topics;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TopicAdapter.TopicViewAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = inflate.inflate(R.layout.cards, viewGroup, false);
        return new TopicAdapter.TopicViewAdapter(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicAdapter.TopicViewAdapter topicViewAdapter, int i) {

        Topics current = topics.get(i);
        topicViewAdapter.tv.setText(current.topic_name);

    }

    @Override
    public int getItemCount() {
        return topics.size();
    }
    public void setOnItemClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
     class TopicViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private ClickListener clickListener;
        public TextView tv;
        public TopicAdapter adapter;
        public TopicViewAdapter(@NonNull View itemView, ClickListener listener) {
            super(itemView);
            tv = itemView.findViewById(R.id.topic_text);
            itemView.setOnClickListener(this);
            this.clickListener = listener;

        }

         @Override
         public void onClick(View v) {
                clickListener.onItemCLick(getAdapterPosition(),v);
         }

         @Override
         public boolean onLongClick(View v) {
             clickListener.onLongItemClick(getAdapterPosition(),v);
             return false;
         }
     }
}
