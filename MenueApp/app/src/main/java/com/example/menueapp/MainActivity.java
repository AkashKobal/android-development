package com.example.menueapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.textView);
        Toolbar myToolBar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
            res.setText("Search");
            Toast.makeText(this, "Search Menu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.settings) {
            res.setText("Settings");
            Toast.makeText(this, "Settings Menu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.deleteid) {
            res.setText("Delete");
            Toast.makeText(this, "Delete Menu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.aboutId) {
            res.setText("About");
            Toast.makeText(this, "About Menu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.socialId) {
            res.setText("Social");
            Toast.makeText(this, "Social", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
