package vn.asiantech.training.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.training.R;
import vn.asiantech.training.model.Contact;

/**
 * Created by phuong on 22/11/2016.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder> {
    private Context mContext;
    private List<Contact> mContacts;
    private callBackContactLister mCallBackContactLister;
    private Activity activity;

    public ContactListAdapter(Context context, List<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_contact, parent, false);
        mCallBackContactLister = (ContactListAdapter.callBackContactLister) parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Contact contact = mContacts.get(position);
        holder.tvName.setText(contact.getmName());
        holder.tvPhone.setText(contact.getmPhone());

        holder.imvStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCallBackContactLister != null) {
                    mCallBackContactLister.listenerAddFavourite(contact);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public interface callBackContactLister {
        void listenerAddFavourite(Contact contact);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvPhone;
        public ImageView imvStar;

        public MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvPhone = (TextView) view.findViewById(R.id.tvPhone);
            imvStar = (ImageView) view.findViewById(R.id.imvStar);
        }
    }
}
