package com.sekailabbd.dagger2_ex1;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    @Inject
    OkHttpClient mOkHttpClient;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DaggerApp) getApplication()).getNetComponent().inject(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", "Meraj");
        editor.commit();

        Log.d("Dagger", sharedPreferences.getString("name", "Not found"));

    }
}
