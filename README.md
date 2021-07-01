# OMD-XL-grupp41

**Användarfall**\l

•	Användaren markerar en ny ruta, då flyttar den gula markör till den nya rutan, som blir den currentSlot då. Och innehållet av den nya markerade ruta ska tas upp.

•	Användare fyller i en ruta med en aritmetiskt funktion, inleds med =, då skapas en ny ExpressionSlot i hash mappen som har samma address som rutan.\
•	Användare fyller i en ruta med ett realt tal, då skapas en ny ExpressionSlot i hash mappen som har samma address som rutan.\
•	Användare fyller i en ruta med en kommentar, inleds med #, då skapas en ny CommentSlot i hash mappen som har samma address som rutan.\
•	Användare fyller i en ruta med en kommentar som inte inled med #, då skapas en ny ErrorSlot som visar meddelande ”invalid input” i text fielden.
	
•	Användaren klickar på Clear, då rensas den markerade rutan, och innehållet i den current slot rensas, samtidigt skapas en EmptySlot i hash mappen på samma addressen som rutan.\
•	Användaren klickar på Clear All, då rensar användaren alla information i alla rutor, och hash mappen clearas! \
•	Anavändare försöker att addera A1 med A2 med A3, där A1 definierade som A2 och A2 definierade som A3 och A3 definerade som A1, då kommer det att visas ett fel meddelande som säger ”undefiend variabls, ogiltig addition”. (vems sak ta hand om det)

•	Användare försöker att dividera med 0, då kommer div klassen i Exp att skicka ett fell som kommer att fångas av (******), sedan kommer ett meddelande som säger ”divid by Zero”.


* Print, Skriver ut den aktuella filen.
* Save, Sparar den aktuella filen.
* Load, Öppnar en redan existerande fil.
* New, Skapar ett nytt gui med en ny fil.
* Close, stänger det aktuella fönstret.

Användaren använder Window menyn\
    Användaren flyttas från aktuellt fönster till det markerade.\
\
Vilka klasser bör finnas för att representera ett kalkylark?\
**Project - Model**\
    Expr\
    Variable\
BinaryExpr\
    Div\
    Mul\
    Add\
    Sub\
Num, number\
    \
**Project - View**\
    gui\
\
**Project - Controller**\
    Spreadsheet

En ruta i kalkylarket skall kunna innehålla en text eller ett uttryck. Hur modellerar man detta?\
Vi använder template method, Expr som abstract class. Variable, Binary och Comment extendar sedan Slot. 

Hur skall man hantera uppdragsgivarens krav på minnesresurser?\
    Matrisen har en satt storlek med Key(s) lagrade, matrisen konstrueras på nytt varje gången programmet öppnar. Key används sedan för att hämta värdena som finns lagrade genom att använda en Map. Map allokerar minne dynamiskt.
    Map ska ev. finns med i Controller.

Vilka klasser skall vara observatörer och vilka skall observeras?\
**Observer**\
    Gui\
**Observable**\
    XLList\
    spreadsheet\
    Meny
    
Vilket paket och vilken klass skall hålla reda på vad som är “Current slot”?\
Spreadsheet

Vilken funktionalitet är redan färdig och hur fungerar den? Titta på klasserna i view-paketet och testkör.\
Vi kan öppna menyerna, vi kan få upp dialogfönster för att använda funktionaliteterna print, open, save, load, new, och close. 
Vi kan lägga till text i input raden.
Vi kan skifta mellan fönster.

Det kan inträffa ett antal olika fel när man försöker ändra innehållet i ett kalkylark. Då skall undantag kastas. Var skall dessa undantag fångas och hanteras?\
Hanterar felen gör spreadsheet\
Kastar felen gör Expression, Comment, Blank

Vilken klass används för att representera en adress i ett uttryck?\
Adress, som implementerar interfacet Expression.

När ett uttryck som består av en adress skall beräknas används gränssnittet Environment. Vilken klass skall implementera gränssnittet? Varför använder man inte klassnamnet i stället för gränssnittet?\
Expression ska implementera gränssnittet.
Vi behöver ett interface som kan hantera alla typer av uttryck, dessa uttryck hanteras sedan i subklasser till Expression. 

Om ett uttryck i kalkylarket refererar till sig själv, direkt eller indirekt, så kommer det att bli bekymmer vid beräkningen av uttryckets värde. Föreslå något sätt att upptäcka sådana cirkulära beroenden! Det finns en elegant lösning med hjälp av strategimönstret som du får chansen att upptäcka. Om du inte hittar den så kommer handledaren att avslöja den.\
Expr ska implementera ett interface som delegerar ansvaret till Num, binaryExpr & Variable att göra en jämförelse. 

 

