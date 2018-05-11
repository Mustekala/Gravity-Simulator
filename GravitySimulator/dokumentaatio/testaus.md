# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Sovelluslogiikkaa on testattu niiltä osin kuin se onnistui ilman ongelmia. Peliloopin(AnimationTimer) testaaminen oli hyvin vaikeaa, joten se on jäänyt pois.

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/testaus_domain.png" width="640">

### DAO-luokat

DAO-luokan toiminnallisuus on testattu testaamalla tallennus- sekä lataamisluokkia.

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/testaus_dao.png" width="640">

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 80% ja haarautumakattavuus 69%.

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/testaus_kaikki.png" width="640">

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kayttoohje.md) kuvaamalla tavalla Linux-käyttöjärjestelmällä.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/vaatimusmaarittely.md) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi.


