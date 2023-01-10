# TODO
1. Command Pattern einbauen
   1. Inputs gegen KeyMap Datei/Konfiguration abgleichen -> mit Commands verbinden
   2. Commands an Channel hängen
   3. Der Channel ist ein Subject, daran können sich beliebig viele Observer hängen hängen (Observer Pattern)
   4. Das wäre dann also jeweils der Key und Maus-Input-Channel/Subject.
   5. Die Kamera ist dann ein Listener des Mais-Input-Channels/Subjects.
   6. Oberser Abstract implementiert Logik, sodass er sich von seinen Subjekten abmeldet wenn er destroyed wird!
   7. In die abstrakten Listener und Observer muss gutes Fehlerlogging eingebaut werden! Das Command sollte serialisiert ausgegeben werden, sowie der State sollte irgendwie nachvollziebar sein.  
2. Render Tile (Map)
   1. Map -> Flyweight iteriert über "Tile-Daten" und gibt über die Flyweight-Factory, das Tile zurück und gibt es an den Renderer!

# Backlog
1. Object Pooling für PixelDimension?
   1. Warum? Constructor Zeit-Komplex
   2. Object-Pool in PixelDimension Builder einbauen?
2. Layer/Mergable parallelisieren / Random parallelisieren - pool
3. Change 2d Software Renderer -> lwjgl OpenGl Renderer







Engine:
GameInputs -> Command-Pattern
Configurable Key/Mouse Mapping

abstract Command
NullCommand
... concrete Commands ...

AI Engine only emits Commands on AI driven ACTORS.





Konzept eines Levels. Größe Variabel. 
Screen rendert einen Teil eines Levels
Screen lässt sich verschieben.

Entitys, mit einer Position im Level, werden dargestellt oder nicht.
