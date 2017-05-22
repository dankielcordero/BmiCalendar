package cz.inovett.bmicalendar;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    EditText editHeight, editAge, editWeight;
    Button btnAddData;
    Button btnviewAll;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editHeight = (EditText) findViewById(R.id.editText_height);
        editAge = (EditText) findViewById(R.id.editText_age);
        editWeight = (EditText) findViewById(R.id.editText_Weight);
        btnAddData = (Button) findViewById(R.id.add);
        btnviewAll = (Button) findViewById(R.id.button_view_all);

        myDb = new DatabaseHelper(this);

        AddData();
        viewAll();
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editHeight.getText().toString(),
                                editAge.getText().toString(),
                                editWeight.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(SettingsActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SettingsActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Age :" + res.getString(2) + "\n");
                            buffer.append("Height :" + res.getString(1) + "\n");
                            buffer.append("Weight :" + res.getString(3) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
