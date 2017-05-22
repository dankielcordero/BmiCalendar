package cz.inovett.bmicalendar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class HomeActivity extends AppCompatActivity {
    String vek, vyska, vaha;
    private GraphView graph;
    private ProgressDialog progressDialog;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressDialog = new ProgressDialog(this);
        graph = (GraphView) findViewById(R.id.graph);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        setSeries1();
        setSeries2();


        Bundle extras = getIntent().getExtras();
        vyska = extras.getString("vyska");
        vek = extras.getString("vek");
        vaha = extras.getString("vaha");

        textViewInfo.setText(vek + " yo" + " | " + vyska + " cm" + " | " + vaha + " kg");

    }

    private void setSeries1() {
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series1);
        series1.setTitle("weight");
    }

    private void setSeries2() {
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 2),
                new DataPoint(1, 6),
                new DataPoint(2, 4),
                new DataPoint(3, 3),
                new DataPoint(4, 7)
        });
        series2.setColor(Color.rgb(231, 76, 60));
        series2.setTitle("sweets");
        graph.addSeries(series2);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
    }


    public void openCalendar(View view) {
        Intent i = new Intent(HomeActivity.this, CalendarActivity.class);
        startActivity(i);
        progressDialog.setMessage("Opening .......");
        progressDialog.show();



    }

    public void openSettings(View view) {
        Intent i = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivity(i);
    }
}
