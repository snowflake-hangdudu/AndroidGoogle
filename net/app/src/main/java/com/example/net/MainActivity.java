package com.example.net;

import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public ImageView imageView;

    // 注意：这里的 BuildConfig.ENVIRONMENT 必须是你自己定义的环境变量名，并且在 build.gradle 文件中定义过
    String environment = BuildConfig.ENVIRONMENT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(environment.equals("production")){
            // 生产环境
        }else if(environment.equals("development")){
            System.out.println("开发环境");
        }


        Button button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(v -> {
            new FetchCatImageTask().execute("https://api.thecatapi.com/v1/images/search?limit=1");
        });
    }

    public String getEnvironment() {
        return environment;
    }

    private class FetchCatImageTask extends AsyncTask<String, Void, String> {
        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... urls) {
            Request request = new Request.Builder()
                    .url(urls[0])
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    return response.body().string();
                } else {
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String imageUrl = jsonObject.getString("url");
                    // 使用 Glide 加载图片
                    Glide.with(MainActivity.this)
                            .load(imageUrl)
                            .into(imageView);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
