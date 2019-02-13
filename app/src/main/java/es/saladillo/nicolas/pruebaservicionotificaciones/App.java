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
        crearCanal();
        super.onCreate();
    }

    private void crearCanal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Se crea el canal.
            NotificationChannel notificationChannel = new NotificationChannel(
                    "Lamlataf",
                    getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("PruebaNotificacion");
            // Se registra el canal en el gestor de notificaciones
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
