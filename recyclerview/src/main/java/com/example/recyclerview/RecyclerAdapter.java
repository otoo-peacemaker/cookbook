package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Item_model_class> pojoClass;

    //constructor
    public RecyclerAdapter(List<Item_model_class> pojoClass){
        this.pojoClass = pojoClass;
    }

    //register the ids of the widgets
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            genre = (TextView) itemView.findViewById(R.id.genre);
            year = (TextView) itemView.findViewById(R.id.year);
        }
    }

    //inflate the your itemList layout
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.items_list,parent,false);
        return new MyViewHolder(view);
    }

    //Bind your pojoClass to the widget: getting items from the pojo class and setting it to the widgets
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item_model_class model_class = pojoClass.get(position);
        holder.title.setText(model_class.getTitle());
        holder.genre.setText((model_class.getGenre()));
        holder.year.setText(model_class.getYear());

    }

    @Override
    public int getItemCount() {
        return pojoClass.size();//return the size of the itemList: pojoClass is from the data field we created in the main class
    }



}
