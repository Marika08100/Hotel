Írj egy Spring Boot alkalmazást, ami egy szállodai foglalási rendszert szimulál!
Adatbázisban legyenek eltárolva a szállodai szobák tulajdonságai (szobaszám, max. férőhely, éjszakénkénti ár, van-e jakuzzi, van-e szauna), a vendégek adatai (titulus, vezetéknév, keresztnév, születési hely, születési idő, személyi szám, email) illetve a foglalások adatai (melyik vendég melyik szobában mettől-meddig tartózkodik).
Valósítsd meg, hogy lehessen új vendégeket felvenni a rendszerbe és a meglévőket frissíteni, de ne lehessen vendégeket törölni!
Valósítsd meg, hogy lehessen foglalásokat létrehozni, módosítani és törölni! A foglalásoknál figyelj oda, hogy egy szobában többen is tartózkodhatnak, de ez a szám nem lépheti túl az adott szoba max. férőhelyét!
Új szállodai szobákat ne lehessen se felvenni, se törölni, ám legyenek módosíthatóak a meglévők!
Lehessen továbbá statisztikákat lekérni
a szálloda jelenlegi telítettségéről
a szállodai adott napon lévő telítettségéről
az adott időintervallumnban elérhető szobákről
lehessen lekérni egy adott foglalás végösszegét
lehessen lekérni egy adott napon melyik vendég(ek)nek van születésnapja

Szorgalmi: Vendégeket továbbra se lehessen törölni, de archiválni igen! Ez az ún. logikai törlés, egy flaget be lehet állítani a vendégre, hogy inaktív. Az adatbázisból fizikailag nem törlődik, de egyik lekérdezés sem adhatja őt vissza!
Guglizni szabad: JPA many to many (vagy nem lesz rá szükség? te tudod :)), Java MySQL date (dátumkezeléshez)