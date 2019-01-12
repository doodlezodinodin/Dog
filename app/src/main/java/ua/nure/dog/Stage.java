package ua.nure.dog;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ua.nure.dog.game.Dog;
import ua.nure.dog.gameSetting.GameTime;

public class Stage extends AppCompatActivity {

    private Dog dog;

    private Integer[] listImageTime = {
            R.drawable.time0000, R.drawable.time0100, R.drawable.time0200,
            R.drawable.time0300, R.drawable.time0400, R.drawable.time0500,
            R.drawable.time0600, R.drawable.time0700, R.drawable.time0800,
            R.drawable.time0900, R.drawable.time1000, R.drawable.time1100
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        dog = new Dog(getIntent().getStringExtra("nameDog"));
        runTime();
        outputStats();
    }

    public void runTime() {
        final TextView tv_time = findViewById(R.id.tv_time);
        final ImageView imageView = findViewById(R.id.imgView_time);

        final GameTime gameTime = new GameTime();

        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {
                tv_time.setText(gameTime.run());
                imageView.setImageResource(listImageTime[gameTime.getMinutes()]);
                handler.postDelayed(this,10); // set time here to refresh textView
            }
        });
    }

    public void outputStats() {
        TextView tv_nameDog = findViewById(R.id.tv_nameDog);

        TextView tv_statsStars = findViewById(R.id.tv_statsStars);
        TextView tv_statsDiamonds = findViewById(R.id.tv_statsDiamonds);

        TextView tv_statsFood = findViewById(R.id.tv_statsFood);
        TextView tv_statsClean = findViewById(R.id.tv_statsClean);
        TextView tv_statsNeed = findViewById(R.id.tv_statsNeed);
        TextView tv_statsPlay = findViewById(R.id.tv_statsPlay);

        //*****

        tv_nameDog.setText(dog.getName());

        tv_statsStars.setText(String.valueOf(dog.getStars()));
        tv_statsDiamonds.setText(String.valueOf(dog.getDiamonds()));

        tv_statsFood.setText(String.valueOf(dog.getFood()));
        tv_statsClean.setText(String.valueOf(dog.getClean()));
        tv_statsNeed.setText(String.valueOf(dog.getNeed()));
        tv_statsPlay.setText(String.valueOf(dog.getPlay()));
    }
}

//Закрыть main_activity
//посмотреть лабы Паше
