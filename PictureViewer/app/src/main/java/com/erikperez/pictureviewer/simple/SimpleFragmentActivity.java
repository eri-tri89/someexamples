package com.erikperez.pictureviewer.simple;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.erikperez.pictureviewer.R;

public class SimpleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);

        if (savedInstanceState == null) {
            this.getSupportFragmentManager().beginTransaction().add(R.id.simpleFrameLayout, new SimpleFragment()).commit();
        }
    }

    public static class SimpleFragment extends Fragment {

        public SimpleFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
            Button btn = (Button) rootView.findViewById(R.id.oneDogBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "This dog says: Goffff!", Toast.LENGTH_SHORT).show();

                }
            });
            return rootView;
        }

    }
}
