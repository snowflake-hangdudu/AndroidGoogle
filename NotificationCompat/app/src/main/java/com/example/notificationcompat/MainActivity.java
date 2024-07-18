package com.example.notificationcompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import android.Manifest;
import androidx.core.app.RemoteInput;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "default_channel_id";
    private static final String KEY_TEXT_REPLY = "key_text_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, waitgo.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);






        // 请求通知权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }

        // 创建通知渠道
        createNotificationChannel();

        // 将图片资源转换为 Bitmap 对象
        Bitmap bigPicture = BitmapFactory.decodeResource(getResources(), R.drawable.icon);

        // 构建通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon) // 设置通知图标
                .setContentTitle("通知noti") // 设置通知标题
                .setContentText("我是通知的内容") // 设置通知内容
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 设置通知优先级，默认等级
                .setLargeIcon(bigPicture)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bigPicture).bigLargeIcon(null));





        // 获取 NotificationManager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 发送通知
        notificationManager.notify(1, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //渠道名称
            CharSequence name = "通知";
            //渠道描述
            String description = "展示该app的通知";
            //重要性，默认级别
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            //创建通知渠道实例
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            //注册通知渠道
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}