package cz.inovett.bmicalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WelcomeScreenActivity5 extends AppCompatActivity {

    TextView textViewBMI;
    String vyska, vaha, vek, bmiText;
    double bmiVyska, bmiVaha, bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen5);

        textViewBMI = (TextView) findViewById(R.id.textViewNadvaha);

        Bundle extras = getIntent().getExtras();
        vyska = extras.getString("vyska");
        vaha = extras.getString("vaha");
        vek = extras.getString("vek");


        bmiVyska = Double.parseDouble(vyska);
        bmiVaha = Double.parseDouble(vaha);
        bmi = (bmiVaha / (bmiVyska * bmiVyska)) * 10000;
        textViewBMI.setText(String.valueOf(String.format("%.2f", bmi)));
        bmiText = String.format("%.2f", bmi);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeScreenActivity5.this, HomeActivity.class);
                i.putExtra("vaha", vaha);
                i.putExtra("vek", vek);
                i.putExtra("vyska", vyska);
                i.putExtra("bmi", bmiText);
                startActivity(i);
            }
        });
    }

}
