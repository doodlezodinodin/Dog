package ua.nure.dog;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ua.nure.dog.game.Dog;
import ua.nure.dog.gameSetting.GameTime;
import ua.nure.dog.gameSetting.ListImage;

public class Stage extends AppCompatActivity {

    private Dog dog;
    private ListImage listImage;
    private GameTime gameTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        dog = new Dog(getIntent().getStringExtra("nameDog"));
        listImage = new ListImage();

        runTime();
        outputStats();
        listenerImageButton();
    }

    public void listenerImageButton() {
        ImageButton imgBtn_lockClose = findViewById(R.id.imgBtn_lockClose);

        imgBtn_lockClose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message = "Тебе нужен ключ, для того чтобы открыть этот замок.";
                        Toast.makeText(Stage.this, message, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void runTime() {
        gameTime = new GameTime();

        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {
                outputTextViewTime();
                outputImageViewTime();
                outputImageViewDay();

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


        tv_nameDog.setText(dog.getName());

        tv_statsStars.setText(String.valueOf(dog.getStars()));
        tv_statsDiamonds.setText(String.valueOf(dog.getDiamonds()));

        tv_statsFood.setText(String.valueOf(dog.getFood()));
        tv_statsClean.setText(String.valueOf(dog.getClean()));
        tv_statsNeed.setText(String.valueOf(dog.getNeed()));
    }

    public void outputTextViewTime() {
        final TextView tv_time = findViewById(R.id.tv_time);
        tv_time.setText(gameTime.runTime());
    }

    public void outputImageViewTime() {
        final ImageView imgView_time = findViewById(R.id.imgView_time);
        imgView_time.setImageResource(listImage.getIndexImageTime(gameTime.getMinuteIn12hourFormat()));
    }

    public void outputImageViewDay() {
        final ImageView imgView_num0 = findViewById(R.id.imgView_num0);
        final ImageView imgView_num1 = findViewById(R.id.imgView_num1);
        final ImageView imgView_num2 = findViewById(R.id.imgView_num2);


        imgView_num0.setImageResource(listImage.getIndexImageDay(gameTime.getDayPart(2)));


        if (gameTime.getDay() > 9) {
            imgView_num1.setVisibility(View.VISIBLE);
        }
        imgView_num1.setImageResource(listImage.getIndexImageDay(gameTime.getDayPart(1)));

        if (gameTime.getDay() > 99) {
            imgView_num2.setVisibility(View.VISIBLE);
        }
        imgView_num2.setImageResource(listImage.getIndexImageDay(gameTime.getDayPart(0)));
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(Stage.this);
        a_builder.setMessage("Ты действительно хочешь выйти из игры?")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Выход");
        alert.show();
    }
}

//сделать константу размера значков
//убрать фон у значков
//stats сделать image_button
//запустить статистику
//добавить еду
//добавить одежду
//добавить игры
//добавить года