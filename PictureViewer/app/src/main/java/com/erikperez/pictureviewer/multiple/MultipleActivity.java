package com.erikperez.pictureviewer.multiple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erikperez.pictureviewer.R;
import com.erikperez.pictureviewer.multiple.fragment.MultipleMenuFragment;

public class MultipleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);

        if (savedInstanceState == null) {
            this.getSupportFragmentManager().beginTransaction().add(R.id.menuContainer, new MultipleMenuFragment()).commit();
        }
    }
}
