package com.example.blur_o_matic;

import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建一个一次性的workrequest
        OneTimeWorkRequest myWorkRequest = new OneTimeWorkRequest.Builder(BlurWorker.class).build();

        //将workrequest提交到workmanager
        WorkManager.getInstance(this).enqueue(myWorkRequest);


        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);

        imageView.setOnClickListener(view -> {
            int blurLevel = 1;
            int checkedId = radioGroup.getCheckedRadioButtonId();
            if (checkedId == R.id.radio2) {
                blurLevel = 2;
            } else if (checkedId == R.id.radio3) {
                blurLevel = 3;
            }

            //设置图片的uri位置
            Uri imageUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.test);

            Data inputData = new Data.Builder()
                    .putString("input_uri", imageUri.toString())
                    .putInt("blur_level", blurLevel)
                    .build();


            OneTimeWorkRequest blurWorkRequest = new OneTimeWorkRequest.Builder(BlurWorker.class)
                    .setInputData(inputData)
                    .build();

            WorkManager.getInstance(this).enqueue(blurWorkRequest);
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(blurWorkRequest.getId())
                    .observe(this, new Observer<WorkInfo>() {
                        @Override
                        public void onChanged(WorkInfo workInfo) {
                            if (workInfo != null && workInfo.getState().isFinished()) {
                                String outputPath = workInfo.getOutputData().getString("OUTPUT_PATH");
                                if (outputPath != null) {
                                    updateImageView(outputPath);
                                }
                            }
                        }
                    });
        });


        Button fillButton = findViewById(R.id.filledButton);

    }

    private void updateImageView(String imagePath) {
        File file = new File(imagePath);
        Glide.with(this).load(file).into(imageView);
    }
}