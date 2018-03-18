package com.example.sei.achmadtaufikrizki_1202150071_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {


    public ListView iList;
    private Button iButton;
    private ProgressBar iBar;
    private ItemList itemList;
    private String[] mahasiswa = {
            "Dina", "Rian", "Gina", "Osas", "Reno", "Lina", "Roi", "Shifa"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        iList = findViewById(R.id.listView);
        iButton = findViewById(R.id.buttonAsync);
        iBar = findViewById(R.id.bar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());

        iList.setAdapter(adapter);
    }



    public void startAsync(View view) {
        itemList = new ItemList();
        itemList.execute();
    }


    public class ItemList extends AsyncTask<Void, String, Void> {

        private ArrayAdapter<String> iAdapter;
        private int iCounter = 1;
        ProgressDialog iDialog = new ProgressDialog(ListMahasiswa.this);


        @Override
        protected void onPreExecute() {
            iAdapter = (ArrayAdapter<String>) iList.getAdapter();
            iDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            iDialog.setTitle("Please wait while the data is being loaded");

            iDialog.setProgress(0);
            iDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (String data : mahasiswa){
                publishProgress(data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            iAdapter.add(values[0]);

            //menghitung persen pada dialog
            Integer status = (int) ((iCounter / (float) mahasiswa.length) * 100);
            iBar.setProgress(status);

            //set status pada ProgressDialog
            iDialog.setProgress(status);

            //set message will not working when using horizontal loading
            iDialog.setMessage(String.valueOf(status + "%"));
            iCounter++;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            //hide progreebar
            iBar.setVisibility(View.GONE);

            //remove progress dialog
            iDialog.dismiss();
            iList.setVisibility(View.VISIBLE);
        }
    }
}
