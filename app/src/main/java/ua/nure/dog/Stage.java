package ua.nure.dog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ua.nure.dog.one.Dog;

public class Stage extends AppCompatActivity {

    private Dog dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        dog = new Dog(getIntent().getStringExtra("nameDog"));
        outputStats();
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

//Посмотреть какие файлы добавлять в git
//Добавить часы
//Закрыть main_activity
//посмотреть лабы Паше
