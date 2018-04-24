# Harjoitustyö: Gravity Simulator
*Yksinkertainen kaksiulotteista painovoimaa noudattavan järjestelmän simulaattori*

[*Määrittelydokumentti*](https://github.com/Mustekala/otm-harjoitustyo/blob/master/GravitySimulator/dokumentaatio/vaatimusmaarittely.md)

[*Työaikakirjanpito*](https://github.com/Mustekala/otm-harjoitustyo/blob/master/GravitySimulator/dokumentaatio/tyoaikakirjanpito.md)

[*Arkkitehtuuri*](https://github.com/Mustekala/otm-harjoitustyo/blob/master/GravitySimulator/dokumentaatio/arkkitehtuuri.md)

[*Week 5 release*](https://github.com/Mustekala/otm-harjoitustyo/releases)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Gravitysimulator-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_
JavaDoc on vielä keskeneräinen

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/Mustekala/otm-harjoitustyo/blob/master/GravitySimulator/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
