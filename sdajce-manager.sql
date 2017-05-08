-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 08 Mai 2017 à 16:27
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sdajce-manager`
--

-- --------------------------------------------------------

--
-- Structure de la table `cartes`
--

CREATE TABLE `cartes` (
  `id_carte` int(10) NOT NULL,
  `nom_carte` varchar(45) DEFAULT NULL,
  `type_carte` varchar(45) DEFAULT NULL,
  `sphere_carte` varchar(45) DEFAULT NULL,
  `nombre_carte` varchar(45) DEFAULT NULL,
  `id_conteneur_carte` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cartes`
--

INSERT INTO `cartes` (`id_carte`, `nom_carte`, `type_carte`, `sphere_carte`, `nombre_carte`, `id_conteneur_carte`) VALUES
(1, 'Aragorn', 'Héros', 'Commandement', '1', 1),
(2, 'Théodred', 'Héros', 'Commandement', '1', 1),
(3, 'Glóin', 'Héros', 'Commandement', '1', 1),
(4, 'Gimli', 'Héros', 'Tactique', '1', 1),
(5, 'Legolas', 'Héros', 'Tactique', '1', 1),
(6, 'Thalin', 'Héros', 'Tactique', '1', 1),
(7, 'Éowyn', 'Héros', 'Energie', '1', 1),
(8, 'Eleanor', 'Héros', 'Energie', '1', 1),
(9, 'Dúnhere', 'Héros', 'Energie', '1', 1),
(10, 'Denethor', 'Héros', 'Connaissance', '1', 1),
(11, 'Glorfindel', 'Héros', 'Connaissance', '1', 1),
(12, 'Beravor', 'Héros', 'Connaissance', '1', 1),
(13, 'Garde de la Citadelle', 'Allié', 'Commandement', '3', 1),
(14, 'Faramir', 'Allié', 'Commandement', '2', 1),
(15, 'Fils de l’Arnor', 'Allié', 'Commandement', '2', 1),
(16, 'Éclaireur du Snowbourn', 'Allié', 'Commandement', '3', 1),
(17, 'Archer du Cours d’Argent', 'Allié', 'Commandement', '2', 1),
(18, 'Tueur d’Orques Longue-Barbe', 'Allié', 'Commandement', '2', 1),
(19, 'Brok Poing-de-Fer', 'Allié', 'Commandement', '1', 1),
(20, 'Toujours Vigilant', 'Evénement', 'Commandement', '2', 1),
(21, 'Cause Commune', 'Evénement', 'Commandement', '2', 1),
(22, 'Pour le Gondor !', 'Evénement', 'Commandement', '2', 1),
(23, 'Attaque Furtive', 'Evénement', 'Commandement', '2', 1),
(24, 'Sacrifice Héroïque', 'Evénement', 'Commandement', '2', 1),
(25, 'Détermination Acharnée', 'Evénement', 'Commandement', '1', 1),
(26, 'Intendant du Gondor', 'Attachement', 'Commandement', '2', 1),
(27, 'Pierre de Celebrían', 'Attachement', 'Commandement', '1', 1),
(28, 'Vétéran à la Hache', 'Allié', 'Tactique', '3', 1),
(29, 'Lancier Gondorien', 'Allié', 'Tactique', '3', 1),
(30, 'Archer à Cheval', 'Allié', 'Tactique', '2', 1),
(31, 'Beorn', 'Allié', 'Tactique', '1', 1),
(32, 'Maîtrise des Armes', 'Evénement', 'Tactique', '3', 1),
(33, 'Pluie de Flèches', 'Evénement', 'Tactique', '2', 1),
(34, 'Feinte', 'Evénement', 'Tactique', '2', 1),
(35, 'Coup Rapide', 'Evénement', 'Tactique', '2', 1),
(36, 'Haie de Lances', 'Evénement', 'Tactique', '2', 1),
(37, 'Coup Brutal', 'Evénement', 'Tactique', '1', 1),
(38, 'Faire Face Ensemble', 'Evénement', 'Tactique', '1', 1),
(39, 'Lame de Gondolin', 'Attachement', 'Tactique', '2', 1),
(40, 'Armure de la Citadelle', 'Attachement', 'Tactique', '2', 1),
(41, 'Hache de Nain', 'Attachement', 'Tactique', '2', 1),
(42, 'Cor du Gondor', 'Attachement', 'Tactique', '1', 1),
(43, 'Touque Aventureux', 'Allié', 'Energie', '2', 1),
(44, 'Guide de la Lórien', 'Allié', 'Energie', '3', 1),
(45, 'Traqueur du Nord', 'Allié', 'Energie', '2', 1),
(46, 'Salutations des Galadhrim', 'Evénement', 'Energie', '2', 1),
(47, 'Force de la Volonté', 'Evénement', 'Energie', '2', 1),
(48, 'Coup Précipité', 'Evénement', 'Energie', '2', 1),
(49, 'Volonté de l’Ouest', 'Evénement', 'Energie', '2', 1),
(50, 'Tester sa Volonté', 'Evénement', 'Energie', '2', 1),
(51, 'Tenir et Combattre', 'Evénement', 'Energie', '3', 1),
(52, 'Une Lumière dans les Ténèbres', 'Evénement', 'Energie', '2', 1),
(53, 'Tombe de Nain', 'Evénement', 'Energie', '1', 1),
(54, 'Chance ou Destin', 'Evénement', 'Energie', '1', 1),
(55, 'La Faveur de la Dame', 'Attachement', 'Energie', '2', 1),
(56, 'Le Pouvoir de la Terre', 'Attachement', 'Energie', '2', 1),
(57, 'Courage Inattendu', 'Attachement', 'Energie', '1', 1),
(58, 'Fille de la Nimrodel', 'Allié', 'Connaissance', '3', 1),
(59, 'Forgeron d’Erebor', 'Allié', 'Connaissance', '2', 1),
(60, 'Henamarth Chantrivière', 'Allié', 'Connaissance', '1', 1),
(61, 'Mineurs des Mont du Fer', 'Allié', 'Connaissance', '2', 1),
(62, 'Gléowine', 'Allié', 'Connaissance', '2', 1),
(63, 'Savoir d’Imladris', 'Evénement', 'Connaissance', '3', 1),
(64, 'Opulence de la Lórien', 'Evénement', 'Connaissance', '2', 1),
(65, 'Ruse de Radagast', 'Evénement', 'Connaissance', '2', 1),
(66, 'Chemins Secrets', 'Evénement', 'Connaissance', '2', 1),
(67, 'Recherches de Gandalf', 'Evénement', 'Connaissance', '2', 1),
(68, 'Hospitalité de Beorn', 'Evénement', 'Connaissance', '1', 1),
(69, 'Danger de la Forêt', 'Attachement', 'Connaissance', '2', 1),
(70, 'Protecteur de la Lórien', 'Attachement', 'Connaissance', '2', 1),
(71, 'Savoir Ténébreux', 'Attachement', 'Connaissance', '1', 1),
(72, 'Instinct de Survie', 'Attachement', 'Connaissance', '2', 1),
(73, 'Gandalf', 'Allié', 'Neutre', '4', 1),
(74, 'Bilbon Sacquet', 'Héros', 'Connaissance', '1', 2),
(75, 'Marque Des Dúnedain', 'Attachement', 'Commandement', '3', 2),
(76, 'Histoires au Coin du Feu', 'Evénement', 'Commandement', '3', 2),
(77, 'Gardien Ailé', 'Allié', 'Tactique', '3', 2),
(78, 'Les Aigles Arrivent', 'Evénement', 'Tactique', '3', 2),
(79, 'Dompteur de Chevaux de L’ouestfolde', 'Allié', 'Energie', '3', 2),
(80, 'Rassemblement des Rohirrim', 'Evénement', 'Energie', '3', 2),
(81, 'Ménestrel de Fondcombe', 'Allié', 'Connaissance', '3', 2),
(82, 'Chemin de Grand-Pas', 'Evénement', 'Connaissance', '3', 2),
(83, 'Chant des Rois', 'Attachement', 'Neutre', '3', 2),
(84, 'Frodon Sacquet', 'Héros', 'Energie', '1', 2),
(85, 'Avertissement des Dúnedain', 'Attachement', 'Commandement', '3', 2),
(86, 'Un Second Petit Déjeuner', 'Evénement', 'Commandement', '3', 2),
(87, 'Apiculteur Beornide', 'Allié', 'Tactique', '3', 2),
(88, 'Né en Altitude', 'Attachement', 'Tactique', '3', 2),
(89, 'Éomund', 'Allié', 'Energie', '3', 2),
(90, 'Je ne Suis pas un Étranger', 'Attachement', 'Energie', '3', 2),
(91, 'Cartographe Longue-Barbe', 'Allié', 'Connaissance', '3', 2),
(92, 'Un Tison Enflammé', 'Attachement', 'Connaissance', '3', 2),
(93, 'Chant de Sagesse', 'Attachement', 'Neutre', '3', 2),
(94, 'Prince Imrahil', 'Héros', 'Commandement', '1', 2),
(95, 'Quête des Dúnedain', 'Attachement', 'Commandement', '3', 2),
(96, 'Cadeaux d’Adieu', 'Evénement', 'Commandement', '3', 2),
(97, 'Landroval', 'Allié', 'Tactique', '3', 2),
(98, 'Vers l’Aire des Aigles', 'Evénement', 'Tactique', '3', 2),
(99, 'Escorte d’Edoras', 'Allié', 'Energie', '3', 2),
(100, 'Ancien Mathom', 'Attachement', 'Energie', '3', 2),
(101, 'Haldir de la Lórien', 'Allié', 'Connaissance', '3', 2),
(102, 'Conflits Internes', 'Evénement', 'Connaissance', '3', 2),
(103, 'Radagast', 'Allié', 'Neutre', '3', 2),
(104, 'Brand fils de Bain', 'Héros', 'Tactique', '1', 2),
(105, 'Touque à la Vue Perçante', 'Allié', 'Commandement', '3', 2),
(106, 'Arrière Garde', 'Evénement', 'Commandement', '3', 2),
(107, 'Descendant de Thorondor', 'Allié', 'Tactique', '3', 2),
(108, 'Le voL de Meneldor', 'Evénement', 'Tactique', '3', 2),
(109, 'Monture de Riddermark', 'Allié', 'Energie', '3', 2),
(110, 'Courir à la Ruine', 'Evénement', 'Energie', '3', 2),
(111, 'Gildor Inglorion', 'Allié', 'Connaissance', '3', 2),
(112, 'Conseil de Gildor', 'Evénement', 'Connaissance', '3', 2),
(113, 'Chant du Voyage', 'Attachement', 'Neutre', '3', 2),
(114, 'Boromir', 'Héros', 'Tactique', '1', 2),
(115, 'Observateur Dúnedain', 'Allié', 'Commandement', '3', 2),
(116, 'Cache des Dúnedain', 'Attachement', 'Commandement', '3', 2),
(117, 'Vassal du Seigneur des Vents', 'Allié', 'Tactique', '3', 2),
(118, 'Chant Moqueur', 'Attachement', 'Tactique', '3', 2),
(119, 'Elfhelm', 'Allié', 'Energie', '3', 2),
(120, 'Nous ne Dormons Pas', 'Evénement', 'Energie', '3', 2),
(121, 'Pisteur Sylvain', 'Allié', 'Connaissance', '3', 2),
(122, 'Nœud Serré', 'Attachement', 'Connaissance', '3', 2),
(123, 'Chant de Bataille', 'Attachement', 'Neutre', '3', 2),
(124, 'Dáin Pied d’Acier', 'Héros', 'Commandement', '1', 2),
(125, 'Signe des Dúnedain', 'Attachement', 'Commandement', '3', 2),
(126, 'Que l’Aube Vous Saisisse', 'Evénement', 'Commandement', '3', 2),
(127, 'Aigles des Monts Brumeux', 'Allié', 'Tactique', '3', 2),
(128, 'Soutien des Aigles', 'Attachement', 'Tactique', '3', 2),
(129, 'Voyageuse de la Route de l’Ouest ', 'Allié', 'Energie', '3', 2),
(130, 'Rapidité Étonnante', 'Evénement', 'Energie', '3', 2),
(131, 'Messager de la Forêt Noire', 'Allié', 'Connaissance', '3', 2),
(132, 'Rumeur de la Terre', 'Evénement', 'Connaissance', '3', 2),
(133, 'Une Ombre du Passé', 'Evénement', 'Neutre', '3', 2);

