package com.erikperez.pictureviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.erikperez.pictureviewer.multiple.MultipleActivity;
import com.erikperez.pictureviewer.pager.PagerActivity;
import com.erikperez.pictureviewer.recycleview.RecycleViewActivity;
import com.erikperez.pictureviewer.simple.SimpleFragmentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simple(View v) {
        this.startActivity(new Intent(this.getApplicationContext(), SimpleFragmentActivity.class));
    }

    public void multiple(View v) {
        this.startActivity(new Intent(this.getApplicationContext(), MultipleActivity.class));
    }

    public void viewPager(View v) {
        this.startActivity(new Intent(this.getApplicationContext(), PagerActivity.class));
    }

    public void recyclerView(View v) {
        this.startActivity(new Intent(this.getApplicationContext(), RecycleViewActivity.class));
    }


}
