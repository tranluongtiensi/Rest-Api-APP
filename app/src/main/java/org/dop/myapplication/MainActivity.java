package org.dop.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.dop.myapplication.api.ApiService;
import org.dop.myapplication.model.Info;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView factView;
    private TextView lengthView;
    private Button callApiButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factView = findViewById(R.id.fact_view);
        lengthView = findViewById(R.id.length_view);
        callApiButton = findViewById(R.id.call_api_btn);

        callApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallApi();
            }
        });
    }
    private void clickCallApi() {
        ApiService.apiService.cheetabInfo("In one stride, a cheetah can cover 23 to 26 feet (7 to 8 meters)."
                , "65").enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Toast.makeText(MainActivity.this,"Call Api Success", Toast.LENGTH_SHORT).show();
                Info info = response.body();
                if (info != null) {
                    factView.setText(info.getFact());
                    lengthView.setText(info.getLength());
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });
//                new Callback<MainActivity>() {
//            @Override
//            public void onResponse(Call<MainActivity> call, Response<MainActivity> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<MainActivity> call, Throwable t) {
//
//            }
//        });
    }
}