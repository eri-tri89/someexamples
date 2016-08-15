package com.erikperez.pictureviewer.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.erikperez.pictureviewer.R;
import com.erikperez.pictureviewer.recycleview.adapter.RVAdapter;
import com.erikperez.pictureviewer.recycleview.model.RowInformation;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new RVAdapter(this, getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static List<RowInformation> getData() {

        List<RowInformation> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_one,
                R.drawable.ic_two,
                R.drawable.ic_three,
                R.drawable.ic_four,
                R.drawable.ic_five,
                R.drawable.ic_six,
                R.drawable.ic_seven,
                R.drawable.ic_eight,
                R.drawable.ic_nine};
        String defaultDescription = "This is the number ";
        String[] title = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"},
                description = {defaultDescription + title[0].toLowerCase(),
                        defaultDescription + title[1].toLowerCase(),
                        defaultDescription + title[2].toLowerCase(),
                        defaultDescription + title[3].toLowerCase(),
                        defaultDescription + title[4].toLowerCase(),
                        defaultDescription + title[5].toLowerCase(),
                        defaultDescription + title[6].toLowerCase(),
                        defaultDescription + title[7].toLowerCase(),
                        defaultDescription + title[8].toLowerCase()},
                imageLinks = {"https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/23695_pets_vertical_store_dogs_small_tile_8._CB312176604_.jpg",
                        "https://www.petsmartcharities.org/sites/default/files/styles/large/public/cropped-tannertaylor_0.jpg",
                        "http://www.elykennels.co.uk/images/three-dogs.jpg",
                        "https://dncache-mauganscorp.netdna-ssl.com/thumbseg/35/35448-bigthumbnail.jpg",
                        "http://www.hdcreativewallpaper.com/uploads/cache/968274544/five-friendly-dogs-hd-desktop-wallpaper-Qk7Y-480x320-MM-78.jpg",
                        "http://www.bingosbounty.com/pages/blog_files/thankful-kids.jpg",
                        "http://3.bp.blogspot.com/-JVktLQrSYTQ/Urw-IpgvWMI/AAAAAAAAB9s/ZQbfsT2cJVs/s1600/adriano-bacchella-domestic-dogs-seven-rhodesian-ridgeback-puppies-sitting-on-steps.jpg",
                        "http://imgc.allpostersimages.com/images/P-473-488-90/21/2144/HLBCD00Z/posters/adriano-bacchella-domestic-dogs-group-of-eight-pyrenean-mountain-dog-puppies.jpg",
                        "https://www.jigsawexplorer.com/puzzles/subjects/dog-pack-425x300.jpg"};



        for (int i = 0; i < icons.length; i++) {
            RowInformation info = new RowInformation();
            info.setTitle(title[i]);
            info.setDescription(description[i]);
            info.setIconId(icons[i]);
            info.setImagelink(imageLinks[i]);
            data.add(info);

        }

        return data;
    }
}
