package com.example.sei.achmadtaufikrizki_1202150071_studycase4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LihatGambar extends AppCompatActivity {


    private EditText mURL;
    private ImageView mImage;
    private String imageLink;
    private Button btnImage;
//    private Uri link;
//    private ImageDownloader imageDownloader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_gambar);
        mURL = findViewById(R.id.linkImg);
        mImage = findViewById(R.id.imageResult);
        btnImage = findViewById(R.id.btnSearch);

    }

    public void searchPic(View view) {
        imageLink = mURL.getText().toString();
//        Picasso.get().load(imageLink).into(mImage);
        ImageDownloader  imageDownloader = new ImageDownloader();
        imageDownloader.execute(imageLink);
    }


    public class ImageDownloader extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }
        @Override
        protected void onPostExecute(String imageLink) {
            super.onPostExecute(imageLink);

            Picasso.get().load(imageLink).into(mImage);

        }
    }
}
