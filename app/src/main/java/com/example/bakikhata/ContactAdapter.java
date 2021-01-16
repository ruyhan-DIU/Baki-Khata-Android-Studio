package com.example.bakikhata;

import android.content.Context;
import android.content.Intent;
import android.os.UserManager;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private  Context mContext;
    private  List<Contact> contactList;
    private  SelectedUser selectedUser;

    public ContactAdapter(List<Contact> contactList,SelectedUser selectedUser) {
        this.contactList = contactList;
        this.selectedUser = selectedUser;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ContactViewHolder(LayoutInflater.from(mContext).inflate(R.layout.items_contact, null));

    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.name_contact.setText(contact.getName());
        holder.phone_contact.setText(contact.getPhone());
        if (contact.getPhoto() != null){
            Picasso.get().load(contact.getPhoto()).into(holder.img_contact);
        }
        else {
            holder.img_contact.setImageResource(R.drawable.contact_image);
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public interface SelectedUser{
        void selectedUser (Contact contact);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name_contact, phone_contact;
        CircleImageView img_contact;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   selectedUser.selectedUser(contactList.get(getAdapterPosition()));
                }
            });
            name_contact = itemView.findViewById(R.id.name_contact);
            phone_contact = itemView.findViewById(R.id.phone_contact);
            img_contact = itemView.findViewById(R.id.img_contact);
        }
    }



    public void filterList(ArrayList<Contact> filteredList){
        contactList = filteredList;
        notifyDataSetChanged();
    }

}
