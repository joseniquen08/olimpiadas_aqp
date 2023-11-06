-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2023 a las 02:23:05
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `olimpiadas_aqp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `admin_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `dni` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`admin_id`, `created_at`, `dni`, `user_id`) VALUES
(1, '2023-11-02 21:12:22', 87654321, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `client_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `phone` bigint(20) NOT NULL,
  `representative` varchar(255) NOT NULL,
  `ruc` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`client_id`, `created_at`, `phone`, `representative`, `ruc`, `user_id`) VALUES
(1, '2023-11-02 23:47:55', 987654123, 'Pedro Martinez Editado', 21763598712, 2),
(2, '2023-11-03 21:24:27', 982176435, 'Miguel García Perez', 12345678901, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delegate`
--

CREATE TABLE `delegate` (
  `delegate_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `dni` bigint(20) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `delegate`
--

INSERT INTO `delegate` (`delegate_id`, `created_at`, `dni`, `phone`, `user_id`) VALUES
(1, '2023-11-04 15:54:58', 87126534, 933839178, 4),
(2, '2023-11-06 01:11:41', 87216534, 986754231, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delegate_event`
--

CREATE TABLE `delegate_event` (
  `delegate_event_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `delegate_id` bigint(20) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `event`
--

CREATE TABLE `event` (
  `event_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `name` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `client_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `event`
--

INSERT INTO `event` (`event_id`, `created_at`, `name`, `start_date`, `status`, `client_id`) VALUES
(1, '2023-11-02 23:54:19', 'Olimpiadas CIMA 2023', '2023-11-20', 1, 1),
(5, '2023-11-04 16:36:27', 'Olimpiadas UTP 2023 - Chiclayo', '2023-12-10', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`role_id`, `created_at`, `name`) VALUES
(1, '2023-11-02 21:11:12', 'ADMIN'),
(2, '2023-11-02 21:11:12', 'CLIENTE'),
(3, '2023-11-02 21:11:12', 'DELEGADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sport`
--

CREATE TABLE `sport` (
  `sport_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sport`
--

INSERT INTO `sport` (`sport_id`, `name`, `description`, `created_at`) VALUES
(1, 'Fútbol', 'Deporte con distintas categorías', '2023-11-04 18:44:11'),
(2, 'Básquet', 'Cuenta con distintas disciplinas', '2023-11-04 18:52:27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sport_event`
--

CREATE TABLE `sport_event` (
  `sport_event_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `event_id` bigint(20) DEFAULT NULL,
  `sport_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(511) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`user_id`, `created_at`, `email`, `full_name`, `password`, `role_id`) VALUES
(1, '2023-11-02 21:11:39', 'admin@olimpiadasaqp.com', 'Admin Principal', '$2a$12$hFl8SA/4kOrP9AoLRB7YwO4jD.AymvXnCp6aNZB66vDsM2o6bYSke', 1),
(2, '2023-11-02 23:47:55', 'marketing@cima.edu.pe', 'Colegio CIMA', '$2a$10$msJpWhjvhf7G3hOS3DN5/.Lmv0Dfrp.6f5KYwuvACEOazLP4NXZji', 2),
(3, '2023-11-03 21:24:27', 'sedechiclayo@utp.edu.pe', 'Universidad Tecnológica del Perú - Chiclayo', '$2a$10$eDuYeA9uLGIOwVyUengHYej0hXFnqIOASIIolTMCYhLrkpeVr8g9G', 2),
(4, '2023-11-04 15:54:58', 'j.armando0807@gmail.com', 'Jose Ñiquen Farroñay', '$2a$10$HV3YtkjMyZGoaFM1snlwZO6pfTv1i37T1TUoTD1f3RKQkt08B.qSW', 3),
(8, '2023-11-06 01:11:41', 'juancarrion@gmail.com', 'Juan Carrion', '$2a$10$FTpoPjYKMTdx8Nq4LeMTFu40OUdNMMESAMPwUbUSFO/GyvKT4ylfq', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `UK_pb3h92bcsnipyrbxqw9g88spq` (`dni`),
  ADD UNIQUE KEY `UK_hawikyhwwfvbnog5byokutpff` (`user_id`),
  ADD UNIQUE KEY `index_dni` (`dni`);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`),
  ADD UNIQUE KEY `UK_1ixfyfepst9sjbo9op1v65fg0` (`user_id`);

--
-- Indices de la tabla `delegate`
--
ALTER TABLE `delegate`
  ADD PRIMARY KEY (`delegate_id`),
  ADD UNIQUE KEY `UK_653koa5m8b48dn8knhu1sih6x` (`dni`),
  ADD UNIQUE KEY `UK_6xadjan9s982jr0c26pm4rakw` (`user_id`);

--
-- Indices de la tabla `delegate_event`
--
ALTER TABLE `delegate_event`
  ADD PRIMARY KEY (`delegate_event_id`),
  ADD KEY `FKd718squjet0k4r9souc6w2qea` (`delegate_id`),
  ADD KEY `FK33lgiy34jcmc3oulajy20h7ao` (`event_id`);

--
-- Indices de la tabla `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `FKtpp6e5l87vdkxia1nfxv2r3il` (`client_id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indices de la tabla `sport`
--
ALTER TABLE `sport`
  ADD PRIMARY KEY (`sport_id`);

--
-- Indices de la tabla `sport_event`
--
ALTER TABLE `sport_event`
  ADD PRIMARY KEY (`sport_event_id`),
  ADD KEY `FKdnibsafi0k271mfcdvl4bfxv8` (`event_id`),
  ADD KEY `FK5vi098clvdw39oeft74ih4jax` (`sport_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `index_email` (`email`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `client_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `delegate`
--
ALTER TABLE `delegate`
  MODIFY `delegate_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `delegate_event`
--
ALTER TABLE `delegate_event`
  MODIFY `delegate_event_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `event`
--
ALTER TABLE `event`
  MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sport`
--
ALTER TABLE `sport`
  MODIFY `sport_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sport_event`
--
ALTER TABLE `sport_event`
  MODIFY `sport_event_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK8ahhk8vqegfrt6pd1p9i03aej` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Filtros para la tabla `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKk1fi84oi1yyuswr40h38kjy1s` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Filtros para la tabla `delegate`
--
ALTER TABLE `delegate`
  ADD CONSTRAINT `FKp6gramowkaekmoc6f3qvmuj1r` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Filtros para la tabla `delegate_event`
--
ALTER TABLE `delegate_event`
  ADD CONSTRAINT `FK33lgiy34jcmc3oulajy20h7ao` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  ADD CONSTRAINT `FKd718squjet0k4r9souc6w2qea` FOREIGN KEY (`delegate_id`) REFERENCES `delegate` (`delegate_id`);

--
-- Filtros para la tabla `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FKtpp6e5l87vdkxia1nfxv2r3il` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`);

--
-- Filtros para la tabla `sport_event`
--
ALTER TABLE `sport_event`
  ADD CONSTRAINT `FK5vi098clvdw39oeft74ih4jax` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`sport_id`),
  ADD CONSTRAINT `FKdnibsafi0k271mfcdvl4bfxv8` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
