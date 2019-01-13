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

    public String run() {
        incTime();
        return getStringTime();
    }

    private void incTime() {
        if (seconds == 59) {
            seconds = 0;

            if (minutes == 23) {
                minutes = 0;
                day++;
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

    public int getDay(int i) {
//        String s = addZeroBeforeTheNumber(day);
//        char a = s.charAt(0);
//        int b = Character.getNumericValue(a);

        switch (i) {
            case (0):
                return Character.getNumericValue(addZeroBeforeTheNumber(day).charAt(i));
            case (1):
                return Character.getNumericValue(addZeroBeforeTheNumber(day).charAt(i));
            case (2):
                return Character.getNumericValue(addZeroBeforeTheNumber(day).charAt(i));
            default:
                return 0;
        }
    }

    private String addZeroBeforeTheNumber(int i) {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(i)).reverse();
        while (stringBuffer.length() < 3) {
            stringBuffer.append("0");
        }
        return stringBuffer.reverse().toString();
    }
}