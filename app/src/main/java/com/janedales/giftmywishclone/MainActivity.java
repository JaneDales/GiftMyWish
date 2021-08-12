package com.janedales.giftmywishclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.janedales.giftmywishclone.ui.friends_events.FriendsEventsFragment;
import com.janedales.giftmywishclone.ui.my_events.MyEventsFragment;
import com.janedales.giftmywishclone.ui.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        openFragment(new FriendsEventsFragment());
    }

    private void initUI() {
        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_friends_events:
                    openFragment(new FriendsEventsFragment());
                    break;
                case R.id.navigation_my_events:
                    openFragment(new MyEventsFragment());
                    break;
                case R.id.navigation_friends:
                    break;
                case R.id.navigation_settings:
                    openFragment(new SettingsFragment());
                    break;
            }
            return true;
        });
    }

    public void openFragment(Fragment fragment){
        FragmentTransaction frt = getSupportFragmentManager().beginTransaction();
        frt.replace(R.id.container, fragment);
        frt.addToBackStack(null);
        frt.commit();
    }
}