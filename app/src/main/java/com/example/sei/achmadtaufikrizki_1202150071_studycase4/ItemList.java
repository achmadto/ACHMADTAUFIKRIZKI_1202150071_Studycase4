//package com.example.zulfikaranshari.zulfikaranshariokafinawan_1202154136_studycase4;
//
//import android.app.ProgressDialog;
//import android.content.ClipData;
//import android.os.AsyncTask;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import com.example.sei.achmadtaufikrizki_1202150071_studycase4.ListMahasiswa;
//
///**
// * Created by sei on 16/03/2018.
// */
//
//public class ItemList extends AsyncTask<Void, String, Void> {
//
//    private ArrayAdapter<String> mAdapter;
//    private int mCounter = 1;
//    ProgressDialog mDialog = new ProgressDialog(ListMahasiswa.this);
//
//
//    @Override
//    protected void onPreExecute() {
//        mAdapter = (ArrayAdapter<String>) mList.getAdapter();
//        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        mDialog.setTitle("Please wait while the data is being loaded");
//        mDialog.setMessage("Loading data");
//        mDialog.setProgress(0);
//        mDialog.show();
//    }
//
//    @Override
//    protected Void doInBackground(Void... params) {
//        for (String data : mahasiswa){
//            publishProgress(data);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    protected void onProgressUpdate(String... values) {
//        mAdapter.add(values[0]);
//
//        Integer current_status = (int) ((mCounter / (float) mahasiswa.length) * 100);
//        mBar.setProgress(current_status);
//
//        //set progress only working for horizontal loading
//        mDialog.setProgress(current_status);
//
//        //set message will not working when using horizontal loading
//        mDialog.setMessage(String.valueOf(current_status + "%"));
//        mCounter++;
//    }
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        //hide progreebar
//        mBar.setVisibility(View.GONE);
//
//        //remove progress dialog
//        mDialog.dismiss();
//        mList.setVisibility(View.VISIBLE);
//    }
//}
