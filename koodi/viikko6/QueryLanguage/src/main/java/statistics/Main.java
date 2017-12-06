package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
//          
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }

//        Matcher m2 = new Not(new HasAtLeast(1, "goals"));
//
//        for (Player player : stats.matches(m2)) {
//            System.out.println(player);
//        }
//        Matcher m = new Or(new HasAtLeast(40, "goals"),
//                new HasAtLeast(60, "assists"),
//                new HasAtLeast(85, "points")
//        );
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
//        Matcher m = new HasFewerThan(1, "goals");
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
        QueryBuilder query = new QueryBuilder();

//        Matcher m = query.playsIn("NYR")
//                .hasAtLeast(10, "goals")
//                .hasFewerThan(25, "assists").build();
//
//
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
////        
//                Matcher m1 = query.playsIn("PHI")
//                .hasAtLeast(10, "goals")
//                .hasFewerThan(20, "assists").build();
//
//        Matcher m2 = query.playsIn("EDM")
//                .hasAtLeast(60, "points").build();
////
//        Matcher m = query.oneOf(m1, m2);
//        Matcher m = query.oneOf(
//                query.playsIn("PHI")
//                        .hasAtLeast(10, "goals")
//                        .hasFewerThan(20, "assists").build(),
//                query.playsIn("EDM")
//                        .hasAtLeast(60, "points").build()
//        ).build();
//
        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m = query.oneOf(m1, m2).build();
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
