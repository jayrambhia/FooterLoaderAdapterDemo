package com.fenchtose.footerloaderadapterdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fenchtose.footerloaderadapterdemo.adapters.FooterLoaderAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by elanicdroid on 28/10/15.
 */
public class DemoAdapter extends FooterLoaderAdapter<User> {

    public DemoAdapter(Context context) {
        super(context);
    }

    @Override
    public long getYourItemId(int position) {
        return mItems.get(position).getId();
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        return new DemoViewHolder(mInflater.inflate(R.layout.user_item_layout, parent, false));
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DemoViewHolder) {
            DemoViewHolder viewHolder = (DemoViewHolder)holder;
            viewHolder.mUsernameView.setText(mItems.get(position).getUsername());
        }
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.username_view) TextView mUsernameView;

        public DemoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
