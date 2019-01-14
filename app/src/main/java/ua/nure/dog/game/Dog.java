package ua.nure.dog.game;

public class Dog {

    private String name;

    private int stars;
    private int diamonds;

    private int life;
    private int food;
    private int sleep;
    private int clean;
    private int need;

    public Dog(String name) {
        this.name = name;

        stars = 10;
        diamonds = 1;

        life = 100;
        food = 100;
        sleep = 100;
        clean = 100;
        need = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getClean() {
        return clean;
    }

    public void setClean(int clean) {
        this.clean = clean;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }
}
