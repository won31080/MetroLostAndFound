package com.example.metrolostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollActivity_Car extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_car);

        Button btn_Car2 = (Button) findViewById(R.id.btn_Car2);
        Button btn_Else = (Button) findViewById(R.id.btn_Else);

        //db에 저장
        btn_Car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "감사합니다 2/4", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),EnrollActivity_LineAndStation.class);
                Intent intent2 = getIntent();
                intent.putExtra("pw",intent2.getStringExtra("pw"));
                intent.putExtra("mc","자동차");
                intent.putExtra("sc","자동차키");
               startActivity(intent);
                onStop();
            }
        });
        btn_Else.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "감사합니다 2/4", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),EnrollActivity_LineAndStation.class);
                Intent intent2 = getIntent();
                intent.putExtra("pw",intent2.getStringExtra("pw"));
                intent.putExtra("mc","자동차");
                intent.putExtra("sc","기타");
                startActivity(intent);
                onStop();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        onStop();
    }
}
