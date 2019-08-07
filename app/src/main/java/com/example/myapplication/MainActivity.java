package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.getbase.floatingactionbutton.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    public static SQLiteHelper sqLiteHelper;
    

    FloatingActionButton fabBlood, fabActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sqLiteHelper = new SQLiteHelper(this, "thisDB.sqlite", null, 1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS EXERCISE (id INTEGER PRIMARY KEY AUTOINCREMENT, time VARCHAR, comment VARCHAR, date VARCHAR, image BLOG )");


        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        /*Floating Action Button*/

        fabBlood = findViewById(R.id.fab_action1);
        fabActivity = findViewById(R.id.fab_action2);

        fabBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddGlucose.class);
                startActivity(intent);
            }
        });

        fabActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddExercise.class);
                startActivity(intent);
            }
        });

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodayFragment(), "Today");
        adapter.addFragment(new WeekFragment(), "Week");
        adapter.addFragment(new MonthFragment(), "Month");
        viewPager.setAdapter(adapter);
    }
}