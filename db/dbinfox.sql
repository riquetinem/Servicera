-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2018 at 05:06 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbinfox`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbclientes`
--

CREATE TABLE `tbclientes` (
  `idcli` int(11) NOT NULL,
  `nomecli` varchar(50) NOT NULL,
  `endcli` varchar(100) DEFAULT NULL,
  `fonecli` varchar(50) NOT NULL,
  `emailcli` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbclientes`
--

INSERT INTO `tbclientes` (`idcli`, `nomecli`, `endcli`, `fonecli`, `emailcli`) VALUES
(1, 'Linus Torvalds', 'Rua Tux, 2015', '9999-9999', 'linus@linus.com'),
(2, 'Thomas Thorm', 'Rua da Publicação', '11 9 7738-7625', 'gabrielribello100@gmail.com'),
(3, 'Manilus Manolis', 'Rua das Trincheiras', '11 8856-6636', 'forapt@forapt'),
(4, 'Fernando Uhaad', 'Rua da Libertação', '13 1352-1312', 'lulalivre@pt.com'),
(5, 'Antonio da Silva', 'Rua Tuiuti', '11 9 7856-3521', 'antoniaoservic@serviços.com'),
(6, 'Henrique Tinem', 'Rua Manguaçal', '11 9 8565-2563', 'henriquetinem1@blablabla'),
(7, 'Camila Peres', 'Rua Honji', '11 9 5865-6532', 'camilaperes@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbos`
--

CREATE TABLE `tbos` (
  `os` int(11) NOT NULL,
  `dataos` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(30) NOT NULL,
  `situacao` varchar(20) NOT NULL,
  `equipamento` varchar(150) NOT NULL,
  `defeito` varchar(150) NOT NULL,
  `servico` varchar(150) DEFAULT NULL,
  `tecnico` varchar(30) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `idcli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbos`
--

INSERT INTO `tbos` (`os`, `dataos`, `tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `idcli`) VALUES
(1, '2018-10-09 15:21:58', 'Orçamento', 'Na Bancada', 'Notebook', 'Não Liga', 'Troca da Fonte', 'Muerto', '87.50', 1),
(2, '2018-10-11 20:30:47', 'Orçamento', 'Aguardando Aprovação', 'Notebook', 'Não Liga', 'Troca da Fonte', 'Gabriel', '150.00', 1),
(4, '2018-10-13 02:21:00', 'Orçamento', 'Entrega Ok', 'Notebook Famous', 'Não Ligava', 'OK', 'Zézinho', '152.52', 1),
(5, '2018-10-13 08:05:53', 'Orçamento', 'Aguardando Peças', 'Monitor 144hz', 'Botão não funciona', 'troca de botão', 'Zézinho', '150.25', 6),
(6, '2018-10-13 19:24:37', 'Orçamento', 'Na Bancada', 'Notebook Papo', 'Tela não liga', 'Troca de Tela', 'Zé', '350.00', 7);

-- --------------------------------------------------------

--
-- Table structure for table `tbusuarios`
--

CREATE TABLE `tbusuarios` (
  `iduser` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fone` varchar(15) DEFAULT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbusuarios`
--

INSERT INTO `tbusuarios` (`iduser`, `usuario`, `fone`, `login`, `senha`, `perfil`) VALUES
(1, 'Administrador', '3333-3333', 'adm', 'b09c600fddc573f117449b3723f23d64', 'admin'),
(4, 'Zezinho', '11 9 5656-9464', 'ze', 'b09c600fddc573f117449b3723f23d64', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbclientes`
--
ALTER TABLE `tbclientes`
  ADD PRIMARY KEY (`idcli`);

--
-- Indexes for table `tbos`
--
ALTER TABLE `tbos`
  ADD PRIMARY KEY (`os`),
  ADD KEY `idcli` (`idcli`);

--
-- Indexes for table `tbusuarios`
--
ALTER TABLE `tbusuarios`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbclientes`
--
ALTER TABLE `tbclientes`
  MODIFY `idcli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbos`
--
ALTER TABLE `tbos`
  MODIFY `os` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbusuarios`
--
ALTER TABLE `tbusuarios`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbos`
--
ALTER TABLE `tbos`
  ADD CONSTRAINT `tbos_ibfk_1` FOREIGN KEY (`idcli`) REFERENCES `tbclientes` (`idcli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
