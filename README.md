# ♟ chess

> A shell embeded PvP chess game written in Java from scratch

![](images/ajedrez.PNG)

---

## :wrench: BASIC INSTRUCTIONS

Download the source code, compile it and run it. In order for it to work you must have previously installed JDK:
``` bash
javac *.java #compile the program
java Main    #run the program
``` 
If you are working in Windows you have to define the enviroment variables to map the java.exe and javac.exe directory.

---

## 🎨 OPTIONS

The chess board is displayed like follows:

- From top to bottom from 1 to 8
- From left to right from 'a' to 'b'

Each move has to have the following format:

```bash
#Example:
a4c7
```
The game will tell you if your move was valid based on the piece you want to move, the square you are in and your position in relation to to your oponent.

There is two ways to end a game:

- Checkemate
- Each chess piece have a certain amount of points assigned. You have the option of ending the game after each turn. The color with higher amount of points wins.



Enjoy!
