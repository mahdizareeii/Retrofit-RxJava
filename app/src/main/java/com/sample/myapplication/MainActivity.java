package com.sample.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.myapplication.models.singersModel.SingersModel;
import com.sample.myapplication.retrofit.interfaces.OnCallBackListener;
import com.sample.myapplication.retrofit.RetrofitClient;
import com.sample.myapplication.retrofit.RetrofitHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.getResponse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResponse();
            }
        });
    }

    private void getResponse() {
        new RetrofitHelper<SingersModel>(RetrofitClient.getRetrofitApi.getSingers(), new OnCallBackListener<SingersModel>() {
            @Override
            public void onCallBack(SingersModel singersModel) {
                Log.i("response 5465", "onCallBack: " + singersModel);
            }
        });
    }
}
