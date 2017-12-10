//package ohtu;
//
//import java.util.HashMap;
//
//public class Komentotehdas {
//
//    private HashMap<String, Komento> komennot;
//
//    public Komentotehdas(IO io) {
//        komennot = new HashMap<String, Komento>();
//        komennot.put("summa", new Summa(io));
//        komennot.put("tulo", new Tulo(io));
//        komennot.put("nelio", new Nelio(io));
//        komennot.put("tuntematon", new Tuntematon(io));
//    }
//
//    public Komento hae(String operaatio) {
//        Komento komento = komennot.get(operaatio);
//        if (komento == null) {
//            komento = komennot.get("tuntematon");
//        }
//        return komento;
//    }
//    
//}


