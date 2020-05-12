# Alkalmazásfejlesztés-I gyakorlat Állatkert project

## 1. Beüzemelés
1. Megjegyzés: a programot Ubuntu operációs rendszeren írtam, Windows rendszeren **NEM** teszteltem 
2. Az adatbázis csatlakozási stringje az allatkert-core/resources/db.properties fileban található, ezt át kell írni az általad választott útvonalra
3. A webes modulnál a Tomcatet az alábbiak szerint állítottam be:
   - a run/debug confirgurationsnél a Deployment fülön az Application context üresre volt állítva
   - a run/debug confirgurationsnél az URL http://localhost:8080/ -ra volt állítva
   - ezek a beállítások nálam azért kellettek, mert valamiért az index.jsp-ben nem értékelődött ki jól az URL String, és ezek a beállítások oldották meg a problémát


## 2. Funkciók

A projecten belül 3 modul található: allatkert-core, allatkert-desktop és allatkert-web

1. Allatkert-core:
   - model és controller osztályok
   - jelszó titkosítás
   - sql injection elleni védelem
   - erőforrások lezárása
2. Allatkert-desktop:
   - állatok listázása, módosítása, törlése, hozzáadása, örökbefogadottság alapján való szűrés
   - örökbefogadók listázása, módosítása, törlése, hozzáadása
   - könyvelések listázása, törlése, hozzáadása, szűrés örökbefogadó, örökbefogadott, időpont és támogatás típusa szerint
   - többszálúság a delete,update,insert műveleteknél
   - külső css file használata
   - validáció:
     - email formátum
     - a támogatás típusától függően jelenik meg az összeg és a mennyiség mező
     - kötelezően kitöltendő mezők
   - képek base64 kódolása, base64 kód táblázatban történő képpé alakítása
3. Allatkert-web:
   - örökbefogadó bejelentkezés/regisztráció
   - állatok listázása, örökbefogadottság alapján való szűrés
   - örökbefogadók listázása
   - könyvelések listázása, szűrés örökbefogadó, örökbefogadott, időpont és támogatás típusa szerint
   - az adott felhasználó által örökbefogadható állatok listázása
   - állat örökbefogadása
   - session kezelés
   - külső css file használata
   
## 3.Használt verziók:
1. Operációs rendszer: Ubuntu 18.04 LTS
2. Fejlesztői környezet: IntelliJ IDEA Ultimate 2019.3 
3. Java: 12.0.2
4. Tomcat: 9.0.33
