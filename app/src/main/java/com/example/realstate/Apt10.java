package com.example.realstate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class Apt10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt10);

        LineChart lineChart = (LineChart)findViewById(R.id.chart10);
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0,31000));
        entries.add(new Entry(1,31500));
        entries.add(new Entry(2,32200));
        entries.add(new Entry(3,32600));
        entries.add(new Entry(4,32000));
        entries.add(new Entry(5,31500));
        entries.add(new Entry(6,32000));
        entries.add(new Entry(7,33000));
        entries.add(new Entry(8,32450));
        entries.add(new Entry(9,34120));
        entries.add(new Entry(10,32600));
        entries.add(new Entry(11,33500));
        entries.add(new Entry(12,34000));

        LineDataSet dataSet = new LineDataSet(entries,"2017");
        final HashMap<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "");
        numMap.put(1, "1월");
        numMap.put(2, "2월");
        numMap.put(3, "3월");
        numMap.put(4, "4월");
        numMap.put(5, "5월");
        numMap.put(6, "6월");
        numMap.put(7, "7월");
        numMap.put(8, "8월");
        numMap.put(9, "9월");
        numMap.put(10, "10월");
        numMap.put(11, "11월");
        numMap.put(12, "12월");

        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setDrawFilled(true);
        dataSet.setDrawValues(true);
        dataSet.setValueTextSize(10);

        LineData data = new LineData(dataSet);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return numMap.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.setData(data);
        lineChart.animateXY(2000,2000);
        lineChart.invalidate();
    }
}
