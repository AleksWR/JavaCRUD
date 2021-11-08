--
-- Banco de dados: `banco`
--
CREATE DATABASE banco;
USE banco;

-- --------------------------------------------------------

--
-- Estrutura da tabela `imc`
--

CREATE TABLE `imc` (
  `id` int(11) NOT NULL,
  `imc` double NOT NULL,
  `classificacao` varchar(45) NOT NULL,
  `fk_IdP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `login` varchar(100) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `fk_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `Id` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Altura` double NOT NULL,
  `Peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `imc`
--
ALTER TABLE `imc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_fk_IdP` (`fk_IdP`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`login`),
  ADD KEY `id_fk_Id` (`fk_Id`);

--
-- Índices para tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `imc`
--
ALTER TABLE `imc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `imc`
--
ALTER TABLE `imc`
  ADD CONSTRAINT `id_fk_IdP` FOREIGN KEY (`fk_IdP`) REFERENCES `paciente` (`Id`);

--
-- Limitadores para a tabela `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `id_fk_Id` FOREIGN KEY (`fk_Id`) REFERENCES `paciente` (`Id`);
COMMIT;


