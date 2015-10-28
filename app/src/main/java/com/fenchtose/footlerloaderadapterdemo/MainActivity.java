package com.fenchtose.footlerloaderadapterdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.recyclerview) RecyclerView mRecyclerView;

    private DemoAdapter mAdapter;
    private List<User> mItems;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerViewScrollListener() {
            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onLoadMore() {
                loadMoreData();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupAdapter() {
        mAdapter = new DemoAdapter(this);
        mAdapter.setHasStableIds(true);
        mItems = getData(0);
        mAdapter.setItems(mItems);
    }

    private void loadMoreData() {

        mAdapter.showLoading(true);
        mAdapter.notifyDataSetChanged();

        // Load data after delay
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<User> newItems = getData(mItems.size());
                mItems.addAll(newItems);
                mAdapter.setItems(mItems); // No need of this
                mAdapter.showLoading(false);
                mAdapter.notifyDataSetChanged();
            }
        }, 1500);

    }

    private List<User> getData(int start) {
        List<User> items = new ArrayList<>();
        for (int i=start; i<start+12; i++) {
            items.add(new User(i, "user " + i));
        }

        return items;
    }
}
