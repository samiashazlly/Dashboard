package com.samia.dashboard;


import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

public class ItemInfo implements ParentListItem {
    private int itemId;
    private int arrowId;
    private String title;
    private List childItems;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getArrowId() {
        return arrowId;
    }

    public void setArrowId(int arrowId) {
        this.arrowId = arrowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getChildItems() {
        return childItems;
    }

    public void setChildItems(List childItems) {
        this.childItems = childItems;
    }

    @Override
    public List getChildItemList() {
        return childItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
