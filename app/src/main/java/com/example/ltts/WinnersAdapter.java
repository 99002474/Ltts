package com.example.ltts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WinnersAdapter extends RecyclerView.Adapter<WinnersAdapter.WinnersViewHolder>{

    String data1[],data2[];
    int images[];
    Context context;
    public WinnersAdapter(Context ct,String s1[],String s2[], int img[]){
    context = ct;
    data1 = s1;
    data2 = s2;
    images = img;
    }
    @NonNull
    @Override
    public WinnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.winners_row,parent,false);
        return new WinnersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WinnersViewHolder holder, int position) {
    holder.myText1.setText(data1[position]);
    holder.myText2.setText(data2[position]);
    holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class WinnersViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2;
        ImageView myImage;
        public WinnersViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.Winners_list);
            myText2 = itemView.findViewById(R.id.Winners_description);
            myImage = itemView.findViewById(R.id.Winners_images);
        }
    }
}
