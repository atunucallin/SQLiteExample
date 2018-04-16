package com.example.dj.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.onDbOperationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container)!= null){
            if (savedInstanceState!=null){
                return;
            }

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment,null).commit();
        }
    }

    @Override
    public void dBOpPerformed(int method) {
        switch (method){
            case 0:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddContactFragment(),null).addToBackStack(null).commit();
                break;

            case 1:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ReadContactsFragment(),null).addToBackStack(null).commit();
                break;

            case 2:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UpdateFragment(),null).addToBackStack(null).commit();
                break;

            case 3:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DeleteContactFragment(),null).addToBackStack(null).commit();
                break;
        }
    }
}
