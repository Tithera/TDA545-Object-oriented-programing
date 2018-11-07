Utdatan från RatNumTest3 med indata från indata.txt:

>>>> Test av equals: Vi har inte gått igenom equals ännu
så du behöver inte klara dessa tester än
<<<< Slut på equals tester
Skriv uttryck på formen a/b ? c/d, där ? är något av tecknen + - * / = <
> 1/3 + 1/4	--> 7/12
> 2/9 * -4/5	--> -8/45
> 2/6 - 7/9	--> -4/9
> 7/-2 / -2/5	--> 35/4
> -5/10 + -3/4	--> -5/4
> -5/3 * 4	--> -20/3
> 7/9 * 2	--> 14/9
> -5 * 1/3	--> -5/3
> 2 / -5	--> -2/5
> 2/5 = 40/100	--> true
> 6/18 = -1/3	--> false
> 2/9 < 1/5	--> false
> -5/9 < 1/2	--> true
> 1/2 +1/3	--> Felaktigt uttryck!
> 1/5	--> Felaktigt uttryck!
> /4 + 1/3	--> NumberFormatException: For input string: ""
> 5/ + 1/3	--> NumberFormatException: For input string: ""
> 1//4 + 1/4	--> NumberFormatException: Invalid denominator: /4
> 1/ - 2 + 1/3	--> Felaktigt uttryck!
> 1/3 a + 1/3	--> Felaktigt uttryck!
> -/3 + 1/3	--> NumberFormatException: For input string: "-"
> 1/3 + 1/3 + 1/3	--> Felaktigt uttryck!
> 1/3 & 1/3	--> Felaktig operator!
> 1/0 + 1/3	--> NumberFormatException: Denominator = 0
> 1 / 0	--> NumberFormatException: Denominator = 0

DOKUMENTATION RatNumTest3
=========================

I RatNumTest3:s main-metod testats först RNT2:s divTester-metod och sedan anropar den sin egen divTester för att kontrollera att vårt program fungerar korrekt. Sedan förbereder sig main-metoden för att läsa in indata från antingen maskin eller människa. Beroende på vilken sorts indata programmet får, från maskin eller människa, så körs olika delar av koden. ratNumToString förenklar talet och ändrar hur den ser ut. Talet går från att se ut som a/b till h c/d vilket blir lättare att läsa av. Dock så används aldrig den här funktionen i programmet. divTester metod går igenom och kontrollerar så att våran equals och toDouble fungerar via ett antal funktioner, genom att använda olika RatNum som definieras i metoden. Om det är något som inte stämmer får vi olika felmeddelande beroende på vad och var det är fel. 
