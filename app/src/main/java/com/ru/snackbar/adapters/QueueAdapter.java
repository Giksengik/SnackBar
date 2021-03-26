package com.ru.snackbar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.snackbar.R;
import com.ru.snackbar.models.products.IProduct;

import java.util.ArrayList;
import java.util.List;

public class QueueAdapter extends RecyclerView.Adapter<QueueAdapter.ViewHolder>  {
    List<String> persons = new ArrayList<>();
    @NonNull
    @Override
    public QueueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.queue_in_list, parent, false);
        return new QueueAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QueueAdapter.ViewHolder holder, int position) {
        String person = persons.get(position);
        holder.personName.setText(person);
    }
    public void setPersons(List<String> persons) {
        this.persons = persons;
    }
    @Override
    public int getItemCount() {
        return persons.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView personName;
        ViewHolder(View v){
            super(v);
            personName = v.findViewById(R.id.personName);
        }
    }
}
