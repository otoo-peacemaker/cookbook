package com.kwesiwelbred.androidgraphs;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartFragment extends Fragment {

    public PieChartFragment() {
        // Required empty public constructor
    }

    public static PieChartFragment newInstance() {
        return new PieChartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        PieChart pieChart = view.findViewById(R.id.pieChartId);

        ArrayList<PieEntry> scores = new ArrayList<>();
        scores.add(new PieEntry(90f, "Python\n 90%"));
        scores.add(new PieEntry(89f, "Js"));
        scores.add(new PieEntry(95f, "Java"));
        scores.add(new PieEntry(70f, "C"));
        scores.add(new PieEntry(59f, "C++"));
        scores.add(new PieEntry(87f, "Go"));
        scores.add(new PieEntry(56f, "Flutter"));
        scores.add(new PieEntry(78f, "Swift"));
        scores.add(new PieEntry(45f, "Kotlin"));
        scores.add(new PieEntry(98f, "PHP"));

        //set your data into the chart
        PieDataSet pieDataSet = new PieDataSet(scores, "Best Languages");
        // add some format the data

        //MainActivity colorCall = new MainActivity();
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

        pieDataSet.setColors(colors);// or use setColors(ColorTemplate.MATERIAL_COLORS)
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(2f);
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueLineColor(Color.LTGRAY);
        pieDataSet.setSliceSpace(1f);

        // set these data into pie default data
        PieData pieData = new PieData(pieDataSet);
        //display the pie data into the chart
        pieChart.setData(pieData);
        pieChart.setUsePercentValues(true);
        pieChart.setCenterText("Programming Languages");
        pieChart.setCenterTextSize(25);
        pieChart.setDrawEntryLabels(true);
        pieChart.isDrawEntryLabelsEnabled();
        pieChart.setEntryLabelTextSize(20f);
        pieChart.setEntryLabelColor(getResources().getColor(R.color.black_90));
        pieChart.setCenterTextColor(getResources().getColor(R.color.black100));
        pieChart.animateXY(10000, 10000);

        Legend legend = pieChart.getLegend();
        legend.getFormToTextSpace();
        legend.getOrientation();
        legend.getVerticalAlignment();
        legend.setFormSize(10f);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setFormLineWidth(5f);

        return view;
    }
}
