package com.erikperez.pictureviewer.pager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erikperez.pictureviewer.R;
import com.erikperez.pictureviewer.pager.adapter.PagerAdapter;

public class PagerActivity extends AppCompatActivity {

    ViewPager pager;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new PagerAdapter(this.getSupportFragmentManager());
        pager.setAdapter(adapter);
    }
}
