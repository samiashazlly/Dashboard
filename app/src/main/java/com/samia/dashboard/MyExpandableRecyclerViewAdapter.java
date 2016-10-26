package com.samia.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.List;

/**
 * Created by Samia on 10/26/2016.
 */


public class MyExpandableRecyclerViewAdapter extends ExpandableRecyclerAdapter<MyParentViewHolder, MyChildViewHolder> {

    private LayoutInflater mInflator;

    public MyExpandableRecyclerViewAdapter(Context context, @NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
    }

    // onCreate ...
    @Override
    public MyParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View parentView = mInflator.inflate(R.layout.custom_row, parentViewGroup, false);
        return new MyParentViewHolder(parentView);
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View ingredientView = mInflator.inflate(R.layout.custom_child_row, childViewGroup, false);
        return new MyChildViewHolder(ingredientView);
    }

    // onBind ...
    @Override
    public void onBindParentViewHolder(MyParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ItemInfo parent = (ItemInfo) parentListItem;
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder childViewHolder, int position, Object childListItem) {
        ChildItemInfo child = (ChildItemInfo) childListItem;
        childViewHolder.bind(child);
    }
}

class MyParentViewHolder extends ParentViewHolder {

    TextView title;
    ImageView icon;
    ImageView arrow;

    public MyParentViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.item_title);
        icon = (ImageView) itemView.findViewById(R.id.item_icon);
        arrow = (ImageView)itemView.findViewById(R.id.arrow_icon);
    }

    public void bind(ItemInfo parentItem) {
        title.setText(parentItem.getTitle());
        icon.setImageResource(parentItem.getItemId());
        arrow.setImageResource(parentItem.getArrowId());
    }
}

class MyChildViewHolder extends ChildViewHolder {

    private TextView childTitle;

    public MyChildViewHolder(View itemView) {
        super(itemView);
        childTitle = (TextView) itemView.findViewById(R.id.child_title);
    }

    public void bind(ChildItemInfo child) {
        childTitle.setText(child.getTitle());
    }
}

