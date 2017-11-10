## Vinkkejä laskariin 2

Joskus ohtun laskareissa tulee vastaan kaikkea sekalaista ongelmaa joiden kanssa taisteleminen ei välttämättä ole parasta ajankäyttöä oppimiselle. Tähän kerätään opiskelijoilla vastaantulleita ongelmia ja ratkaisuja. Jos törmäät ongelmaan niin lisää oma vinkkisi tähän tiedostoon! Ongelman ei tarvitse olla vaikea eikä haittaa, jos ratkaisu tuntuikin ilmiselvältä. 

## 1. gradlen perusteita

Gradlen uusimmat versiot (ainakaan 4.3) eivät näköjään enää lähtökohtaisesti tulosta tutoriaalissa mainittuja rivejä
```
:compileJava NO-SOURCE
:processResources NO-SOURCE
:classes UP-TO-DATE
```

jne. 
Ne saa näkyviin optiolla <code>--console=plain</code>, eli esim. komennon <code>gradle build</code> sijaan <code> gradle --console=plain build</code>.

## 2. lisää gradlea: koodin staattinen analyysi

Telegramista:

> Nyt jouduin hukkaan 2 vkon 2 tehtävän kohdan poista tree walker sisällä olevat tarkistukset kohdan kanssa.. voiskohan joku avulias selventää mitä tällä tarkoitetaan?

vastaus:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Puppy Crawl//DTD Check Configuration 1.3//EN" "http://www.puppycrawl.com/dtds/configuration_1_3.dtd">
<module name="Checker">

    <module name="TreeWalker">
        <module name="JavadocMethod"/>
        <module name="JavadocType"/>
           monta riviä
        <module name="TodoComment"/>
        <module name="UpperEll"/>
    </module>

</module>
```

siis tuosta pois nuo TreeWalker kohdan alla/sisällä olevat

niin että lopputulos on

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Puppy Crawl//DTD Check Configuration 1.3//EN" "http://www.puppycrawl.com/dtds/configuration_1_3.dtd">
<module name="Checker">

    <module name="TreeWalker">
    </module>

</module>
```

sitten lisäillään tehtävän mukasia sääntöjä TreeWalkerin alle, samoin kun ne poistetut olivat

----------
* checkstyle.xml: koodin pitää alkaa heti ensimmäiseltä riviltä. Jos alussa on tyhjä rivi, tulee ongelmia.

## 3. codacy

## 4. git: branchit

## 5. git: branchit ja staging-alue

## 6. git: konflikti!

## 7. git: branchit ja GitHub

## 8. git: epäajantasaisen kopion pushaaminen

## 9. riippuvuuksien injektointi osa 3: Verkkokauppa

## 10. riippuvuuksien injektointi osa 4: ei enää singletoneja verkkokaupassa

## 11 Spring osa 1: Verkkokauppa siistiksi

## 12. Spring osa 2: Verkkokauppa siistiksi annotaatioilla
