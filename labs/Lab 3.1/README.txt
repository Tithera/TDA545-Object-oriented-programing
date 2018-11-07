Objektorienterad programvaruutveckling

Lab 1
=====
Gruppnummer: 20
Therese Sturesson 
Josefin Ulfenborg
Editor: Smultron

Del 1
=====

b) * Förklara varför varje rad av utskriften ser ut som den gör, rita gärna.
Första utskriften (k) kommer att skriva ut 5. När vi skapar en ny int med namnet k och värdet 5, skapas en ny minnesplats med namnet k och med värdet 5 i sig. Den här minnesplatsen kommer ligga direkt vid k (med andra ord ingen referenspil). När vi sedan skickar in k till changeValue kommer en ny int vid namnet n skapas och kopiera k:s värde. Vid n++ kommer därav bara n förändras till 6 och inte k (eftersom int är en primitiv typ och det inte finns några referenspilar). Därav utskriften 5 för k.

Andra utskriften (a) kommer att skriva ut 1. När skapar ett nytt objekt a som är av typen CounterModel kommer en ny referenspil skapas från a som pekar på värdet 0 (startvärdet). När vi sedan skickar in a i changeValue så kommer c1 att peka på samma värde, och vid c1.increment(), kommer det värdet c1 pekar på öka med 1. Eftersom a och c1 pekar på samma minnesplats så kommer därav utskriften för a också bli 1. 

Tredje utskriften (b) kommer att skriva ut 0. Precis som ovan så skapas ett objekt b av typen CounterModel, med en referenspil som pekar på en ny minnesplats med värdet 0. Vi skickar in b i changeValue som inparametern c2, dock så skapar vi en ny CounterModel och en ny minnesplats för c2 (så nu kommer b och c2 peka på varsin minnesplats, båda värdet 0). Så när vi tar c2.increment() så ökas så det värdet på den minnesplatsen c2 pekar på (och inte b), därav får vi utskriften 0 då b förblir oförändrat. 



c) * Vad händer om man gör om instansvariabeln i CounterModel som håller reda på räknaren till "static"?
Att någonting är static innebär att det tillhör klassen, så en klassvariabel kan då se ut som 
private static int x; medan en instansvariabel bara hade sett ut som private int x; .
När vi ändrar x från att vara en instansvariabel till en klassvariabel, så innebär det att värdet på x kommer att delas av alla instanser som är skapade från klassen (alla CounterModels). Därav, om vi har
CounterInterface c1 = new CounterModel() och
CounterInterface c2 = new counterModel() och sedan kör
c1.increment();
c1.increment();
c2.increment();
int result = c1.getValue();
System.out.println(result);
, så kommer vår utskrift att bli *3* och inte *2*, för att x kommer delas med både c1 och c2, så när vi kör c2.increment() kommer x gå från 2 till 3, och resultaten för c1 blir då också 3. 
Har vi istället x som en instansvariabel kommer inte detta att ske. 


* Skall denna metod vara en klassmetod eller en instansmetod? * Kan den vara bägge? * Vilket är lämpligast?
Vi valde att ha getNbrOfCounters som en klassmetod och den nya variabeln som en klassvariabel. Vi ansåg att eftersom det här är en metod och ett värde som skall delas av alla instanser som skapas, bör den vara static. För varje gång vi skapar en ny CounterInterface c = new CounterModel() så ska det värdet gå upp med 1. Den kan vara bägge, men då måste man också skapa en ny instans i CounterModel, därav ansåg vi det lämpligast att göra den static. 


e) * Vad innebär det att två räknare är lika? 
För CounterModel: Vi anser att två räknare är lika när, t.ex, värdena är desamma eller att räknarnas modulus är samma för båda. Dock så i vårt program testar vi bara ifall värdena är samma och att de är av samma klass (alltså ej modulus). 
För FastCounter: De ska vara av samma klass, ha samma [steps] range och uppfylla kraven för ovan.



h) * Vad händer om man anropar increment på en FastCounter?
Om man använder increment på en FastCounter (och inte upMany) så kommer superklassens increment-metod att anropas och värdet på FastCounter, oavsett värde på steps, kommer öka med 1.








