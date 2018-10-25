-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2018 at 07:50 AM
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
-- Database: `servicera`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `fone` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `endereco`, `fone`, `email`) VALUES
(1, 'Linus Torvalds', 'Rua Tux, 2015', '(11) 96654-2221', 'linus@linus.com'),
(2, 'Thomas Thorm', 'Rua da Publicação', '11 9 7738-7625', 'gabrielribello100@gmail.com'),
(5, 'Antonio da Silva', 'Rua Tuiuti', '(11) 96654-1223', 'antoniaoservic@serviços.com');

-- --------------------------------------------------------

--
-- Table structure for table `ordem_servicos`
--

CREATE TABLE `ordem_servicos` (
  `id` int(11) NOT NULL,
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
-- Dumping data for table `ordem_servicos`
--

INSERT INTO `ordem_servicos` (`id`, `dataos`, `tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `idcli`) VALUES
(1, '2018-10-09 15:21:58', 'Orçamento', 'Na Bancada', 'Notebook', 'Não Liga', 'Troca da Fonte', 'Muerto', '87.50', 1),
(2, '2018-10-11 20:30:47', 'Orçamento', 'Aguardando Aprovação', 'Notebook', 'Não Liga', 'Troca da Fonte', 'Gabriel', '150.00', 1),
(4, '2018-10-13 02:21:00', 'Orçamento', 'Entrega Ok', 'Notebook Famous', 'Não Ligava', 'OK', 'Zézinho', '152.52', 1),
(5, '2018-10-13 08:05:53', 'Orçamento', 'Aguardando Peças', 'Monitor 144hz', 'Botão não funciona', 'troca de botão', 'Zézinho', '150.25', 6),
(6, '2018-10-13 19:24:37', 'Orçamento', 'Na Bancada', 'Notebook Papo', 'Tela não liga', 'Troca de Tela', 'Zé', '350.00', 7),
(7, '2018-10-19 00:00:01', 'OS', 'Na Bancada', 'Notebook', 'cu', 'mete no cu', 'ze buceta', '1000.00', 6),
(8, '2018-10-19 19:02:28', 'Orçamento', 'Entrega Ok', 'Notebook', 'Ta vivo', 'Quebrar na porrada', 'zé buceta', '1000.00', 6);

-- --------------------------------------------------------

--
-- Table structure for table `perfil`
--

CREATE TABLE `perfil` (
  `id` int(11) NOT NULL,
  `perfil` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perfil`
--

INSERT INTO `perfil` (`id`, `perfil`) VALUES
(1, 'admin'),
(2, 'técnico');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `fone` varchar(15) DEFAULT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `fone`, `login`, `senha`, `perfil`) VALUES
(1, 'Administrador', '(11) 99851-6665', 'adm', 'b09c600fddc573f117449b3723f23d64', 'admin'),
(5, 'Henrique', '(11) 94905-4687', 'tinem', 'd41d8cd98f00b204e9800998ecf8427e', 'técnico'),
(6, 'Jeferson', '(11) 97736-1586', 'jeff', '250cf8b51c773f3f8dc8b4be867a9a02', 'técnico'),
(9, 'Palinka', '(11) 98854-8195', 'palinka', '138b6f104921a050728d1585e8548c0a', 'técnico'),
(15, 'Gabriel', '(11) 97738-7625', 'gab', '49bd8944a53f240d3a3914f68b2e51b9', 'técnico');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ordem_servicos`
--
ALTER TABLE `ordem_servicos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `ordem_servicos`
--
ALTER TABLE `ordem_servicos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
