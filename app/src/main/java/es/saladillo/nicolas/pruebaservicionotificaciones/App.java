package es.saladillo.nicolas.pruebaservicionotificaciones;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.provider.SyncStateContract;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createChannel();
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(
                    Context.NOTIFICATION_SERVICE);
            NotificationChannel defaultChannel = new NotificationChannel(
                    Constants.DEFAULT_CHANNEL_ID,
                    getString(R.string.default_channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT);
            defaultChannel.setDescription(getString(R.string.default_channel_name));
        }
    }
}
