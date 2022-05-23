package com.example.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    ImageView image;
    ImageView bigcircle;
    public ListViewHolder(View item){
        super(item);
        name =item.findViewById(R.id.Name);
        description =item.findViewById(R.id.description);
        image = item.findViewById(R.id.picture4);
        bigcircle = item.findViewById(R.id.bigcircle);
    }


}
