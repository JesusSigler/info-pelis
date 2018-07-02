-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: peliculas
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Peliculas`
--

DROP TABLE IF EXISTS `Peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Peliculas` (
  `idPelicula` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `psinosis` longtext,
  `imagen` varchar(200) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `trailer` varchar(200) DEFAULT NULL,
  `año` int(4) DEFAULT NULL,
  PRIMARY KEY (`idPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Peliculas`
--

LOCK TABLES `Peliculas` WRITE;
/*!40000 ALTER TABLE `Peliculas` DISABLE KEYS */;
INSERT INTO `Peliculas` VALUES (1,'Wonder Woman','Antes de ser Wonder Woman (Gal Gadot) era Diana, princesa de las Amazonas, entrenada para ser una guerrera invencible. Diana fue criada en una isla paradisíaca protegida. Hasta que un día un piloto norteamericano (Chris Pine), que tiene un accidente y acaba en sus costas, le habla de un gran conflicto existente en el mundo [Primera Guerra Mundial]. Diana decide salir de la isla convencida de que puede detener la terrible amenaza. Mientras lucha junto a los hombres en la guerra que acabará con todas las guerras, Diana descubre todos sus poderes y su verdadero destino.','pwonder-woman','Ciencia ficcion','https://www.youtube.com/v/gOfmwQijKFg',2017),(2,'Capitan America: Civil War','Después de que otro incidente internacional involucre a Los Vengadores, causando varios daños colaterales, aumentan las presiones políticas para instaurar un sistema que exija más responsabilidades y que determine cuándo deben contratar los servicios del grupo de superhéroes. Esta nueva situación dividirá a Los Vengadores, mientras intentan proteger al mundo de un nuevo y terrible villano. Tercera entrega de la saga Capitán América.','pcivil-war','Ciencia ficcion','https://www.youtube.com/v/LuOLcuKVFwY',2016),(3,'Piratas del Caribe: La venganza de Salazar','Empujado hacia una nueva aventura, un sumamente desafortunado Jack Sparrow descubre que los vientos de los malos augurios soplan incluso más fuerte cuando los mortales piratas fantasma liderados por su viejo enemigo, el capitán Salazar, escapan del Triángulo del Diablo. Decididos a matar a todo pirata que encuentren en el mar, incluso al propio Sparrow. La única esperanza de supervivencia del Capitán Jack Sparrow se encuentra en la búsqueda del legendario tridente de Poseidón, un poderoso artefacto que otorga a su poseedor el control total sobre los mares.','ppiratas-caribe-venganza-zalazar','Aventura','https://www.youtube.com/v/azjsS0wxTA8',2017),(4,'Tomb Raider','Lara Croft (Alicia Vikander) es una joven e inexperta arqueóloga que se embarcará en su primera aventura para terminar la investigación arqueológica iniciada por su padre, y descubrir así antiguos secretos con el fin de limpiar el deshonrado nombre de su progenitor. Esta expedición llena de peligros será una lucha por la supervivencia, con nuevas pruebas y nuevos enemigos, en la que Croft, poco a poco, se irá convirtiendo en la heroína que todos conocemos. La historia de una mujer corriente que descubre su carácter de luchadora al verse obligada a poner a prueba sus habilidades de lucha con el único propósito de salir con vida.','ptombRaider','Aventura','https://www.youtube.com/v/phsWSladwOI',2018),(5,'Cincuenta Sombras Liberadas','La apasionante historia de Anastasia Steele y Christian Grey continúa en Cincuenta sombras liberadas. Anna y Christian por fin se han casado y ambos se disponen a vivir una apacible y romántica luna de miel en Europa. Pero no todo será tan idílico como ambos tenían planeado. Mientras se encuentran en Europa, les empiezan a llegar noticias de extraños incidentes ocurridos en las propiedades de Grey, ante lo que Christian comenzará a temer por la seguridad de su familia. Además, Christian se sentirá enojado por ciertos comportamientos de Ana durante su viaje, castigándola y dejándola varias marcas en su cuerpo que le harán revolverse la conciencia. Por su parte, Ana se reserva un gran secreto que no será de ningún agrado para Grey. Tercera y última entrega de la saga Cincuenta sombras, nuevamente protagonizada por Dakota Johnson y Jamie Dornan y dirigida por James Foley bajo la producción de Universal Pictures y de la propia escritora de las novelas, E.L. James.','psombrasLiberadas','Romance','https://www.youtube.com/v/68nrtEKqMb8',2018),(6,'Pacific Rim 2: Insurrección','Un futuro cercano. Después de la primera invasión que sufrió la humanidad, la lucha aun no ha terminado. El planeta vuelve a ser asediado por los Kaiju, una raza de alienígenas colosales que emergen desde un portal interdimensional, con el objetivo de destruir a la raza humana. Ante esta nueva amenaza para la cual los humanos no están preparados, los Jaegers, robots gigantes de guerra pilotados por dos personas para sobrellevar la inmensa carga neural que conlleva manipularlos, ya no están a la altura de lo que se les viene encima. Será entonces cuando los supervivientes de la primera invasión, además de nuevos personajes como el hijo de Pentecost (John Boyega), tendrán que idear la manera de sorprender al enorme enemigo, apostando por nuevas estrategias defensivas y de ataque. Con la Tierra en ruinas e intentando reconstruirse, esta nueva batalla puede ser decisiva para el futuro.','ppacificRim','Ciencia ficcion','https://www.youtube.com/v/-FZEgD3-tEo',2018),(7,'Jumanji: Bienvenidos a la jungla','El misterioso y letal juego Jumanji reaparece más de veinte años después. Es la época actual, y cuatro adolescentes se introducen en esta nueva aventura, ahora a partir de un videojuego que sirve como un portal a través del espacio-tiempo. Absorbidos por el mundo de Jumanji, un juego que no se puede abandonar hasta que acaba la partida, los jóvenes se enfrentarán a rinocerontes, mambas negras y una infinita variedad de trampas de la selva. En este juego, el tímido Spencer será un conquistador musculoso, el deportista Fridge será un diminuto Einstein, la chica de moda Bethany será un profesor sabelotodo, y la torpe Martha, una guerrera amazona. Juntos tendrán que jugar para volver al planeta Tierra y seguir con sus vidas. ¿Cómo? Pensando distinto.','pjumanji2','Aventura','https://www.youtube.com/v/s-FH0WRLiwE',2017),(8,'Coco','¿Qué pasaría si pudiéramos reencontrarnos con nuestros familiares fallecidos hace tiempo? A partir de la colorida celebración mexicana del Día de los Muertos, Coco nos descubre el misterio de compartir la reunión familiar más extraordinaria y sorprendente, incluso con aquellos antepasados que murieron muchos años atrás. La historia sigue a un niño de doce años de edad llamado Miguel, que vive con su familia en una zona rural de México, y cuyo sueño es la música y tocar la guitarra. Miguel desencadenará una serie de acontecimientos extraordinarios relacionados con un misterio centenario. La festividad del Día de los Muertos servirá como telón de fondo para que nuestro protagonista se pregunte de dónde viene, cuál es su lugar dentro de su familia, y cómo se han entretejido las relaciones familiares a través del tiempo. Una celebración de la vida, de la familia, los recuerdos y la conexión a través de diversas generaciones.','pcoco','Animacion','https://www.youtube.com/v/htwlR51npL4',2017),(9,'The Fast And Furious 8','Toretto ya destruyó la mafia que tanto daño hizo a sus seres cercanos e incluso, enemigos que no tuvieron más opción que aliarse en algún momento, como el propio FBI y demás cuerpos policiales. Sin O´Conner en el equipo al igual que su hermana Mia, Toretto se planta a luchar del lado de la justicia 3n Rápidos y Furiosos 8 pero de pronto las cosas cambian y la familia ya no es lo más importante, al punto en el que Toretto se enfrentará a todos al mismo tiempo dejando en evidencia por qué es el líder y uno de los criminales más buscados del mundo ¿Se habrá acabado esta espectacular historia de héroes?','pfast-to-furious','Accion','https://www.youtube.com/v/BdB9DvyxNh0',2017),(10,'Black Panther','Black Panther cuenta la historia de T Challa quien, después de los acontecimientos de \"Capitán América: Civil War\", vuelve a casa, a la nación de Wakanda, aislada y muy avanzada tecnológicamente, para ser proclamado Rey. Pero la reaparición de un viejo enemigo pone a prueba el temple de T Challa como Rey y Black Panther ya que se ve arrastrado a un conflicto que pone en peligro todo el destino de Wakanda y del mundo.','pblack-panther','Ciencia ficcion','https://www.youtube.com/v/JK-wAfAvJ0g',2018),(11,'Deep Blue Sea 2 ','La Doctora Misty Calhoun, conservacionista de tiburones, es invitada para asesorar un proyecto secreto organizado por el farmacéutico millonario Carl Durant. Calhoun se sorprende al descubrir que la compañía utiliza a los agresivos e impredecibles tiburones toro para los tests.','pdeepbluesea2','Terror','https://www.youtube.com/v/GywlaRzuvHw',2018),(12,'Deep Blue Sea','Utilizando tiburones Mako, una de las máquinas de matar más rápidas y perfectas de la naturaleza, la doctora McAlester (Saffron Burrows) espera encontrar la clave de la regeneración de los tejidos del cerebro humano. Pero para alcanzar su meta ha violado los códigos éticos, modificando el ADN de los tiburones, haciendo que sean más inteligentes y más rápidos, convirtiéndolos de depredadores peligrosos en monstruos depredadores que pondrán en peligro a todo el equipo de trabajo...','pdeepbluesea','Terror','https://www.youtube.com/v/oSz9MDN-iac',1999),(13,'Deep','Los protagonistas de la película son un curioso y excéntrico grupo de criaturas abisales a los que no le queda otro remedio que abandonar su hogar, situado en la grieta más profunda del océano. Al verse sin sitio donde vivir, los animales se deciden a encontrar un nuevo hogar, y en su búsqueda de una nueva casa les ocurrirán disparatadas y extraordinarias aventuras.','pdeep','Animacion','https://www.youtube.com/v/03FXd_EMGzM',2017),(14,'Cenicienta(2015)','Cuenta las andanzas de la joven Ella (Lily James) cuyo padre, un comerciante, vuelve a casarse tras la muerte de su madre. Ella quiere dar gusto a su padre y acoge con cariño a su nueva madrastra (Cate Blanchett) y a sus hijas Anastasia (Holliday Grainger) y Drisella (Sophie McShera) en la casa familiar. Pero, cuando el padre de Ella muere inesperadamente, la joven se encuentra a merced de una nueva familia celosa y cruel. Al final, Ella queda relegada a ser una sirvienta cubierta de ceniza por lo que le ponen el triste nombre de Cenicienta.','pcenicienta(2015)','Fantasia','https://www.youtube.com/v/JRonMb_Bjj0',2015),(15,'Vengadores: La Guerra del Infinito','Vengadores: Infinity War seguirá la lucha de los superhéroes de Marvel contra el mayor villano al que se han enfrentado nunca: Thanos. Su único objetivo será detener a este poderoso antagonista e impedir que se haga con el control de la galaxia. De nuevo veremos al grupo formado por Iron Man, Capitán América, Viuda negra, Ant-Man, Ojo de Halcón, Thor y Hulk, entre otros. En su nueva e impactante aventura, las Gemas del Infinito estarán en juego, unos querrán protegerlas y otros controlarlas, ¿quién ganará?','pvengadores-guerra-del-infinito','Ciencia ficcion','https://www.youtube.com/v/-f5PwE_Q8Fs',2018),(16,'Dos Policías Rebeldes 3','Continuación de las aventuras de los detectives Mike Lowrey y Marcus Burnett de Miami, atrapados entre persecuciones de coches y explosiones.','pdos-policias-rebeldes3','Accion','https://www.youtube.com/v/GDdUu5amsy0',2018),(17,'Grupo 7','Grupo 7 es una película policiaca de acción e intrigas criminales, de persecuciones y arrestos, pero también un drama de lealtades y mentiras de un grupo de hombres arrogantes y desvalidos, vulnerables y violentos. El grupo lo componen: Ángel, un joven aspirante a inspector, inteligente y compasivo; Rafael, un policía expeditivo, contundente y arrogante; Miguel y Mateo, los socarrones del grupo, capazces de las mayores brutalidades, pero también de inesperadas muestras de ternura. Para el Grupo 7 no existe la delgada línea que separa los recursos poco éticos de los abiertamente ilegales. Su modus operandi: violencia, coacciones, mentiras y medias verdades… todo vale.','pgrupo7','Accion','https://www.youtube.com/v/lxvr5U5bO1k',2012),(18,'Titanic','Durante las labores de recuperación de los restos del famoso trasatlántico Titanic, una anciana norteamericana se pone en contacto con la expedición para acudir a una plataforma flotante instalada en el Mar del Norte y asistir in situ a la recuperación de sus recuerdos. A través de su memoria reviviremos los acontecimientos que marcaron el siniestro más famoso del siglo XX: el hundimiento del trasatlántico más lujoso del mundo, la máquina más sofisticada de su tiempo, considerada «insumergible», que sucumbió a las heladas aguas del Atlántico en abril de 1912, llevándose consigo la vida de 1.500 personas, más de la mitad del pasaje. En los recueros de la anciana hay cabida para algo más que la tragedia, la historia de amor que vivió con un joven pasajero de tercera clase, un pintor aficionado que había ganado su pasaje al ganar a las cartas en una taberna de Southampton. ','ptitanic','Romance','https://www.youtube.com/v/xdIY4OjPas0',1997),(19,'Posdata: Te quiero','Holly Kennedy es una joven viuda que trata de encauzar nuevamente su vida tras la muerte de su amado marido Gerry, fallecido de una enfermedad. Entonces descubre que éste le ha dejado escritas varias cartas...','pPostDataTeQuiero','Romance','https://www.youtube.com/v/Ilg5hNUzZCs',2007),(20,'Pretty Woman','Un acaudalado y frío hombre de negocios conoce en Hollywood Boulevard a una joven y atractiva prostituta a la que alquila durante una semana para que sea su acompañante en sus cenas con los clientes. Para ello la chica se verá sometida a todo un cambio de look tras el que nadie podrá ver, a simple vista, que es una chica de la calle.','pPettyWoman','Romance','https://www.youtube.com/v/Wzii8IuL8lk',1990),(21,'Los Pitufos: La aldea escondida','A Pitufina le parece que todos los demás habitantes de la aldea tienen un propósito: Papá Pitufo, Pitufo Panadero (preparar pan y pasteles), incluso Pitufo Gruñón; salvo ella. Así que, ¿qué puede hacer la única chica de la aldea? ¡Pues partir en busca del suyo, naturalmente! Cuando se cruza por casualidad con una misteriosa criatura que huye hacia el Bosque Encantado, la sigue y se interna por territorio inexplorado y totalmente prohibido. A ella se le unen sus hermanos Filósofo, Valiente y Torpe y con el malvado mago Gargamel siguiéndolos de cerca. El equipo pitufo emprenderá así un alocado viaje lleno de acción, peligro y descubrimientos, que los conducirá al mayor misterio de la historia Pitufa. Dirigida por Kelly Asbury, con la producción ejecutiva de Raja Gosnell y Ben Waisbren. La película, completamente animada, supone un regreso al tono y el estilo de las queridas creaciones del cómic de Peyo.','pPitufosLaAldeaEscondida','Animacion','https://www.youtube.com/v/jlkeR7ocvNw',2017),(22,'Cars 3','Rayo McQueen sigue siendo el mejor coche de carreras del mundo, pero ahora que es uno de los más veteranos del circuito, debe demostrar a todo el mundo que aún puede ganar una gran carrera y que no necesita jubilarse. En esta ocasión, el famoso bólido de carreras tendrá que enfrentarse a una nueva generación de corredores más jóvenes, potentes y veloces, que amenaza con cambiar el deporte de su vida. Entre ellos está el competitivo y revolucionario Jackson Storm, que no se lo pondrá nada fácil.','pCars3','Animacion','https://www.youtube.com/v/09LzPuNMqdY',2017),(23,'La Bella y la Bestia (2017)','La tradicional y conocida historia de Disney toma forma ahora con seres humanos, en los que Emma Watson parte como personaje principal de la trama al interpretar a Bella, una chica humilde y además, hermosa, que debe salir de su humilde hogar para salvar la vida de un príncipe cautivo en una maldición antigua. Lo que sin duda representa la historia de amor más esperada de este año, tendrá en Disney un gran suceso al mostrar en La Bella y La Bestia personajes reales una de las películas más aclamadas del cine de caricaturas, sin contar que las canciones tendrán las voces de Ariana Grande y Celine Dion.','pLaBellaYLaBestia(2017)','Fantasia','https://www.youtube.com/v/Kv2yOI6nVng',2017),(24,'Mara y el señor del fuego','Mara Lorbeer es una joven de quince años que descubre que tiene poderes sobrenaturales y puede viajar en el tiempo, pero necesita buscar respuestas. ¿Por qué tiene esas extrañas habilidades? Un conocido profesor intenta ayudar a Mara y se sorprenden al descubrir que deben salvar el mundo antes de que el malvado dios nórdico Loki se libere de sus cadenas.','pMaraYelSeniorDelFuego','Fantasia','https://www.youtube.com/v/pvQYyND_OXs',2015),(25,'Animales fantasticos y donde encontrarlos','Adaptación del libro \'Animales fantásticos y donde encontrarlos de J.K Rowling\', ambientado en el mundo del famoso aprendiz de mago Harry Potter. La historia la protagonizará Newt Scamander, autor ficticio de la novela y se remontará 70 años antes de \'Harry Potter y la piedra filosofal\'. Se trata del libro que los alumnos aprendices de mago de Hogwarts de tercer año utilizan para la asignatura de \'Cuidado de criaturas mágicas\' impartida por Rubeus Hagrid. Un extenso manual en el que están clasificados las diferentes bestias y criaturas mágicas que habitan en el mundo mágico. En él, quedan por tanto registradas y descritas 75 especies mágicas encontradas alrededor del mundo, una información que Scamander recogió a lo largo de muchos años durante sus viajes por los 5 continentes. Una película que no predecerá ni continuará la historia de Harry Potter, pero que sí se ambientará en su mundo para contar esta vez, las aventuras de Newt Scamander.','pAnimalesFantasticos','Fantasia','https://www.youtube.com/v/6Mlq9GwL6Uo',2016),(35,'Life (Vida)','Seis miembros de la tripulación de la Estación Espacial Internacional que están a punto de lograr uno de los descubrimientos más importantes en la historia humana: la primera evidencia de vida extraterrestre en Marte. A medida que el equipo comienza a investigar y sus métodos tienen consecuencias inesperadas, la forma viviente demostrará ser más inteligente de lo que cualquiera esperaba. ','pLife','Terror','https://www.youtube.com/v/3KaAaXZ-66k',2017),(36,'Kong: La isla Calavera','Ahora, es el hijo de Denham el que se convierte en protagonista de la historia, al hacer un nuevo e importante descubrimiento que le lleva al lugar donde su padre comenzó su gran aventura: Skull Island. Allí, el investigador lucha por encontrar las respuestas que aclararían el gran misterio del siglo e, incluso, del milagro más increíble de la historia de la humanidad. Aún se desconocen muchos datos acerca de este proyecto, como, por ejemplo, quién será el director del filme, qué actores integrarán el reparto y cuando será el estreno de esta película.','pKong','Aventura','https://www.youtube.com/v/8wP_3OO3Res',2017),(37,'Zona hostil','A un convoy americano escoltado por la Legión española le estalla una mina al Norte de Afganistán y el inexperto Teniente Conte queda al mando de una dotación para proteger a los heridos hasta que los evacuen. La Capitán médico Varela acude al rescate en un helicóptero medicalizado del Ejército Español, pero el terreno cede durante el aterrizaje y el helicóptero vuelca, dejando a los rescatadores atrapados junto a los legionarios en medio de la nada. El impulsivo Comandante Ledesma propone un arriesgado plan para rescatarlos a todos y, además, llevarse el aparato siniestrado. Pero con la noche llega el enemigo y el plan sólo será posible si el Teniente y la Capitán logran sobrevivir hasta el amanecer.','pZonaHostil','Accion','https://www.youtube.com/v/HIaVe_j84Hs',2017),(38,'Still/Born','Mary está embarazada de gemelos, pero, en el parto, uno de los bebés muere. Diagnosticada con depresión postparto, la mujer entra en una espiral de neurosis, sobre todo cuando descubre las historias sobre un ente demoníaco que se alimenta de las madres y los recién nacidos. ¿Será eso lo que la atormenta por las noches, o se trata de sus terrores íntimos?','pSillBorn','Terror','https://www.youtube.com/v/dnpyoljUzfM',2017),(44,'Beyond The Sky','Un documentalista viaja a una convención de OVNIS en Nuevo México, donde conoce a un artista local con un oscuro secreto. A medida que siguen un rastro de pistas, descubren avistamientos perturbadores y cuestionan todo lo que creen cuando se sumergen en la cultura enigmática de los pueblos indios.','pbeyonSky','Ciencia ficcion','https://www.youtube.com/v/b7ydkn7PTmU',2018),(45,'La abeja Maya: Los juegos de la miel ','Esta nueva aventura de nuestra traviesa amiga Maya, es sin duda la más espectacular realizada hasta el momento. ¡Maya vuelve zumbando! En su nueva aventura. \r\nCuando la muy entusiasta abeja Maya mete la pata con la Emperadora de Buzztropolis, ella debe unirse a un equipo de rebeldes insectos y competir en los Juegos de la\r\n Miel para salvar a las abejas de su panel. Continuación del éxito de taquilla La Abeja Maya con más emoción que nunca!','pabejamaya','Animacion','https://www.youtube.com/v/9wahl_mpRRk',2018);
/*!40000 ALTER TABLE `Peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Peliculas_has_Usuario`
--

DROP TABLE IF EXISTS `Peliculas_has_Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Peliculas_has_Usuario` (
  `Peliculas_idPelicula` int(11) NOT NULL,
  `Usuario_nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`Peliculas_idPelicula`,`Usuario_nombre`),
  KEY `fk_Peliculas_has_Usuario_Usuario1_idx` (`Usuario_nombre`),
  KEY `fk_Peliculas_has_Usuario_Peliculas_idx` (`Peliculas_idPelicula`),
  CONSTRAINT `fk_Peliculas_has_Usuario_Peliculas` FOREIGN KEY (`Peliculas_idPelicula`) REFERENCES `Peliculas` (`idPelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peliculas_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_nombre`) REFERENCES `Usuario` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Peliculas_has_Usuario`
--

LOCK TABLES `Peliculas_has_Usuario` WRITE;
/*!40000 ALTER TABLE `Peliculas_has_Usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Peliculas_has_Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `rol` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('admin','1234','jesussiglermartinez@gmail.com','admin'),('Alicia12','1234','aliciaorellana@gmail.com','noadmin'),('Alucar','1234','alucar@gmail.com','noadmin'),('Analcazan','123','analacazan@gmail.com','noadmin'),('Jesús','1234','jesustrianero25@gmail.com','noadmin'),('Lucia','1234','lucia@gmail.com','noadmin'),('Manuel','1234','manuel@gmail.com','noadmin'),('Marco','1234','marco@gmail.com','noadmin'),('Mordor','1234','mordor@gmail.com','noadmin'),('Pumunki','1234','pumunki@gmail.com','noadmin');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-02 10:27:54
