package ua.nure.dog.gameSetting;

public class GameTime {

    private int seconds;
    private int minutes;
    private int day;

    public GameTime() {
        seconds = 0;
        minutes = 0;
        day = 0;
    }

    public GameTime(int day, int minutes, int seconds) {
        this.day = day;
        this.minutes = minutes;
        this.seconds = seconds;

    }

    public String runTime() {
        increaseSecond();
        return getStringTime();
    }

    //***** inc

    private void increaseSecond() {
        if (seconds >= 59) {
            seconds = -1;
            increaseMinute();
        }
        seconds+=10;
    }

    private void increaseMinute() {
        if (minutes >= 23) {
            minutes = -1;
            increaseDay();
        }
        minutes++;
    }

    private void increaseDay() {
        day++;
    }

    //***** add

    private String addZeroToStringTime(int num) {
        if (num < 10) {
            return "0" + String.valueOf(num);
        }
        return String.valueOf(num);
    }

    private String addZeroBeforeTheDay(int i) {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(i)).reverse();
        while (stringBuffer.length() < 3) {
            stringBuffer.append("0");
        }
        return stringBuffer.reverse().toString();
    }

    //***** get

    private String getStringTime() {
        return addZeroToStringTime(minutes) + ":" + addZeroToStringTime(seconds);
    }

    public int getDayPart(int i) {
        switch (i) {
            case (0):
                return Character.getNumericValue(addZeroBeforeTheDay(day).charAt(i));
            case (1):
                return Character.getNumericValue(addZeroBeforeTheDay(day).charAt(i));
            case (2):
                return Character.getNumericValue(addZeroBeforeTheDay(day).charAt(i));
            default:
                return 0;
        }
    }

    public int getMinuteIn12hourFormat() {
        if (minutes > 11) {
            return (minutes - 12);
        }
        return (minutes);
    }

    //***** getter and setter

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}