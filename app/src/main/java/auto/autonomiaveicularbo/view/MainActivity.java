package auto.autonomiaveicularbo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import auto.autonomiaveicularbo.R;
import auto.autonomiaveicularbo.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void calcular(View view) {
        control.salvarAction();
    }

    public void limpar(View view) {
        control.limparAction();
    }
}
