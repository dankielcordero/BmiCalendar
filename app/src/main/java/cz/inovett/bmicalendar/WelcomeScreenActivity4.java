package cz.inovett.bmicalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class WelcomeScreenActivity4 extends AppCompatActivity {
    EditText vyska;
    String vaha, vek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen4);

        vyska = (EditText) findViewById(R.id.editTextVyska);

        Bundle extras = getIntent().getExtras();
        vek = extras.getString("vek");
        vaha = extras.getString("vaha");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeScreenActivity4.this, WelcomeScreenActivity5.class);
                i.putExtra("vyska", vyska.getText().toString());
                i.putExtra("vaha", vaha);
                i.putExtra("vek", vek);
                startActivity(i);
            }
        });
    }

}
