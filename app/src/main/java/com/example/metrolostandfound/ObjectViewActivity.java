package com.example.metrolostandfound;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ObjectViewActivity extends AppCompatActivity {
    private LostObject printObject;

    TextView objectMcTextView, objectScTextView, objectDateTextView, objectTimeTextView, objectLineTextView, objectStationTextView, objectLocTextView, objectDetailTextView;
    ImageView objectImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_view);

        loadItem();

        objectImageView = (ImageView) findViewById(R.id.objectImageView);
        objectMcTextView = (TextView) findViewById(R.id.objectMcTextView);
        objectScTextView = (TextView) findViewById(R.id.objectScTextView);
        objectDateTextView = (TextView) findViewById(R.id.objectDateTextView);
        objectTimeTextView = (TextView) findViewById(R.id.objectTimeTextView);
        objectLineTextView = (TextView) findViewById(R.id.objectLineTextView);
        objectStationTextView = (TextView) findViewById(R.id.objectStationTextView);
        objectDetailTextView = (TextView) findViewById(R.id.objectDetailTextView);
        objectLocTextView = (TextView) findViewById(R.id.objectLocTexttView);

        ImageView btnRefresh = (ImageView) findViewById(R.id.refresh);
        ImageView btnBack = (ImageView) findViewById(R.id.searchBackImageView);


        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshItem();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                onStop();
            }
        });

        //region Activity ??????
        TextView searchHomeTextView = (TextView) findViewById(R.id.productDetailHomeTextView);
        TextView searchAddTextView = (TextView) findViewById(R.id.productDetailAddTextView);
        TextView searchSettingTextView = (TextView) findViewById(R.id.productDetailSettingTextView);
        searchHomeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                onStop();
            }
        });

        searchAddTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnrollActivity_PW.class);
                startActivity(intent);
                onStop();
            }
        });

        searchSettingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
                onStop();
            }
        });
        //endregion

        Button btnDelete = (Button) findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View) View.inflate(ObjectViewActivity.this, R.layout.passwd_input_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(ObjectViewActivity.this);

                dlg.setTitle("????????? ?????? ??????");
                dlg.setView(dialogView);

                dlg.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText) dialogView.findViewById(R.id.edt_passwd);

                        if(et.getText().toString().equals(printObject.getPasswd())){
                            DBController.deleteItem(Integer.parseInt(printObject.getId()));
                            Toast.makeText(ObjectViewActivity.this, "?????????", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(ObjectViewActivity.this, SearchActivity.class);
                            startActivity(intent);
                            onStop();
                        }
                        else {
                            Toast.makeText(ObjectViewActivity.this, "????????? ????????????", Toast.LENGTH_SHORT).show();
                            et.setText("");
                        }
                    }
                });
                dlg.setNegativeButton("??????", null);

                dlg.show();
            }
        });


    }



    private void loadItem(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        if(id != -1){
            new DBLoadCall().execute(id);
        }
    }// ???????????? printObject??? ??????

    private void refreshItem(){
        printItem();
    }

    private void printItem(){
        printObject = DBController.singleObject;
        if(printObject != null){


            if(printObject.getImage() == null){
                printObject.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.search));
            }
            objectImageView.setImageBitmap(printObject.getImage());
            objectMcTextView.setText(printObject.getMainCategory());
            objectScTextView.setText(printObject.getSubCategory());

            if(printObject.getDateTime() != null) {
                String[] dateAndTime = printObject.getDateTime().split(":");
                objectDateTextView.setText(dateAndTime[0] + "??? " + dateAndTime[1] + "??? " + dateAndTime[2] + "???");
                objectTimeTextView.setText(String.format("%02d", Integer.parseInt(dateAndTime[3])) + " : " + String.format("%02d", Integer.parseInt(dateAndTime[4])) + " ");
            }

            objectLineTextView.setText(printObject.getLine());
            objectStationTextView.setText(printObject.getStation());
            objectLocTextView.setText(printObject.getStorage());
            objectDetailTextView.setText(printObject.getContents());
        }
    }//printObject??? ????????? ???????????? TextView ?????? ?????? ???????????? ????????? ??????.

    //????????? printObject ?????? ??? ????????? ??? ???????????? ?????? ???????????? ?????? ??? ??? ??????
    private class DBLoadCall extends AsyncTask<Integer, String, String> {

        @Override
        protected String doInBackground(Integer[] params) {
            printObject = DBController.getItem(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            printItem();
        }
    } //?????? ??????

}
