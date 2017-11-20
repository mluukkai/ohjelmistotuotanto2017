package ohtu;

<<<<<<< HEAD
import java.util.List;

public class Submission {
    private int week;
    private double hours;
    private List<Integer> exercises;

    public List<Integer> getExercises() {
        return exercises;
    }

    public double getHours() {
        return hours;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
=======
public class Submission {
    private int week;
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return ""+week;
    }
    
}