package com.feemsasi.newbuppe;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    //private String[] mDrawerTitle = {"File", "Load...", "Open", "Contact"};
    private DrawerLayout mDrawerLayout;
    //private ListView mListView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.drawer);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDrawerTitle);
        mListView.setAdapter(adapter);
        */

        final int[] resId = {
                R.drawable.headpic, R.drawable.cast1,
                R.drawable.cast2, R.drawable.cast3,
                R.drawable.cast4, R.drawable.cast5,
                R.drawable.cast6, R.drawable.cast7
        };
        final String[] list = {
                getString(R.string.def_page), getString(R.string.cast1_name),
                getString(R.string.cast2_name), getString(R.string.cast3_name),
                getString(R.string.cast4_name), getString(R.string.cast5_name),
                getString(R.string.cast6_name), getString(R.string.cast7_name)
        };

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), list, resId);

        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.textView1);
                System.out.println( textView.getText());
                //TextView castName = findViewById(R.id.cast_name);
                ImageView castPic = findViewById(R.id.cast_pic);
                //castName.setText(list[position]);
                castPic.setImageResource(resId[position]);
                //Toast.makeText(getApplicationContext(), "Clicked on item:" +  position , Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(Gravity.START, false);
            }
        });

    }

}
