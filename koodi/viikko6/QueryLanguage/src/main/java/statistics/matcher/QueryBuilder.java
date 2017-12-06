package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {

//    private Matcher[] matchers;
    private List<Matcher> matchers = new ArrayList<>();
    private boolean or;

//    public QueryBuilder and(Matcher... matcher) {
//        this.matchers = matchers
//        
//        this.matchers.add(new And());
//        return this;
//    }
//    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
//    public QueryBuilder not(Matcher... matcher) {
//        this.matcher = new Not();
//        return this;
//    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.or = true;
        this.matchers = new ArrayList<>();
        for (Matcher matcher1 : matchers) {
            this.matchers.add(matcher1);
        }
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public Matcher build() {
        Matcher[] m = new Matcher[matchers.size()];
        for (int i = 0; i < this.matchers.size(); i++) {
            m[i] = this.matchers.get(i);
        }
        this.matchers = new ArrayList<>();
        if (this.or) {
            return new Or(m);
        } else {
            return new And(m);
        }

    }

}
