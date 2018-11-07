Objektorienterad programvaruutveckling

Lab 1
=====
Gruppnummer: 20
Therese Sturesson 
Josefin Ulfenborg


Uppgifter Del A
===============

A1
==
Svar: Kommandot för att återvända till hembiblioteket är ‘cd’.

A3
==
Svar: Kommandot för att få utskriften som i exemplet är ls -la.
Kolumn 1: Visar rättigheterna för filerna (se nedan)*Kolumn 3: Vi förstår det som att det är den som skapat mappenKolumn 4: När vi testar så står det ”staff”, inte helt säkra på vad just det 
innebär men vi gissade på att det har något med rättigheterna över dokumentet 
att göra. Kolumn 6-8: Datumet och tid när dokumentet senast öppnades.Kolumn 9: Filerna, de med ’.’ framför är dolda filer i mappen. Vi är inte säkra på kolumn 2 och 5.

* Gällande rättigheterna:  För en av Java-filerna i mappen står det -rw-r--r--@ 
i kolumn 1, där r = Read permissions, w = Write permissions,
x = Execute permissions. Bindessträcket i början anger att det är en fil.	Efter det kommer tre grupper med tre tecken i varje grupp, där första gruppen
är User, andra gruppen är Group och tredje är World. De tre tecknen kan vara rwx,
och om det skulle stå rwxrwxrwx, skulle samtliga grupper ha rätt att ändra på 
filen. Ser man nu på första gruppen så står det bara rw-, vilken antyder på att 
användaren inte har Execute permissions, medan de andra två grupperna bara har 
read permissions. Så nej, User har inte rättigheter till att göra allt, och de 
andra två grupperna har endast rättigheten att läsa. A4
==
Svar: Efter att ha skrivit in kommandot chmod go-rwx tda545 (eller chmod 
go-rwx .) så ändras rättigheterna till –rw-------@, vilket innebär att 
rättigheterna för Group och World har ändrats, så numera har de inga rättigheter 
alls. User har dock fortfarande inte execute permissions. Kommandot, skrivet 
såhär, tar med andra ord bort rättigheterna för alla utom User.

A5
==
Svar: Efter att ha skrivit in kommandot touch test, så skapades en ny fil test 
med samma rättigheter som de andra filerna (dvs -rw-r--r--), så ja, filen är 
fortfarande läsbar för alla andra också. 



Uppgifter Del B
===============

B.8
===
a)
error: '{' expected
public class HelloWorld
                       ^
1 error

Svar: Programmet pekar ut felet väldigt tydligt (pilen indikerar var felet 
ligger), och så skrivs det även vad som saknas ({)

b)
error: reached end of file while parsing
      }
       ^
1 error

Svar: Den här gången är pilen inte så tydlig (pekar på måsvingen innan), medan 
texten är mer förklarande. 

c)
Svar: Vi fick inget felmeddelande, så för oss blev det ingen skillnad ("Hello 
World!" kom upp ändå). Som vi förstår så, utan public så blir det ett mellanting 
mellan public och private, dock på sådanna här små program så blir det ingen 
skillnad. 

d)
Error: Main method is not static in class HelloWorld, please define the main 
method as:
   public static void main(String[] args)
   
Svar: Den kompilerade som vanlig, dock dök felmeddelandet upp när vi försökte 
köra programmet. Meddelandet är väldigt detaljerat på vad exakt det är som är 
fel, dock är vi osäkra på vad static gör.

e)
HelloWorld.java:11: error: <identifier> expected
      public satic void main(String[] args) {
                  ^
HelloWorld.java:11: error: invalid method declaration; return type required
      public satic void main(String[] args) {
                        ^
2 errors

Svar: Första felet stämmer och pekar ut vad som är fel (felstavningen). Men sen, 
pga felstavningen, så får vi ett följdfel som vi inte riktigt förstår. 
















