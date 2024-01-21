package com.example.custom_simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] animalName={"Lion","Monkey"};
    String[] descri={"animal 01","animal 02"};
    int[] animalImages={R.drawable.lion,R.drawable.monkey};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

list=(ListView)findViewById(R.id.list);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

        for(int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",animalName[i]);
            hashMap.put("des",descri[i]);
            hashMap.put("image",animalImages[i]+"");
            arrayList.add(hashMap);


        }
         String[] from={"name","image","des"};
        int[] to={R.id.textView,R.id.imageView,R.id.textView2};


        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.custom_layout,from,to);
        list.setAdapter(simpleAdapter);




        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),animalName[i],Toast.LENGTH_LONG).show();

            }
        });


    }
}