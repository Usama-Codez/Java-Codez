package com.example.counterapp.ListViewExample.MultiColumnListViewExample;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.counterapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class multi_column_list_view_main_activity extends AppCompatActivity {

    ListView listView;
    public ArrayList<HashMap<String,String>> list;
    public static final String First_Column = "First Column";
    public static final String Second_Column = "Second Column";
    public static final String Third_Column = "Third Column";
    public static final String Fourth_Column = "Fourth Column";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multi_column_list_view_main_activity);
        listView = findViewById(R.id.lstmlticolumn);

        LoadData();
        my_multi_column_list_adapter adapter = new my_multi_column_list_adapter(this, list);
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void LoadData(){
        list = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> hashMap1 = new HashMap<String, String>();
        hashMap1.put(First_Column, "I");
        hashMap1.put(Second_Column, "am");
        hashMap1.put(Third_Column, "Usama");
        hashMap1.put(Fourth_Column, "Akram");

        list.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        hashMap2.put(First_Column, "Created");
        hashMap2.put(Second_Column, "this");
        hashMap2.put(Third_Column, "list");
        hashMap2.put(Fourth_Column, "view");

        list.add(hashMap2);

        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        hashMap3.put(First_Column, "Apple");
        hashMap3.put(Second_Column, "Mango");
        hashMap3.put(Third_Column, "Orange");
        hashMap3.put(Fourth_Column, "Strawberry");

        list.add(hashMap3);

        HashMap<String, String> hashMap4 = new HashMap<String, String>();
        hashMap4.put(First_Column, "This");
        hashMap4.put(Second_Column, "is");
        hashMap4.put(Third_Column, "my Roll No:");
        hashMap4.put(Fourth_Column, "21F-9217");

        list.add(hashMap4);

    }
}