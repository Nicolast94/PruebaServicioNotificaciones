package es.saladillo.nicolas.pruebaservicionotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        Button btn_notif = ActivityCompat.requireViewById(this, R.id.btn_notificacion);
        btn_notif.setOnClickListener(v -> lanzarServicio());
    }

    private void lanzarServicio() {
        ServicioNotificacion.start(this);
    }
}
