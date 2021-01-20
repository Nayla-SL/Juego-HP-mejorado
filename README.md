HarryPotterGame
Juego de Harry Potter

Este código parte del Juego de Harry Potter, decidí cambiar y mejorar algunas partes del código, pero para no modificar el trabajo grupal con mi compañera lo armé en un código aparte.
--------------------------------------------------------------------------------------
Consignas:

Se desea realizar un juego de combate por turnos en java con la temática de Harry Potter. La dinámica del juego es que 2 personajes puedan enfrentarse en un duelo de hechizos hasta la muerte. Reglas y Características del juego:

● Los personajes a seleccionar en el juego, se dividen en 2 grupos: Magos y Elfos.

● Los hechizos a escoger para ser usados en el duelo, se dividen en 3 grupos: Ataque (vida del oponente), Defensa (nivel de vida) y Recuperación (nivel de energía mágica). Cada personaje solo puede seleccionar un máximo de 6 hechizos, sin importar su tipo.

● Solo los personajes de tipo Mago pueden usar varitas, los Elfos usan magia nativa.

● Al seleccionar un mago, el juego asigna una varita aleatoriamente de un listado disponible (la varita elige el mago).

● Durante el duelo, el personaje puede cambiar de ubicación cuando sea su turno. Hay 3 ubicaciones disponibles. Al momento de seleccionar un personaje, se solicita la ubicación inicial con la cual quiere iniciar la partida.

● Los personajes tienen las siguientes características: ○ nombre ○ ubicación ○ nivel de vida ○ energia magica ○ Lista de hechizos. ■ varita (para los personajes de tipo mago)

● En cada turno, los personajes pueden hacer una de las tres acciones disponibles: Atacar, Defenderse o Recuperarse.

● En cada turno el personaje puede o no cambiar de ubicación, después de hacer un hechizo (elección del jugador).

● Según la cantidad de hechizos elegidos, un mago puede ser oscuro o no y un elfo puede ser libre o no. Esto radica si un personaje tiene más de 3 hechizos de tipo Ataque. ● Los hechizos tiene un nivel de energía mágica requerida, esta es tomada de la energía mágica del personaje. Al momento de usar un hechizo, si el personaje no tiene el nivel de energía mágica requerido para el hechizo seleccionado, el juego debe indicar que no posee energía mágica suficiente y se incrementará 10 puntos de energía mágica al personaje y terminará el turno del jugador.

● Los Hechizos de tipo ataque, solo podrán tener un máximo de 25 puntos de daño. Los hechizos de sanación un máximo de 20 puntos de vida. Los echizos de tipo Recuperación sólo podrán tener un máximo de 15 puntos y la energía mágica requerida un máximo de 8 puntos. Solo hay estas 3 excepciones en los hechizos de ataque: ○ Avada Kedavra: 100 pts de daño y 90 pts de energía mágica requerida ○ Imperius: 90 pts de daño y 80 pts de energía mágica requerida ○ Cruciatus: 80 pts de daño y 70 pts de energía mágica requerida

● Al momento de realizar un ataque, el oponente recibe el nivel de daño de ese ataque, pero solo causará daño si la ubicación del ataque coincide con la ubicación del personaje que recibe el ataque.

● Para los magos oscuros, se incrementa 10 puntos sobre lo que aporta el hechizo de ataque, pero disminuye 10 puntos en los hechizos de defensa.

● Para los magos blancos (no oscuros), al usar un hechizo de recuperación, este incrementa 10 puntos sobre lo que aporta el hechizo, solo si su nivel de vida es menor o igual a 35 puntos.

● Para los elfos libres, al usar un hechizo de cualquier tipo, este incrementa 5 puntos sobre lo que aporta el hechizo.

● Para los elfos en cautiverio, al usar un hechizo de defensa, este incrementa 10 puntos sobre lo que aporta el hechizo.

● Las varitas agregan un máximo de 5 puntos de daño en los ataques.

● Los puntos de vida y de energía mágica de los personajes, solo pueden llegar a 100 puntos y no más que eso.

● El juego termina cuando uno de los personajes muere, es decir, sus puntos de vida es 0 o menor a cero.

Aclaraciones técnicas:

● las acciones (métodos) de los personajes son: ○ Atacar: lógica para seleccionar un hechizo para el ataque y la ubicación a donde se quiere realizar el ataque.

○ Sanación: lógica para seleccionar un hechizo para la sanación del personaje

○ Recuperación: lógica para seleccionar un hechizo para la recuperación de la energía mágica del personaje

○ Recibir ataque: lógica el nivel de daño de un hechizo y si este fue efectivo o no.

○ Está vivo: lógica que indica si el personaje aún sigue vivo.

○ Agregar hechizo: lógica agregar al listado de hechizos del personaje un hechizo seleccionado.

○ Estatus del personaje: lógica que muestra por pantalla el estatus del personaje: nivel de vida, ubicación, energía mágica, etc.

■ Es oscuro o libre: indica si el (mago es oscuro o no/ elfo el libre o no)

Dinámica del Juego: Al inciar el juego, debe tener este flujo:

● Selección de los Personajes: este proceso se hará por turnos, en los cuales, el juego debe mostrar los personajes disponibles para la elección y solicitar al usuario que seleccione uno de ellos. En caso que se haya elegido un mago, se debe mostrar el listado de varitas disponibles en el juego y luego qué varita lo eligió para el combate

● Selección de los Hechizos: este proceso se hará por turnos, en los cuales, el juego debe mostrar los hechizos disponibles para la elección y solicitar al usuario que seleccione los que desea usar para el duelo.

● Inicio del juego: Es un ciclo que durará hasta que uno de los jugadores muera. y se realizará por turnos. En cada turno, el jugador debe ver el estado de su personaje y hacer la elección del hechizo que desea realizar y todo lo que conlleva este hechizo. Luego de cada turno, se debe validar si el oponente ya está muerto, en caso afirmativo, se debe terminar el ciclo y por ende el proceso

● Mostrar ganador: Muestra por pantalla el nombre del jugador que ganó y el estado de los personajes de la partida (ambos personajes).
