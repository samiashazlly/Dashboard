package com.samia.dashboard;


import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

public class ItemInfo implements ParentListItem {
    public int itemId;
    public int arrowId;
    public String title;
    public List childItems;



    @Override
    public List getChildItemList() {
        return childItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
