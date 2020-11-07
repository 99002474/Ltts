package com.example.ltts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    private Button glimpseButton,winnersButton,dussehraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);
        Integer[] eventLogo = {R.drawable.dance,R.drawable.music,R.drawable.photography,R.drawable.poetry,R.drawable.specialentries,R.drawable.sketching};
        String[] eventName = {"Dance","Music","Photography","Poetry","Special Entries","Sketching"};

        mainModels = new ArrayList<>();
        for (int i = 0; i <eventLogo.length; i++)
        {
            MainModel model=new MainModel(eventLogo[i],eventName[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager= new LinearLayoutManager(SecondActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter=new MainAdapter(SecondActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);

        dussehraButton = (Button)findViewById(R.id.dussehraButton);
        dussehraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDussehraActivity();
            }
        });

        winnersButton=(Button)findViewById(R.id.winnersButton);
        winnersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWinnersActivity();
            }
        });
        glimpseButton = (Button) findViewById(R.id.glimpseButton);
        glimpseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthirdActivity();
            }
        });
    }
    public void openDussehraActivity(){
        Intent intent = new Intent(this,ApiActivity.class);
        startActivity(intent);
    }

    public void openWinnersActivity() {
        Intent intent = new Intent(this, WinnersActivity.class);
        startActivity(intent);
    }

    public  void openthirdActivity()
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void popup(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(SecondActivity.this);

        builder.setTitle(Html.fromHtml("<font color='#1c68eb'>About the event</font>"));
        builder.setMessage("TS GOT TALENT is conducted during Dussehra to showcase talent of individuals\n\n"+
                "--> No.of Submits : 84\n\n"+
                "--> No. of Viewers : 192\n\n"+
                "-->Organisers of the event :\n\n"+
                "   1) Kemba Krishna Lalasa\n" +
                "   2) Neeraja\n" +
                "   3) Sowmya Rajendar\n" +
                "   4) Sneha S\n" +
                "   5) Parth Jain\n" +
                "   6) Prajwal Rao\n" +
                "   7) Yuvateja");
        builder.setIcon(R.drawable.about);

        builder.setPositiveButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this,"thanks for viewing",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}