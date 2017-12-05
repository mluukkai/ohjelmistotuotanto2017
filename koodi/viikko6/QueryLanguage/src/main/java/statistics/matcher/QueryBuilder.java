/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oce
 */
public class QueryBuilder {

    List<Matcher> matcher;
    boolean or = false;

    public QueryBuilder() {
        matcher = new ArrayList<>();
    }


    public QueryBuilder hasAtLeast(int value, String category) {
        matcher.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matcher.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matcher.add(new PlaysIn(team));
        return this;
    }

    public Matcher build() {
        Matcher[] matchers = new Matcher[matcher.size()];
        
        int i = 0;
        for (Matcher matcher1 : matcher) {
            matchers[i] = matcher1;
            i++;
        }
        this.matcher = new ArrayList<>();
        if (this.or) {
            return new Or(matchers);
        } else {
            return new And(matchers);
        }
        
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.or = true;
        this.matcher = new ArrayList<>();
        for (Matcher matcher1 : matchers) {
            this.matcher.add(matcher1);
        }
        return this;
    }
}
