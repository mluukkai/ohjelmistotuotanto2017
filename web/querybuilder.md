Esimerkkiratkaisu viikon 6 tehtävään QueryBuilder

_Not_ ja _Or_ ovat suoraviivaisia:

```java
public class Not implements Matcher {
    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;
    }
    
    @Override
    public boolean matches(Player p) {
        return !matcher.matches(p);
    }

}

public class Or implements Matcher {
    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }
    
    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if ( matcher.matches(p)) {
                return true;
            }
        }
        return false;
    }

}
```

_HasFewerThan_ on nyt mahdollista toteuttaa operaatioiden _HasAtLeast_ ja _Not_ avulla:

```java
public class HasFewerThan implements Matcher {
    private Matcher matcher;

    public HasFewerThan(int value, String category) {
        this.matcher = new Not( new HasAtLeast(value, category) );
    }

    @Override
    public boolean matches(Player p) {
        return matcher.matches(p);
    }
}
```

Operaatio _Or_ olisi pystytty toteuttamaan operaatioiden  _Not_ ja _And_  avulla soveltamalla [De Morganin lakeja](https://fi.wikipedia.org/wiki/De_Morganin_lait).

_QueryBuilderia_ varten tein myös ehdon _All_, joka palauttaa true kaikille pelaajille:

```java
public class All implements Matcher {

    @Override
    public boolean matches(Player p) {
        return true;
    }

}
```

_QueryBuilder_ osoittautui paikoin aika haastavaksi. Oma ratkaisuni on seuraava:

```java
public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }   

    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public Matcher build() {
        Matcher built = matcher;
        this.matcher = new All();
        return built;
    }

    public QueryBuilder hasAtLeast(int amount, String what) {
        matcher = new And(matcher, new HasAtLeast(amount, what));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int amount, String what) {
        matcher = new And(matcher, new HasFewerThan(amount, what));
        return this;
    } 
    
    public QueryBuilder oneOf(Matcher... matchers) {    
        matcher = new Or(matchers);
        return this;
    }    
}
```

Huomioin arvosta on se, että operaation _build_ yhteydessä rakennettava matcheri nollataan asettamalla matcheriksi kaikkille _true_ palauttava _All_-matcheri.