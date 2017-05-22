package cz.inovett.bmicalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class WelcomeScreenActivity2 extends AppCompatActivity {
    private EditText editTextVek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen2);

        editTextVek = (EditText) findViewById(R.id.editTextAge);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeScreenActivity2.this, WelcomeScreenActivity3.class);
                i.putExtra("vek", editTextVek.getText().toString());
                startActivity(i);

            }
        });
    }

}
