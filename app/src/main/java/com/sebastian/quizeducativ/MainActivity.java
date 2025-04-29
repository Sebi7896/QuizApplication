package com.sebastian.quizeducativ;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.sebastian.quizeducativ.fragments.AboutFragment;
import com.sebastian.quizeducativ.fragments.QuizMainFragment;
import com.sebastian.quizeducativ.fragments.QuizResponsesFragment;
import com.sebastian.quizeducativ.model.QuizModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


     private DrawerLayout drawerLayout;
     private Fragment currentFragment;
     private  Toolbar toolbar;
     public List<QuizModel> quizModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configNavigation();

        quizModelList = new ArrayList<>();
        NavigationView navigationView = findViewById(R.id.iacob_sebastian_nav_view);
        navigationView.setNavigationItemSelectedListener(this::setActionItemSelected);

        if(savedInstanceState == null) {
            currentFragment = QuizMainFragment.newInstance(quizModelList);
            toolbar.setTitleTextAppearance(this,R.style.ToolbarTitleTextAppearance);
            populateFragment();
            navigationView.setCheckedItem(R.id.iacob_sebastian_quiz_main_fragment);
        }

    }

    private boolean setActionItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.iacob_sebastian_quiz_main_fragment) {
            toolbar.setTitle(R.string.app_name);
            currentFragment = QuizMainFragment.newInstance(quizModelList);
        }else if(item.getItemId() == R.id.iacob_sebastian_quiz_responses_fragment) {
            toolbar.setTitle(R.string.quiz_responses);
            currentFragment = QuizResponsesFragment.newInstance(quizModelList);
        }else if(item.getItemId() == R.id.iacob_sebastian_about_fragment) {
            toolbar.setTitle(R.string.about_fragment_title);
            currentFragment = new AboutFragment();
        }
        populateFragment();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void configNavigation() {
        toolbar = findViewById(R.id.iacob_sebastian_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar.setTitle(R.string.start_cultural_anthropological_quiz);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        actionBarDrawerToggle.syncState();
        toolbar.setNavigationIcon(R.drawable.menu_icon);
    }
    public void populateFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.iacob_sebastian_nav_host_fragment_content_main, currentFragment)
                .commit();
    }
}