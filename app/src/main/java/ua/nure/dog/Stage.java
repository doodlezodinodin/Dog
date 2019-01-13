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

    private Integer[] listImageDay = {
            R.drawable.number0, R.drawable.number1, R.drawable.number2,
            R.drawable.number3, R.drawable.number4, R.drawable.number5,
            R.drawable.number6, R.drawable.number7, R.drawable.number8,
            R.drawable.number9
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

//        final TextView tv_day = findViewById(R.id.tv_day);
        final ImageView imgView_num0 = findViewById(R.id.imgView_num0);
        final ImageView imgView_num1 = findViewById(R.id.imgView_num1);
        final ImageView imgView_num2 = findViewById(R.id.imgView_num2);

        final GameTime gameTime = new GameTime(123, 22, 0);

        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {
                tv_time.setText(gameTime.run());
                imageView.setImageResource(listImageTime[gameTime.getMinutes()]);

                imgView_num0.setImageResource(listImageDay[gameTime.getDay(2)]);
                imgView_num1.setImageResource(listImageDay[gameTime.getDay(1)]);
                imgView_num2.setImageResource(listImageDay[gameTime.getDay(0)]);

                handler.postDelayed(this,1); // set time here to refresh textView
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
