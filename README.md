## Fragen zum Game Project

### 1.1 Konstruktor der Klasse Game - Suchen Sie den Konstruktor der Klasse Game und schreiben Sie hier den Code der ein Objekt der Klasse erzeugt (instanziert). Wo wird dies im Programm gemacht?


public Game() {

		parser = new Parser(System.in);

		outside = new Room("outside G block on Peninsula campus");
		lab = new Room("lab, a lecture theatre in A block");
		tavern = new Room("the Seahorse Tavern (the campus pub)");
		gblock = new Room("the G Block");
		office = new Room("the computing admin office");

		outside.setExits(null, lab, gblock, tavern);
		lab.setExits(null, null, null, outside);
		tavern.setExits(null, outside, null, null);
		gblock.setExits(outside, office, null, null);
		office.setExits(null, null, null, gblock);

		currentRoom = outside; // start game outside
	}
### 1.2 Konstruktor der Klasse Raum - Suchen Sie den Konstruktor der Klasse Raum und schreiben Sie die Signatur hier hin:
Room(String description)

### 1.3 Konstruktor der Klasse Command - Suchen Sie den Konstruktor der Klasse Command und schreiben Sie die Signatur hier hin:
- Command(String commandWord, String secondWord)
- Command(String commandWord)

### 1.4 Ausgänge eines Raumes - Suchen Sie die Stelle, wo die Objektvariable für die Ausgänge im Raum deklariert wird. Schreiben Sie den Code hier hin: Suchen Sie die Stelle, wo das entsprechende Objekt instanziert wird. Wo ist das und wie sieht der Code aus?
private HashMap<String, Room> exits;

### 1.5 Hier drin ist es aber Kalt! - Für einen bestimmten Raum soll eine Meldung „Das Fenster ist offen, brrrrrrr“ programmiert werden. Diese wird ausgegeben wenn der Raum betreten wird. Programmieren Sie diese Logik in der Klasse Game.

office = new Room("the computing admin office, the window is opened, it's cold here, brrrr");

# Dokumentation

## Das Ziel vom Spiel

Ziel des Spiels ist es, einen Schlüssel zu finden, damit die richtige Tür zu öffnen und aus der Psychiatrische Klinik zu entkommen, und das alles innerhalb eines Zeitlimits.


## Welche Klassen müssen implementiert werden?

Ein Timer, damit man zetilich limitiert ist.
Eine Klasse für verschiedene Gegenstände, die man in einem Raum finden kann.
Eine Klasse für Hunter, der den Spieler jagt, und wenn man falsche Entschiedungen trifft, kommt er immer näher 