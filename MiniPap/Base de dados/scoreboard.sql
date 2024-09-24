-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10-Abr-2024 às 00:47
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `scoreboard`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tempo_1m`
--

CREATE TABLE `tempo_1m` (
  `nome` text NOT NULL,
  `pontuacao` int(11) NOT NULL,
  `precisao` int(11) NOT NULL,
  `erros` int(11) NOT NULL,
  `circulos_nao_acertados` int(11) NOT NULL,
  `tempo_jogado` int(11) NOT NULL,
  `dificuldade` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tempo_2m`
--

CREATE TABLE `tempo_2m` (
  `nome` text NOT NULL,
  `pontuacao` int(11) NOT NULL,
  `precisao` int(11) NOT NULL,
  `erros` int(11) NOT NULL,
  `circulos_nao_acertados` int(11) NOT NULL,
  `tempo_jogado` int(11) NOT NULL,
  `dificuldade` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tempo_10`
--

CREATE TABLE `tempo_10` (
  `nome` text NOT NULL,
  `pontuacao` int(11) NOT NULL,
  `precisao` int(11) NOT NULL,
  `erros` int(11) NOT NULL,
  `circulos_nao_acertados` int(11) NOT NULL,
  `tempo_jogado` int(11) NOT NULL,
  `dificuldade` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tempo_30`
--

CREATE TABLE `tempo_30` (
  `nome` text NOT NULL,
  `pontuacao` int(11) NOT NULL,
  `precisao` int(11) NOT NULL,
  `erros` int(11) NOT NULL,
  `circulos_nao_acertados` int(11) NOT NULL,
  `tempo_jogado` int(11) NOT NULL,
  `dificuldade` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
