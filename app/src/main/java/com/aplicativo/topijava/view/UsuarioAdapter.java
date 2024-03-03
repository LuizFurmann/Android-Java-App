package com.aplicativo.topijava.view;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.aplicativo.topijava.R;
import com.aplicativo.topijava.databinding.ItemLayoutBinding;
import com.aplicativo.topijava.model.Data;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UserViewHolder> implements Filterable{

    private List<Data> listItems;
    private List<Data> filteredListItems;

    Context context;

    public void setListItems(List<Data> listItems){
        this.listItems = listItems;
        filteredListItems = new ArrayList<>(listItems);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemBinding = ItemLayoutBinding .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
         Data currentPosition = listItems.get(position);

        holder.name.setText(currentPosition.getName());
        holder.description.setText(currentPosition.getDescription());
        holder.forks.setText(currentPosition.getForsk());
        holder.stargazers_count.setText(currentPosition.getStargazers_count());
        holder.full_name.setText(currentPosition.getFull_name());
        Glide.with(holder.avatar_image)
                .load(currentPosition.getOwner().getAvatar_url())
                .into(holder.avatar_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, RepoDetailsActivity.class);
                myIntent.putExtra("repo", currentPosition);
                myIntent.putExtra("imgProfile", currentPosition.getOwner());
                context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listItems == null)
            return 0;
        else
            return listItems.size();
    }

    //Filter method
    @Override
    public Filter getFilter() {
        return FilterUser;
    }
    private Filter FilterUser = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String searchText = charSequence.toString().toLowerCase();
            List<Data>newList = new ArrayList<>();
            if(searchText.length()==0 || searchText.isEmpty()){
                newList.addAll(filteredListItems);
            }else{
                for(Data item: filteredListItems){
                    if(item.getName().toLowerCase().contains(searchText)){
                        newList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = newList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            listItems.clear();
            listItems.addAll((Collection<? extends Data>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView avatar_image;
        TextView name;
        TextView description;
        TextView forks;
        TextView stargazers_count;
        TextView full_name;
        TextView login;

        public UserViewHolder(@NonNull ItemLayoutBinding binding) {
            super(binding.getRoot());

            avatar_image = binding.avatarImage;
            name = binding.name; itemView.findViewById(R.id.name);
            description = binding.description; itemView.findViewById(R.id.description);
            forks = binding.forks; itemView.findViewById(R.id.forks);
            stargazers_count = binding.star; itemView.findViewById(R.id.star);
            full_name = binding.fullName; itemView.findViewById(R.id.fullName);
        }
    }
}