-- --------------------------------------------------------

--
-- Structure de la table `cartes_deck`
--

CREATE TABLE `cartes_deck` (
  `id_carte_deck` int(10) NOT NULL,
  `id_carte` int(10) DEFAULT NULL,
  `id_deck` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conteneur`
--

CREATE TABLE `conteneur` (
  `id_contn` int(11) NOT NULL,
  `nom_contn` varchar(45) DEFAULT NULL,
  `abbr_contn` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `conteneur`
--

INSERT INTO `conteneur` (`id_contn`, `nom_contn`, `abbr_contn`) VALUES
(1, 'Boîte de base', 'BB'),
(2, 'Cycle 1', 'C1');

-- --------------------------------------------------------

--
-- Structure de la table `decks`
--

CREATE TABLE `decks` (
  `id_deck` int(10) NOT NULL,
  `id_carte_deck` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

CREATE TABLE `partie` (
  `id_partie` int(10) NOT NULL,
  `deck_partie` int(10) DEFAULT NULL,
  `date_partie` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `resultat` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `scenarios`
--

CREATE TABLE `scenarios` (
  `id_scnr` int(11) NOT NULL,
  `nom_scnr` varchar(45) DEFAULT NULL,
  `id_conteneur` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `scenarios`
--

INSERT INTO `scenarios` (`id_scnr`, `nom_scnr`, `id_conteneur`) VALUES
(1, 'Passage dans la forêt noire', 1),
(2, 'Voyage le long de l''Anduin', 1),
(3, 'L''évasion de Dol Guldur', 1),
(4, 'A la poursuite de Gollum', 2),
(5, 'Conflit au Carrock', 2),
(6, 'Voyage à Rhosgobel', 2),
(7, 'Les collines d''Emyn Muil', 2),
(8, 'Le marais des morts', 2),
(9, 'Retour à la forêl noire', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cartes`
--
ALTER TABLE `cartes`
  ADD PRIMARY KEY (`id_carte`);

--
-- Index pour la table `cartes_deck`
--
ALTER TABLE `cartes_deck`
  ADD PRIMARY KEY (`id_carte_deck`);

--
-- Index pour la table `conteneur`
--
ALTER TABLE `conteneur`
  ADD PRIMARY KEY (`id_contn`);

--
-- Index pour la table `decks`
--
ALTER TABLE `decks`
  ADD PRIMARY KEY (`id_deck`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`id_partie`);

--
-- Index pour la table `scenarios`
--
ALTER TABLE `scenarios`
  ADD PRIMARY KEY (`id_scnr`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cartes`
--
ALTER TABLE `cartes`
  MODIFY `id_carte` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;
--
-- AUTO_INCREMENT pour la table `cartes_deck`
--
ALTER TABLE `cartes_deck`
  MODIFY `id_carte_deck` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `conteneur`
--
ALTER TABLE `conteneur`
  MODIFY `id_contn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `decks`
--
ALTER TABLE `decks`
  MODIFY `id_deck` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `partie`
--
ALTER TABLE `partie`
  MODIFY `id_partie` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `scenarios`
--
ALTER TABLE `scenarios`
  MODIFY `id_scnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
