package com.example.blur_o_matic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class BlurWorker extends Worker {
    public static final String KEY_IMAGE_URI = "IMAGE_URI";
    public static final String KEY_BLUR_LEVEL = "BLUR_LEVEL";

    public BlurWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String imageUri = getInputData().getString(KEY_IMAGE_URI);
        int blurLevel = getInputData().getInt(KEY_BLUR_LEVEL, 1);

        try {
            Bitmap bitmap = Glide.with(getApplicationContext())
                    .asBitmap()
                    .load(imageUri)
                    .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();

            Bitmap blurredBitmap = blurBitmap(bitmap, blurLevel);

            File output = new File(getApplicationContext().getCacheDir(), "blurred_image.png");
            try (FileOutputStream out = new FileOutputStream(output)) {
                blurredBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            }

            return Result.success();
        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    private Bitmap blurBitmap(Bitmap bitmap, int blurLevel) {
//        RequestOptions requestOptions = new RequestOptions()
//                .transform(new CenterCrop(), new TransformationUtils.BitmapTransformation(getApplicationContext(), blurLevel));
//
//        try {
//            return Glide.with(getApplicationContext())
//                    .asBitmap()
//                    .apply(requestOptions)
//                    .load(bitmap)
//                    .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                    .get();
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//            return bitmap;
//        }
        return bitmap;
    }
}