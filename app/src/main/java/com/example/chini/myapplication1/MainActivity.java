package com.example.chini.myapplication1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView();


    }


    private void listView() {
        String[] myNames = {"Sachin","Papa","Mom","Brother"};
        String[] desc = {"Hello Everyone it's me","Let's meet the daddy","Don't forget to take the Blessings","There's the Dude"};
        Integer[] img1 ={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
          myAdapter adapter=new myAdapter(this,myNames,desc,img1);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);


    }
    class myAdapter extends ArrayAdapter<String>
    {
        private final Activity mycontext;
        private final String[] name;
        private final String[] description;
        private final Integer[] imageIds;

        myAdapter(Activity givenContext,String[] givenNames,String[] givenDescriptions,Integer[] givenImages){
            super(givenContext, R.layout.list1,givenNames );
            mycontext=givenContext;
            name=givenNames;
            description=givenDescriptions;
            imageIds=givenImages;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
View rowView =convertView;

                LayoutInflater inflater = mycontext.getLayoutInflater();
                rowView = inflater.inflate(R.layout.list1, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.t1);
            TextView textView2 = (TextView) rowView.findViewById(R.id.textView2);
            ImageView imgv = (ImageView) rowView.findViewById(R.id.imageView2);
            textView.setText(name[position]);
            textView2.setText(description[position]);
            imgv.setImageResource(imageIds[position]);
            return rowView;



        }
    }

}