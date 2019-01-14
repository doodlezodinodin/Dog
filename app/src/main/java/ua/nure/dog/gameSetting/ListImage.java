package ua.nure.dog.gameSetting;

import ua.nure.dog.R;

public class ListImage {

    private Integer[] imageTime = {
            R.drawable.time0000, R.drawable.time0100, R.drawable.time0200,
            R.drawable.time0300, R.drawable.time0400, R.drawable.time0500,
            R.drawable.time0600, R.drawable.time0700, R.drawable.time0800,
            R.drawable.time0900, R.drawable.time1000, R.drawable.time1100
    };

    private Integer[] imageDay = {
            R.drawable.number0, R.drawable.number1, R.drawable.number2,
            R.drawable.number3, R.drawable.number4, R.drawable.number5,
            R.drawable.number6, R.drawable.number7, R.drawable.number8,
            R.drawable.number9
    };

    public Integer getIndexImageTime(int i) {
        return imageTime[i];
    }

    public Integer getIndexImageDay(int i) {
        return imageDay[i];
    }

}
