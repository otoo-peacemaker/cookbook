package com.kwesiwelbred.androidgraphs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadarChartFragment extends Fragment {
    private RadarChart radarChart;
    private TextView textView;

    public RadarChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_radar_chart, container, false);

        radarChart = view.findViewById(R.id.radar_chart_id);
        textView = view.findViewById(R.id.radarTextView);

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

        List<RadarEntry> radarEntries = new ArrayList<>();
        radarEntries.add(new RadarEntry(200, "Python"));
        radarEntries.add(new RadarEntry(100));
        radarEntries.add(new RadarEntry(200));
        radarEntries.add(new RadarEntry(100));
        radarEntries.add(new RadarEntry(200));
        radarEntries.add(new RadarEntry(100));
        radarEntries.add(new RadarEntry(200));
        radarEntries.add(new RadarEntry(100));
        radarEntries.add(new RadarEntry(200));
        radarEntries.add(new RadarEntry(100));
        RadarDataSet radarDataSet = new RadarDataSet(radarEntries, "languages");
        radarDataSet.setColors(colors);
        radarDataSet.setLineWidth(8f);
        radarDataSet.setValueTextColors(colors);
        radarDataSet.setFormLineWidth(10);


        List<RadarEntry> radarEntries2 = new ArrayList<>();
        radarEntries2.add(new RadarEntry(200, "Python"));
        radarEntries2.add(new RadarEntry(600));
        radarEntries2.add(new RadarEntry(200));
        radarEntries2.add(new RadarEntry(100));
        radarEntries2.add(new RadarEntry(200));
        radarEntries2.add(new RadarEntry(100));
        radarEntries2.add(new RadarEntry(200));
        radarEntries2.add(new RadarEntry(100));
        radarEntries2.add(new RadarEntry(900));
        radarEntries2.add(new RadarEntry(100));
        RadarDataSet radarDataSet2 = new RadarDataSet(radarEntries2, "markets prices");

        List<RadarEntry> radarEntries3 = new ArrayList<>();
        radarEntries3.add(new RadarEntry(200, "Python"));
        radarEntries3.add(new RadarEntry(600));
        radarEntries3.add(new RadarEntry(200));
        radarEntries3.add(new RadarEntry(100));
        radarEntries3.add(new RadarEntry(200));
        radarEntries3.add(new RadarEntry(100));
        radarEntries3.add(new RadarEntry(200));
        radarEntries3.add(new RadarEntry(100));
        radarEntries3.add(new RadarEntry(900));
        radarEntries3.add(new RadarEntry(100));
        RadarDataSet radarDataSet3 = new RadarDataSet(radarEntries3, "markets prices");


        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet);
        radarData.addDataSet(radarDataSet2);
        radarData.addDataSet(radarDataSet3);

        radarChart.setData(radarData);


        return view;
    }
}
