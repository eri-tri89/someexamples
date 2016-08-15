package com.erikperez.pictureviewer.recycleview.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erikperez.pictureviewer.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by GoreT on 8/13/2016.
 */
public class RVViewHolder extends RecyclerView.ViewHolder {

    TextView titleView, descriptionView;
    ImageView icon, picassoImageView;
    LinearLayout container;

    public RVViewHolder(View itemView) {
        super(itemView);
        titleView = (TextView) itemView.findViewById(R.id.rowTitle);
        descriptionView = (TextView) itemView.findViewById(R.id.rowDescription);
        icon = (ImageView) itemView.findViewById(R.id.listIcon);
        picassoImageView = (ImageView) itemView.findViewById(R.id.picassoImageView);
        container = (LinearLayout) itemView.findViewById(R.id.listContainer);

        itemView.setOnClickListener(savePicture);
    }

    public View.OnClickListener savePicture = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            try {
                File file = getPictureAsFile(picassoImageView);
                Toast.makeText(picassoImageView.getContext(), "File saved at " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                Log.e("adapter", e.getMessage(), e);
                Toast.makeText(picassoImageView.getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private File getPictureAsFile(ImageView iv) throws FileNotFoundException {

        Drawable dr = iv.getDrawable();
        Bitmap bm = ((BitmapDrawable)dr).getBitmap();
        String path = Environment.getExternalStorageDirectory().toString() + "/picture_viewer_saved/",
                subPath = new Date() + titleView.getText().toString() + ".jpg";
        File parent = new File(path);
        parent.mkdirs();
        File file = new File(parent.getAbsolutePath(), subPath);
        if (file.exists()) {
            subPath += subPath.replace(".jpg", "_copy.jpg");
            file = new File(parent.getAbsolutePath(), subPath);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bm.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);

        return file;
    }
}
