package com.EscowichFernandezGayoso.apptpnro1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CategoryViewHolder extends RecyclerView.Adapter<CategoryViewHolder.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private categoriaClickListener _categoriaListener;

    // data is passed into the constructor
    CategoryViewHolder(Context context, List<String> data, categoriaClickListener categoriaListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this._categoriaListener=categoriaListener;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fila_cat, parent, false);
        return new ViewHolder(view, _categoriaListener);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        categoriaClickListener categoriaListener;
        public ViewHolder(View itemView, categoriaClickListener categoriaListener) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.rowName);
            this.categoriaListener=categoriaListener;
           /* itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                   // Toast.makeText(itemView.getContext(), "Clickeaste el: "+mData.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                    Intent intentResultado = new Intent();
                    intentResultado.putExtra("categoria",mData.get(getAdapterPosition()));
                    setResult(Activity.RESULT_OK, intentResultado);
                    finish();
                }
            });*/
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            categoriaListener.categoriaClick(getAdapterPosition());
        }


    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface categoriaClickListener{
        void categoriaClick(int posicion);
    }

}