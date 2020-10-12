package com.kwesiwelbred.androidgraphs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem barChartTab, pieChartTab, radarChartTab, lineChartTab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChartTab = findViewById(R.id.bar_chart_Tab);
        pieChartTab = findViewById(R.id.pie_chart_Tab);
        radarChartTab = findViewById(R.id.radar_chart_Tab);
        lineChartTab = findViewById(R.id.line_chart_Tab);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);

        ViewPagerAdapter pagerAdapter = new
                ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /*
     * author : Kwesi Welbred
     * params : null
     * comment: call this method anywhere to apply colors to your design
     * returns type : List<Integer>
     * */
    public List<Integer> graphColors() {
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
        return colors;
    }
}
