package com.samia.dashboard;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView gridRecyclerView;
    private RecyclerView linearRecyclerView;
    private GridRecyclerViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ///////////Navigation Drawer////////////////////
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ////////////////Grid Recycler View//////////////////
        gridRecyclerView = (RecyclerView) findViewById(R.id.grid_recycler_view);
        gridAdapter = new GridRecyclerViewAdapter(this, setGridData());
        gridRecyclerView.setAdapter(gridAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridRecyclerView.setLayoutManager(gridLayoutManager);
        gridRecyclerView.addItemDecoration(new DividerItemDecoration(gridRecyclerView.getContext(),
                0));
        gridRecyclerView.addItemDecoration(new DividerItemDecoration(gridRecyclerView.getContext(),
                1));
        ////////////////Expandable Linear Recycler View//////////////////
        linearRecyclerView = (RecyclerView) findViewById(R.id.linear_recycler_view);
        MyExpandableRecyclerViewAdapter myAdapter = new
                MyExpandableRecyclerViewAdapter(this, setLinearData());
        linearRecyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        linearRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(linearRecyclerView.getContext(),
                layoutManager.getOrientation());
        linearRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    private List<ItemInfo> setGridData() {
        List<ItemInfo> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_image, R.drawable.ic_music, R.drawable.ic_camera,
                R.drawable.ic_video, R.drawable.ic_setting, R.drawable.ic_contact,
                R.drawable.ic_inbox, R.drawable.ic_card, R.drawable.ic_more};
        String[] titles = {"Image", "Music", "Camera", "Video", "Setting",
                "Contact", "Inbox", "Card", "More"};

        for (int i = 0; i < icons.length && i < titles.length; i++) {
            ItemInfo current = new ItemInfo();
            current.itemId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    private List<ItemInfo> setLinearData() {
        List<ItemInfo> data = new ArrayList<>();
        ChildItemInfo child1 =new ChildItemInfo();
        child1.title="child 1";
        ChildItemInfo child2 =new ChildItemInfo();
        child2.title="child 2";
        List<ChildItemInfo> childs = Arrays.asList(child1, child2);
        int[] icons = {R.drawable.ic_word_press, R.drawable.ic_google_plus, R.drawable.ic_facebook};
        String[] titles = {"WordPress Blog", "Google Connect",
                "Facebook Connect"};

        for (int i = 0; i < icons.length && i < titles.length; i++) {
            ItemInfo current = new ItemInfo();
            current.itemId = icons[i];
            current.title = titles[i];
            current.childItems = childs;
            current.arrowId = R.drawable.ic_arrow_right;
            data.add(current);
        }
        return data;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
