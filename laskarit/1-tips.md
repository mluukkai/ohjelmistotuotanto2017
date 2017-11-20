## Vinkkejä laskariin 1

Joskus ohtun laskareissa tulee vastaan kaikkea sekalaista ongelmaa, joiden kanssa taisteleminen ei välttämättä ole parasta ajankäyttöä oppimiselle. Tähän kerätään opiskelijoilla vastaantulleita ongelmia ja ratkaisuja. Jos törmäät ongelmaan niin lisää oma vinkkisi tähän tiedostoon! Ongelman ei tarvitse olla vaikea eikä haittaa, jos ratkaisu tuntuikin ilmiselvältä. 

### 1. Komentorivi

### 2. Githubiin

### 3. Gitin alkeet

* Laskarien tehtäväs 3, siis gitignore tehtävä, kannattaa huomata et tarkotus on ignoraa vaan hakemisto build, eikä kaikkea mikä alkaa build
* Huomaa, että `.gitignore` on piilotiedosto (piste nimen eka merkki). Komennolla `ls -l` sitä ei näe, mutta `ls -la` näyttää myös piilotiedostot

### 4. Tiedostojen lisääminen githubin

### 5. Monta kloonia samasta repositoriosta

### 6. Repositorion siivous

### 7. Gradle

* opin, että netbeans ei avaa projektihakemistoa jos unohtaa asentaa gradle pluginin netbeansiin

### 8. JUnit

* opin, että JUnitin testit ei toimi jos ei lataa JUnit pluginia gradleen

### 9. TravisCI, osa 1

### 10. TravisCI, osa 2

### 11. TravisCI, osa 3

### 12. Codecov
* opin, että käytännössä näköjään tosi hidas odotella testituloksia näkyviksi

### 13. Parempi testauskattavuus

```
13:23 < opiskelija> 1. viikon tehtävässä 13 sanotaan "Siirrä pääohjelma pakkaukseen..", niin mikä on se pääohjelma tuossa?
13:25 <@mluukkai> se missä on main-metodi
13:25 < opiskelija> aaa, eli noita luokka-tiedostoja siirtelee vaan kansiosta toiseen?
13:26 <@mluukkai> joo
13:26 <@mluukkai> pitää myös varmistaa, että importit menee oikein. NB yleensä korjaa ne automaattisesti
13:27 < opiskelija> eli kun tuolta src:stä edetään parit kansiot alas päin, niin sieltä lopulta kun löytyy se main.java ->
                      siirretään ylempään kansioon main?
13:29 <@mluukkai> ├── main
13:29 <@mluukkai> │   └── java
13:29 <@mluukkai> │       └── ohtu
13:29 <@mluukkai> │           └── ohtuvarasto
13:29 <@mluukkai> │               ├── Main.java
13:29 <@mluukkai> │               └── Varasto.java
13:29 <@mluukkai> se on tollanen alunperin
13:29 <@mluukkai> src:n sisältö
13:29 < opiskelija> joo
13:29 < opiskelija> eli tuo Main.java ylemmäs main-kansioon?
13:31 <@mluukkai> ├── main
13:31 <@mluukkai> │   └── java
13:31 <@mluukkai> │       ├── ohtu
13:31 <@mluukkai> │       │   └── ohtuvarasto
13:31 <@mluukkai> │       │      └── Varasto.java
13:31 <@mluukkai> │       │
13:31 <@mluukkai>         └── main
13:31 <@mluukkai>              └──Main.java
13:31 <@mluukkai> tollanen olisi toivottava tulos
13:31 <@mluukkai> eli ei sinne src:n alla olevaan main:iin
13:31 <@mluukkai> hieman hämäävää, että sen pakkauksen nimi on main
13:32 <@mluukkai> koska siellä on myös se toinen "main"
13:33 < opiskelija> hetkinen, ohtu-kansiossakin siis main-kansio?
13:34 < opiskelija> vai javassa?
13:34 <@mluukkai> ei
13:34 <@mluukkai> java tarkottaa tuossa ns default-pakkausta. eli siellä olevat eivät ole missään pakkauksessa
13:35 <@mluukkai> pakkaukset tulevat java:n alle
13:35 <@mluukkai> esim ohtu ja ohtu/ohtuvarasto
13:35 <@mluukkai> jos halutaan pakkaus nimeltään main, se tulee myös java:n alle
13:35 <@mluukkai> ohtuvarasto on siis tässä ohtu:n "alipakkaus"
13:36 < opiskelija> eli java/main/Main.java?
13:36 <@mluukkai> juuri niin
```
* Täytyy myös muistaa muokata build.gradlessa ohtu.ohtuvarasto.Main --> main.Main


### 14. riippuvuuksien injektointi osa 1

### 15. riippuvuuksien injektointi osa 2: NHL-tilastot

### 16. NHLStatistics-ohjelman yksikkötestaus

* jos haluaa testeissä verrata pelaajien pelkkien nimien sijaan pelaajaolioita, täytyy Player-luokalle tehdä equals-metodi
* topScorers palauttaa yhden pelaajan enemmän kuin annettu parametri

### 17. Forkaa repositorio https://github.com/mluukkai/ohjelmistotuotanto2017
