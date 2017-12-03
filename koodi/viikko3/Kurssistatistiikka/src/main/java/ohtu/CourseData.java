/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;

/**
 *
 * @author markokos
 */
public class CourseData {
    
    private String name,term,url;
    private int week;
    private ArrayList<Integer> exercises;

    public CourseData(String name, String term, String url, int week, ArrayList exercises) {
        this.name = name;
        this.term = term;
        this.url = url;
        this.week = week;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public String getUrl() {
        return url;
    }

    public int getWeek() {
        return week;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }
    
    
}
