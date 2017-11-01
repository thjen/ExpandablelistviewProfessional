package com.example.thjen.demoproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DialogAddChild extends AppCompatActivity {

    Button btDone;
    EditText et_addChild;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        et_addChild = (EditText) findViewById(R.id.et_addchild);
        btDone = (Button) findViewById(R.id.btDone);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("positon");

        MainActivity.addlist = new ArrayList<ItemChild>();

        MainActivity.addlist.add(new ItemChild("Tong: ", 13, "Yes"));
        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.addlist.add(new ItemChild(et_addChild.getText().toString(), 13, "Yes"));

                MainActivity.listChild.put(MainActivity.listGroup.get(position), MainActivity.addlist);
                startActivity(new Intent(DialogAddChild.this, MainActivity.class));
            }
        });

    }

}
