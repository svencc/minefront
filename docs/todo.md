# TODO
1. Render Tile (Map)
1.1 Map -> Flyweight iteriert über "Tile-Daten" und gibt über die Flyweight-Factory, das Tile zurück und gibt es an den Renderer!

# Backlog
1. Object Pooling für PixelDimension?
   1. Warum? Constructor Zeit-Komplex
   2. Object-Pool in PixelDimension Builder einbauen?
2. Renderer parallelisieren!
3. Change 2d Software Renderer -> lwjgl OpenGl Renderer
4. Provider instance creation threadsafe machen?







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
