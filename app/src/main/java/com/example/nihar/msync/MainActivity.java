package com.example.nihar.msync;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_people:
                    transaction.replace(R.id.contentLayout,new PeopleFragment()).commit();
                    return true;
                case R.id.navigation_tasks:
                    transaction.replace(R.id.contentLayout,new TasksFragment()).commit();
                    return true;
                case R.id.navigation_messages:
                    transaction.replace(R.id.contentLayout,new MessagesFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.contentLayout,new NotificationsFragment()).commit();
                    return true;
                case R.id.navigation_settings:
                    transaction.replace(R.id.contentLayout,new SettingsFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentLayout,new PeopleFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
