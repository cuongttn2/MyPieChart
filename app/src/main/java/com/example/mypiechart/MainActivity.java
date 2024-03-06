package com.example.mypiechart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.TRANSPARENT);

        pieChart.setTransparentCircleRadius(0f);   // transparent circle of piechart


        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(34f, "PartyA"));
        yValues.add(new PieEntry(23f, "USA"));
        yValues.add(new PieEntry(14f, "India"));
        yValues.add(new PieEntry(40f, "Russia"));
        yValues.add(new PieEntry(35f, "China"));
        yValues.add(new PieEntry(23f, "Japan"));
        yValues.add(new PieEntry(11f, "Singapore"));

//        pieChart.getLegend().setOrientation(Legend.LegendOrientation.VERTICAL);   // orientation of legend
        pieChart.getLegend().setEnabled(false); // remove legend


        PieDataSet dataSet = new PieDataSet(yValues, "Countries");
        dataSet.setSliceSpace(3f); // distance between values
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        pieChart.setTouchEnabled(false);    //  disable touch
        pieChart.setDrawEntryLabels(false);     // hide label
        dataSet.setDrawValues(false);   // hide number values

        pieChart.animateY(1000, Easing.EaseInOutCubic);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);

    }
}