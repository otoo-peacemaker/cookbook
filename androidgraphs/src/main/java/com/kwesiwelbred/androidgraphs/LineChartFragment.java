package com.kwesiwelbred.androidgraphs;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LineChartFragment extends Fragment {

    public LineChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        LineChart lineChart;
        view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        lineChart = view.findViewById(R.id.line_chart_id);
        ArrayList<Entry> list = new ArrayList<>();
        list.add(new Entry(1, 200, "python"));
        list.add(new Entry(2, 400, "Js"));
        list.add(new Entry(3, 350, "python"));
        list.add(new Entry(4, 400, "Js"));

        LineDataSet lineDataSet = new LineDataSet(list, "Trends");
        lineDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        lineDataSet.setDrawIcons(true);
        lineDataSet.setDrawIcons(true);

        Legend legend = lineChart.getLegend();
        legend.setFormSize(10f); // set the size of the legend forms/shapes
        legend.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        //l.setTypeface(font);
        legend.setTextSize(12f);
        legend.setTextColor(Color.BLACK);

        List<String> labels = new ArrayList<>();
        labels.add("Python");
        labels.add("Js");
        labels.add("C");
        labels.add("C++");
        List<LegendEntry> lentries = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = ColorTemplate.MATERIAL_COLORS[i];
            entry.label = labels.get(i);
            lentries.add(entry);
        }
        legend.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        legend.setYEntrySpace(5f);
        legend.setCustom(lentries);

        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);
        lineChart.setData(lineData);
        lineChart.setElevation(5);
        return view;
    }
}
