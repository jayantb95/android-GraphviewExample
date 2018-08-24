package jayantb95.graphviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private int point;
    private Button btnPlotPoint;
    private GraphView graphPoints;
    private TextView txtPoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        btnPlotPoint = findViewById(R.id.btn_plot_point);
        graphPoints = findViewById(R.id.graphView_point);
        txtPoint = findViewById(R.id.txt_last_point);
        listener();
    }

    private void listener() {
        btnPlotPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plotPoints();
                txtPoint.setText(String.valueOf(point));
            }
        });
    }


    private void plotPoints() {
        graphPoints.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        series.resetData(generatePoint());
        series.setDrawAsPath(true);
        graphPoints.addSeries(series);
    }

    private DataPoint[] generatePoint() {
        //generating random integer values and storing them in an integer list
        int count = 10;
        DataPoint[] dataPointArray = new DataPoint[count];
        for (int i = 0; i < count; i++) {
            Random r = new Random();
            point = r.nextInt(10);

            Log.d(TAG, "generatePoint: points: " + point);
            DataPoint dataPoint = new DataPoint(i, point);
            dataPointArray[i] = dataPoint;
        }
        return dataPointArray;
    }
}
