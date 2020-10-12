package com.kwesiwelbred.androidgraphs;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartFragment extends Fragment {


    public BarChartFragment() {
        // Required empty public constructor
    }

    public static BarChartFragment newInstance() {
        return new BarChartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        BarChart barChart = view.findViewById(R.id.bar_graph_id);
        //Data values for y-axis
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 100f, "Python"));
        barEntries.add(new BarEntry(1, 95f, "Js"));
        barEntries.add(new BarEntry(2, 80f, "Java"));
        barEntries.add(new BarEntry(3, 60f, "C"));
        barEntries.add(new BarEntry(4, 15f, "C++"));
        barEntries.add(new BarEntry(5, 90f, "Go"));
        barEntries.add(new BarEntry(6, 43f, "C#"));
        barEntries.add(new BarEntry(7, 70f, "Swift"));
        barEntries.add(new BarEntry(8, 80f, "Objective c"));
        barEntries.add(new BarEntry(9, 110f, "Kotlin"));
        //setting it to the bar
        final BarDataSet dataSet = new BarDataSet(barEntries, "%Popularity");

        //Data values for x-axis
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Python");
        languages.add("Js");
        languages.add("Java");
        languages.add("C");
        languages.add("C++");
        languages.add("Go");
        languages.add("C#");
        languages.add("swift");
        languages.add("Objective c");
        languages.add("Kotlin");

        //setting the data to the x-axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(languages));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(languages.size());
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceMin(1);
        xAxis.setSpaceMax(1);
        xAxis.setLabelRotationAngle(300);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1f);

        // Apart from setting the x-xis, you can rather set a legend
      /*  Legend legend = barChart.getLegend();
        legend.setFormSize(10f); // set the size of the legend forms/shapes
        legend.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        //l.setTypeface(font);
        legend.setTextSize(12f);
        legend.setTextColor(Color.BLACK);

        List<LegendEntry> lentries = new ArrayList<>();
        for (int i = 0; i < languages.size(); i++) {
            LegendEntry entry = new LegendEntry();
            //entry.formColor = ColorTemplate.MATERIAL_COLORS[i];
            entry.label = languages.get(i);
            lentries.add(entry);
        }
        legend.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        legend.setYEntrySpace(5f);
        legend.setCustom(lentries);*/

        //Interaction with bar data
        BarData barData = new BarData(dataSet);
        List<Integer> colors = new ArrayList<>();// creating my own default colors
        colors.add(getResources().getColor(R.color.baby_blue));
        colors.add(getResources().getColor(R.color.babyPink));
        colors.add(getResources().getColor(R.color.berryRed));
        colors.add(getResources().getColor(R.color.black_forest));
        colors.add(getResources().getColor(R.color.blackberry));
        colors.add(getResources().getColor(R.color.blue_grass));
        colors.add(getResources().getColor(R.color.cherryRed));
        colors.add(getResources().getColor(R.color.dessertBlue));
        colors.add(getResources().getColor(R.color.butter));
        colors.add(getResources().getColor(R.color.crayonOrange));
        colors.add(getResources().getColor(R.color.deepNavyBlue));

        dataSet.setColors(colors);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(15f);
        dataSet.setBarBorderColor(Color.CYAN);

        //Interaction with barChart
        barChart.setData(barData);
        barChart.setTouchEnabled(true);
        barChart.animateY(3000);
        barChart.getDescription().setText("Programming languages");
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

        return view;
    }
}
