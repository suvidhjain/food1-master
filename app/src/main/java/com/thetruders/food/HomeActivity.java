package com.thetruders.food;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;

    ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//      setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar.setTitle("Home");
        HomeFragment fragment = new HomeFragment();
        FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            toolbar.setTitle("Home");
            HomeFragment fragment = new HomeFragment();
            FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
//            fragmentTransaction.add(R.id.first, fragment);


            Log.d("Homeee","11111111");

        } else if (id == R.id.nav_profile) {
            Log.d("Homeee","22222222222");
            toolbar.setTitle("Profile");
            ProfileFragment mProfileFragment = new ProfileFragment();
            FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mProfileFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();

        } else if (id == R.id.nav_myDonations) {

            toolbar.setTitle("My Donation");
            mYDonation mDonation = new mYDonation();
            FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mDonation);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();

            Log.d("Homeee","333333333");

        } else if (id == R.id.nav_donate) {
            toolbar.setTitle("Donate");

            DonateFragment mDonation = new DonateFragment();
            FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, mDonation);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
            Log.d("Homeee","4444444444");

        } else if (id == R.id.nav_aboutUs){
            toolbar.setTitle("About Us");
            AboutUs abt = new AboutUs();
            FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, abt);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();

        } else if (id == R.id.nav_logout){
            toolbar.setTitle("Logout");
            LogoutFragment logoutFragment = new LogoutFragment();
            FragmentManager fragmentManager = HomeActivity.this.getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, logoutFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();


        } else if (id == R.id.nav_share) {
            share2friend();

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    void share2friend() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT," "+ getApplicationContext().getResources().getString(R.string.app_name)+"'");
        i.putExtra(Intent.EXTRA_TEXT,"My Donation App  "+ "https://play.google.com/store/apps/details?id="+getClass().getPackage().getName());
        try {
            getApplicationContext().startActivity(Intent.createChooser(i,"Share"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),"There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
