package tablerocolores.cfic.edu.tugramola.activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import tablerocolores.cfic.edu.tugramola.R;
import tablerocolores.cfic.edu.tugramola.util.SplashPreferences;

public class SplashActivity extends AppCompatActivity {

    private static final String clave = "CHECKMARCADO";
    private AnimationDrawable animationDrawable;
    private ImageView imageView;
    private SplashPreferences splashPreferences;
    private Intent intentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashPreferences = new SplashPreferences(this);
        boolean checkmarcado = splashPreferences.dameCheck(new String(clave));
        Log.d("MIAPP","check:"+checkmarcado);

        if (!checkmarcado) {
            mostrarAnimacion();
        } else {
            // Voy al main activity
            //intentMain = new Intent(this, MainActivity.class);
            //startActivity (intentMain);
        }

        // Defino el listener del check
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBoxSplash);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(checkBox.isChecked()) {
                    splashPreferences.ponCheck(clave, true);
                }else{
                    splashPreferences.ponCheck(clave, false);
                }
            }
        });

    }
    private void mostrarAnimacion() {
        imageView = findViewById(R.id.img1);

        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(0);
        imageView.setBackgroundResource(R.drawable.gramolaanimacion);

        // Coger el background para mostrar la animation
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }

    public void saltar(View view) {
        // Voy al main activity
        intentMain = new Intent(this, MainActivity.class);
        startActivity (intentMain);
    }


}
