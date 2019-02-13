package es.saladillo.nicolas.pruebaservicionotificaciones;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.nfc.NfcAdapter.EXTRA_DATA;

public class ServicioNotificacion extends JobIntentService {

    private static final int JOB_ID = 7;
    private static final int NOTIFICATION_ID = 9001;

    public static void start(Context context) {
        Intent intent = new Intent(context, ServicioNotificacion.class);
        enqueueWork(context, ServicioNotificacion.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Notification notification = new NotificationCompat.Builder(this, "Lamlataf")
                .setSmallIcon(R.drawable.ic_whatshot_black_24dp)
                .setContentTitle("Prueba de notificacion")
                .setContentText("Notificacion lanzada por un servicio")
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // NOTIFICATION_ID debe ser un entero único para cada notificación.
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
