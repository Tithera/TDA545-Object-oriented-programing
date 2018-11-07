Laboration 3 del 2
Grupp 20
Josefin Ulfenborg
Therese Sturesson
Editor: Smultron

Till att börja med konstaterade vi att vi skulle använda canMove, setMark och getMark. canMove använda vi för att kolla ifall varje riktning är möjlig, därav fann vi det lättare att skapa fyra stycken booleans och spara metodanropet där i med respektive riktning. 
setMark använde vi för att markera/spara där vi har varit, och till en början fick vi en utskrift där varje plats fick en markering (med andra ord, innan vi kastade bort de felaktiga vägarna). 
getMark använde vi för att kolla ifall vi redan hade varit på en viss plats. 

Koordinaterna vi utgick ifrån var (x0, y0) (därför satte vi direkt setMark med x0 och y0, och detta kom sedan att bli varje utskrift i labyrinten), för att sedan ta oss till slutpunkten (x1, y1), där width = 20 och height = 10. Vi försökte jämföra labyrinten med en graf, och konstaterade att vi skulle behöva ta y0-1 för att gå upp ett steg (och y0+1 för att gå ner), eftersom labyrintens y-värden var “tvärtom” gentemot en graf. 

Så till en början ville vi få med att man kollade ifall man kunde gå i varje riktning, därför satte vi fyra stycken if-satser och inte t.ex else if, för att den ska alltid kolla alla fyra varje gång, eftersom det kan finnas mer än en väg att gå.

Tillsammans med att kolla ifall varje riktning var möjlig, ville vi också kolla så vi inte redan varit på nästa plats (därför skiljer sig varje getMark åt)

Vi pausade (fastnade..) här och hoppade vidare ut ur den stora else-satsen, och visste då att om vi varken kunde gå åt höger, vänster, upp eller ner, så skulle vi ta bort den markeringen vi stod på (genom setMark(x0,y0,false), och sedan returnera false då den vägen uppenbarligen var felaktig. 

Vi insåg inte riktigt hur rekursionen fungerade, för vi trodde att om man anropade findPath inuti findPath, så skulle metoden “sluta köra”, hoppa ut och börja om från början med nya värden. När vi insåg att detta inte var fallet, så förstod vi att vi var tvungna att ha ett findPath-anrop efter varje if(right/left..)-sats. 

Vår utskrift blev då att vi kunde se lösningen, men programmet sa fortfarande “Failed to find a solution”. Det vi inte insåg var att vi inte sparade det booleska värdet vi fick tillbaka av findPath. Det enda vi gjorde var att returnera falskt om vägen inte var rätt, samt att returnera true ifall startvärdena var desamma som slutvärdena. Därför lade vi till en till if-sats och stoppade fP-anropet där i, och om den då returnerade sant i slutändan, ville vi ju returnera true för att visa att det var på vägen till x1, y1. Vi valde att ha två separata if-satser för vi ansåg att det var lättare att läsa, men vi är medvetna om att man hade kunnat skriva allt på samma rad. 