package com.jakepf00.cubetimer;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jakepf00.cubetimer.fragment.ExportFragment;
import com.jakepf00.cubetimer.fragment.ReferenceFragment;
import com.jakepf00.cubetimer.fragment.SettingsFragment;
import com.jakepf00.cubetimer.fragment.StatisticsFragment;
import com.jakepf00.cubetimer.fragment.TimerFragment;

import java.io.File;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        TimerFragment.OnFragmentInteractionListener,
        StatisticsFragment.OnFragmentInteractionListener,
        ReferenceFragment.OnFragmentInteractionListener,
        ExportFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new File(getFilesDir(), getResources().getString(R.string.archive_solves_file));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Spinner spinner = findViewById(R.id.cube_chooser);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cubetype_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_content_frame, TimerFragment.newInstance());
        tx.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;
        Class fragmentClass;

        if (id == R.id.nav_timer) {
            fragmentClass = TimerFragment.class;
        } else if (id == R.id.nav_statistics) {
            fragmentClass = StatisticsFragment.class;
        } else if (id == R.id.nav_reference) {
            fragmentClass = ReferenceFragment.class;
        } else if (id == R.id.nav_export) {
            fragmentClass = ExportFragment.class;
        } else if (id == R.id.nav_settings) {
            fragmentClass = SettingsFragment.class;
        } else { // if (id == R.id.nav_share) {}
            fragmentClass = TimerFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_content_frame, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onFragmentInteraction(Uri uri) {

    }
}
