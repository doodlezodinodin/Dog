package ua.nure.dog.gameSetting;

public class GameTime {

    private int minutes;
    private int seconds;

    public GameTime() {
        seconds = 0;
        minutes = 0;
    }

    public String run() {
        incTime();
        return getStringTime();
    }

    private void incTime() {
        if (seconds == 59) {
            seconds = 0;

            if (minutes == 23) {
                minutes = 0;
            } else {
                minutes++;
            }
        }
        seconds++;
    }

    private String getStringTime() {
        return numberAdjustment(minutes) + ":" + numberAdjustment(seconds);
    }

    private String numberAdjustment(int num) {
        if (num < 10) {
            return "0" + String.valueOf(num);
        }
        return String.valueOf(num);
    }

    public int getMinutes() {
        if (minutes > 11) {
            return (minutes - 12);
        }
        return (minutes);
    }
}