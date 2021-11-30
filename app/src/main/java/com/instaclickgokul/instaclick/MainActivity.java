package com.instaclickgokul.instaclick;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.instaclickgokul.instaclick.ui.home.HomeFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView cameratoolbar = toolbar.findViewById(R.id.camera);

        cameratoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Camera is clicked", Toast.LENGTH_SHORT).show();

            }
        });

        navView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public boolean onNavigationItemReselected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId()==R.id.navigation_home)
                {
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment , homeFragment);
                    transaction.commit();
                }

                else if(menuItem.getItemId()==R.id.search)
                {
                    Toast.makeText(MainActivity.this, "search fragment coming soon", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

    }

}