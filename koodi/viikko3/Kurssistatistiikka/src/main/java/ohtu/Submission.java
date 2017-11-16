package ohtu;

import java.util.ArrayList;

public class Submission {
    
    private int week;
    private int hours;
    private ArrayList<Integer> exercises;
    private int max;
    

    public Submission(int week, int hours, ArrayList exercises) {
        this.week = week;
        this.hours = hours;
        this.exercises = exercises;
    }
    

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }

    public int getWeek() {
        return week;
    }
    
    public void setMax(int max){
        this.max = max;
    }

    @Override
    public String toString() {
        return "viikko " + this.week + " tehtyjä tehtäviä yhteensä: " + this.exercises.size() + " (maksimi:" + this.max +  "), aikaa kului " + this.hours + " tuntia, tehdyt tehtävät: " + this.exercises;
    }


    
}