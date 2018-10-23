-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 23-Out-2018 às 14:23
-- Versão do servidor: 10.1.35-MariaDB
-- versão do PHP: 7.2.9

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
-- Estrutura da tabela `perfil`
--

CREATE TABLE `perfil` (
  `id` int(11) NOT NULL,
  `perfil` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`id`, `perfil`) VALUES
(1, 'admin'),
(2, 'técnico');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbclientes`
--

CREATE TABLE `tbclientes` (
  `idcli` int(11) NOT NULL,
  `nomecli` varchar(50) NOT NULL,
  `endcli` varchar(100) DEFAULT NULL,
  `fonecli` varchar(50) NOT NULL,
  `emailcli` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbclientes`
--

INSERT INTO `tbclientes` (`idcli`, `nomecli`, `endcli`, `fonecli`, `emailcli`) VALUES
(1, 'Linus Torvalds', 'Rua Tux, 2015', '9999-9999', 'linus@linus.com'),
(2, 'Thomas Thorm', 'Rua da Publicação', '11 9 7738-7625', 'gabrielribello100@gmail.com'),
(3, 'Manilus Manolis', 'Rua das Trincheiras', '11 8856-6636', 'forapt@forapt'),
(4, 'Fernando Uhaad', 'Rua da Libertação', '13 1352-1312', 'lulalivre@pt.com'),
(5, 'Antonio da Silva', 'Rua Tuiuti', '11 9 7856-3521', 'antoniaoservic@serviços.com'),
(6, 'Henrique Tinem', 'Rua Manguaçal', '11 9 8565-2563', 'henriquetinem1@blablabla'),
(7, 'Camila Peres', 'Rua Honji', '11 9 5865-6532', 'camilaperes@gmail.com'),
(8, 'Gabriel', 'DAOCU', '123', '123@123.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbos`
--

CREATE TABLE `tbos` (
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
-- Extraindo dados da tabela `tbos`
--

INSERT INTO `tbos` (`id`, `dataos`, `tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `idcli`) VALUES
(1, '2018-10-09 15:21:58', 'Orçamento', 'Na Bancada', 'Notebook', 'Não Liga', 'Troca da Fonte', 'Muerto', '87.50', 1),
(2, '2018-10-11 20:30:47', 'Orçamento', 'Aguardando Aprovação', 'Notebook', 'Não Liga', 'Troca da Fonte', 'Gabriel', '150.00', 1),
(4, '2018-10-13 02:21:00', 'Orçamento', 'Entrega Ok', 'Notebook Famous', 'Não Ligava', 'OK', 'Zézinho', '152.52', 1),
(5, '2018-10-13 08:05:53', 'Orçamento', 'Aguardando Peças', 'Monitor 144hz', 'Botão não funciona', 'troca de botão', 'Zézinho', '150.25', 6),
(6, '2018-10-13 19:24:37', 'Orçamento', 'Na Bancada', 'Notebook Papo', 'Tela não liga', 'Troca de Tela', 'Zé', '350.00', 7),
(7, '2018-10-19 00:00:01', 'OS', 'Na Bancada', 'Notebook', 'cu', 'mete no cu', 'ze buceta', '1000.00', 6),
(8, '2018-10-19 19:02:28', 'Orçamento', 'Entrega Ok', 'Notebook', 'Ta vivo', 'Quebrar na porrada', 'zé buceta', '1000.00', 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
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
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `fone`, `login`, `senha`, `perfil`) VALUES
(1, 'Administrador', '3333-3333', 'adm', 'b09c600fddc573f117449b3723f23d64', 'admin'),
(5, 'Henrique', '11949054687', 'tinem', 'e10adc3949ba59abbe56e057f20f883e', 'admin'),
(6, 'cu', '1111111', 'batata', 'e10adc3949ba59abbe56e057f20f883e', 'técnico'),
(7, 'Henrique Tinem', '1111111', 'liltinem', 'e10adc3949ba59abbe56e057f20f883e', 'admin'),
(8, 'lilTinem', '123', 'lil', '202cb962ac59075b964b07152d234b70', 'admin'),
(9, 'Palinka', '123', 'palinka', 'e10adc3949ba59abbe56e057f20f883e', 'técnico'),
(11, 'Gilza', '123123', 'gil', '4297f44b13955235245b2497399d7a93', 'técnico'),
(13, 'Gilza', '123123', 'gilza', '202cb962ac59075b964b07152d234b70', 'técnico');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbclientes`
--
ALTER TABLE `tbclientes`
  ADD PRIMARY KEY (`idcli`);

--
-- Indexes for table `tbos`
--
ALTER TABLE `tbos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcli` (`idcli`);

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
-- AUTO_INCREMENT for table `tbclientes`
--
ALTER TABLE `tbclientes`
  MODIFY `idcli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbos`
--
ALTER TABLE `tbos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tbos`
--
ALTER TABLE `tbos`
  ADD CONSTRAINT `tbos_ibfk_1` FOREIGN KEY (`idcli`) REFERENCES `tbclientes` (`idcli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
