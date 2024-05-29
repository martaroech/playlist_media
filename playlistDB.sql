-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              11.3.2-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database playlist
CREATE DATABASE IF NOT EXISTS `playlist` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `playlist`;

-- Dump della struttura di tabella playlist.media
CREATE TABLE IF NOT EXISTS `media` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(31) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `duration` double DEFAULT NULL,
  `num_pages` int(11) DEFAULT NULL,
  `num_episodes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella playlist.media: ~4 rows (circa)
INSERT INTO `media` (`id`, `type`, `title`, `author`, `genre`, `duration`, `num_pages`, `num_episodes`) VALUES
	(1, 'song', 'Margarita', 'Elodie', 'Pop', 2.57, NULL, NULL),
	(2, 'book', 'Automatizzare le cose noiose con Python', 'Al Sweigart', 'Programmazione', NULL, 672, NULL),
	(3, 'podcast', 'Focus Economia', 'Radio 24', 'Talk Show', NULL, NULL, 25),
	(4, 'song', 'Luce Nera', 'Bial Dope', 'Sad Rap', 2.51, NULL, NULL);

-- Dump della struttura di tabella playlist.playlists
CREATE TABLE IF NOT EXISTS `playlists` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contents` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella playlist.playlists: ~3 rows (circa)
INSERT INTO `playlists` (`id`, `name`, `contents`) VALUES
	(1, 'Playlist1', NULL),
	(2, 'Playlist2', NULL),
	(3, 'Playlist3', NULL);

-- Dump della struttura di tabella playlist.playlists_media
CREATE TABLE IF NOT EXISTS `playlists_media` (
  `id_playlist` bigint(20) unsigned NOT NULL DEFAULT 0,
  `id_media` bigint(20) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_playlist`,`id_media`),
  KEY `id_playlist` (`id_playlist`) USING BTREE,
  KEY `id_media` (`id_media`),
  CONSTRAINT `id_media` FOREIGN KEY (`id_media`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_playlist` FOREIGN KEY (`id_playlist`) REFERENCES `playlists` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella playlist.playlists_media: ~4 rows (circa)
INSERT INTO `playlists_media` (`id_playlist`, `id_media`) VALUES
	(1, 3),
	(1, 4),
	(2, 1),
	(3, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
