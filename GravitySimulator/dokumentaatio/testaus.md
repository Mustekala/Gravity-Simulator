# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Sovelluslogiikkaa on testattu niiltä osin kuin se onnistui ilman ongelmia. Peliloopin testaaminen oli hyvin vaikeaa, joten se on jäänyt vähemmälle.

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/testaus_domain.png" width="340">

### DAO-luokat

DAO-luokan toiminnallisuus on testattu testaamalla tallennus- sekä lataamisluokkia.

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/testaus_dao.png" width="340">

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 80% ja haarautumakattavuus 69%.

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/testaus_kaikki.png" width="340">

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja kanfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kayttoohje.md) kuvaamalla tavalla Linux-käyttöjärjestelmällä.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/vaatimusmaarittely) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi.

## Sovellukseen jääneet laatuongelmat

Tyhjät kentät pelissä aiheuttavat virheilmoituksen, jos yrittää lisätä kappaleita.


