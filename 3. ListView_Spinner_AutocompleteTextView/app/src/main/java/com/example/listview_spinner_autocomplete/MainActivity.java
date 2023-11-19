package com.example.listview_spinner_autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
//    ArrayAdapter adapter;
//    ArrayList listOfItem;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            editText = findViewById(R.id.teditText);
            listView = findViewById(R.id.listview);
            button = (Button) findViewById(R.id.button);
            //create an array
            ArrayList<String> listOfItem = new ArrayList<>();
//        create an arrayadapter
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfItem);

            //set the adapter on the view
            listView.setAdapter(adapter);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String item = editText.getText().toString();
                    listOfItem.add(item);
                    adapter.notifyDataSetChanged();

//                    adapter.notifyDataSetCharacter();

//                    listView.setOnItemClickListener(this);
                }
            });
            //Remove item from list

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String item = parent.getItemAtPosition(position).toString();

                    listOfItem.remove(item);

                    adapter.notifyDataSetChanged();
                }
            });
        }

        catch (Exception e){

        }
        finally {

        }



    }
}