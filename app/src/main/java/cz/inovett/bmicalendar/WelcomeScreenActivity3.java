package cz.inovett.bmicalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class WelcomeScreenActivity3 extends AppCompatActivity {
    String vek;
    EditText editTextVaha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen3);

        editTextVaha = (EditText) findViewById(R.id.editTextVaha);

        Bundle extras = getIntent().getExtras();
        vek = extras.getString("vek");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeScreenActivity3.this, WelcomeScreenActivity4.class);
                i.putExtra("vaha", editTextVaha.getText().toString());
                i.putExtra("vek", vek);
                startActivity(i);
            }
        });
    }

}
