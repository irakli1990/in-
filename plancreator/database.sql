-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 26 Sie 2019, 18:19
-- Wersja serwera: 10.1.36-MariaDB
-- Wersja PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `auth`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `department`
--

CREATE TABLE `department` (
  `id_department` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `akronim` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `department`
--

INSERT INTO `department` (`id_department`, `name`, `akronim`) VALUES
(1, 'Wydział Artystyczny', 'wart'),
(2, 'Wydział Biologii i Ochrony Środowiska', 'wbios'),
(3, 'Wydział Etnologii i Nauk o Edukacji', 'weino'),
(4, 'Wydział Filologiczny', 'wyfil'),
(5, 'Wydział Informatyki i Nauki o Materiałach', 'wiinom'),
(6, 'Wydział Matematyki, Fizyki i Chemii', 'wmfch'),
(7, 'Wydział Nauk o Ziemi', 'wnoz'),
(8, 'Wydział Nauk Społecznych', 'wns'),
(9, 'Wydział Pedagogiki i Psychologii', 'wpips'),
(10, 'Wydział Prawa i Administracji', 'wpia'),
(11, 'Wydział Radia i Telewizji im. Krzysztofa Kieślowskiego', 'writv'),
(12, 'Wydział Teologiczny', 'wtl');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(62),
(62);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `minimum`
--

CREATE TABLE `minimum` (
  `id_min` int(11) NOT NULL,
  `major` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `level` varchar(11) COLLATE utf8_polish_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `depertment_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `minimum`
--

INSERT INTO `minimum` (`id_min`, `major`, `level`, `note`, `depertment_id`) VALUES
(1, 'edukacja artystyczna w zakresie sztuk plastycznych', 'I st.', '', 1),
(2, 'edukacja artystyczna w zakresie sztuk plastycznych', 'II st.', '', 1),
(3, 'edukacja artystyczna w zakresie sztuki muzycznej', 'I st.', 'należy zrealizować wspólną podstawę (pierwsza zakładka) i wybraną specjalność (kolejne zakładki)', 1),
(4, 'edukacja artystyczna w zakresie sztuki muzycznej', 'II st.', '', 1),
(5, 'biologia', 'I st.', 'przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(6, 'biologia', 'II st.', 'przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(7, 'biotechnologia', 'I st.', 'przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(8, 'biotechnologia', 'II st.', 'specjalność: biotechnologia roślin przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(9, 'biotechnologia', 'II st.', 'specjalność: biotechnologia środowiska przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(10, 'ochrona środowiska', 'I st.', 'przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(11, 'ochrona środowiska', 'II st.', 'przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(12, 'biologia żywności i żywienia', 'II st.', 'przedmioty do wyboru: należy zrealizować moduły za 8 ECTS/rok ak.', 2),
(13, 'etnologia i antropologia kulturowa', 'I st.', 'specjalność: antropologia stosowana i studia kulturowe', 3),
(14, 'etnologia i antropologia kulturowa', 'I st.', 'specjalność: dziedzictwo kulturowe w sektorze kreatywnym', 3),
(15, 'etnologia i antropologia kulturowa', 'II st.', 'specjalność: ekologia kulturowa', 3),
(16, 'etnologia i antropologia kulturowa', 'II st.', 'specjalność: etnologiczno-antropologiczna', 3),
(17, 'etnologia i antropologia kulturowa', 'II st.', 'specjalność: antropologia w produkcji rozrywki elektronicznej', 3),
(18, 'pedagogika', 'I st.', 'specjalność: doradztwo zawodowe i edukacyjne z socjoterapią ', 3),
(19, 'pedagogika', 'I st.', 'specjalność: animacja społeczno-kulturalna', 3),
(20, 'pedagogika', 'I st.', 'specjalność: opiekuńczo-wychowawcza z asystentem rodziny', 3),
(21, 'pedagogika', 'II st.', 'specjalność: opiekuńczo-wychowawcza z terapią pedagogiczną', 3),
(22, 'pedagogika', 'I st.', 'specjalność: terapia pedagogiczna i asystent osoby niespełnosprawnej', 3),
(23, 'pedagogika', 'II st.', 'specjalność: terapia pedagogiczna i asystent osoby niespełnosprawnej', 3),
(24, 'pedagogika', 'II st.', 'specjalność: resocjalizacja z edukacją międzykulturową', 3),
(25, 'pedagogika', 'II st.', 'specjalność: pedagogika społeczna z geragogiką', 3),
(26, 'animacja społeczno-kulturalna z edukacją kulturalną', 'I st.', '', 3),
(27, 'oligofrenopedagogika z arteterapią', 'I st.', 'pedagogika osób niepełnosprawnych intelektualnie z arteterapią', 3),
(28, 'pedagogika osób niepełnosprawnych z arteterapią', 'II st.', 'pedagogika osób niepełnosprawnych intelektualnie z arteterapią', 3),
(29, 'Instytut Języka Angielskiego', '', '', 4),
(30, 'Instytut Kultur i Literatur Anglojęzycznych', '', '', 4),
(31, 'Instytut Języków Romańskich i Translatoryki', '', '', 4),
(32, 'Instytut Filologii Germańskiej', '', '', 4),
(33, 'Instytut Filologii Wschodniosłowiańskiej', '', '', 4),
(34, 'Instytut Filologii Słowiańskiej', '', '', 4),
(35, 'filologia polska', 'I st.', '', 4),
(36, 'filologia polska', 'II st.', '', 4),
(37, 'kulturoznawstwo', 'I st.', '', 4),
(38, 'kulturoznawstwo', 'II st.', '', 4),
(39, 'kultury mediów', 'I st.', '', 4),
(40, 'kultury mediów', 'II st.', '', 4),
(41, 'komunikacja promocyjna i kryzysowa', 'I st.', '', 4),
(42, 'komunikacja promocyjna i kryzysowa', 'I st.', 'spec: doradztwo wizerunkowe i rzecznikostwo', 4),
(43, 'komunikacja promocyjna i kryzysowa', 'I st.', 'spec: logopedyczna', 4),
(44, 'komunikacja promocyjna i kryzysowa', 'I st.', 'spec: negocjacje kryzysowe', 4),
(45, 'komunikacja promocyjna i kryzysowa', 'I st.', 'spec: komunikacja promocyjna', 4),
(46, 'antropologia języka i komunikacji', 'II st.', '', 4),
(47, 'filologia klasyczna', 'I st.', '', 4),
(48, 'mediteranistyka', 'I st.', '', 4),
(49, 'międzynarodowe studia polskie', 'II st.', '', 4),
(50, 'międzynarodowe studia polskie', 'I st.', 'kultura i komunikacja w biznesie', 4),
(51, 'międzynarodowe studia polskie', 'I st.', 'kultura i komunikacja w dyplomacji', 4),
(52, 'międzynarodowe studia polskie', 'I st.', 'kultura i komunikacja w turystyce', 4),
(53, 'międzynarodowe studia polskie', 'II st.', 'doradztwo kulturowe', 4),
(54, 'międzynarodowe studia polskie', 'II st.', 'publicystyka kulturowa', 4),
(55, 'międzynarodowe studia polskie', 'II st.', 'translatoryka', 4),
(56, 'informacja naukowa i bibiotekoznawstwo', 'I i II st.', '', 4),
(57, 'sztuka pisania', 'I st.', '', 4),
(58, 'mechatronika', 'I st.', 'wiedzę podstawową z modułów na początku tabeli student może zdobyć na dowolnym kierunku', 5),
(59, 'mechatronika', 'II st.', '', 5),
(60, 'inżynieria materiałowa', '', 'wszystkie poziomy i specjalizacje (w zakładkach) grupę modułów podstawowych student może zrealizować na dowolnym kierunku', 5),
(61, 'informatyka inż.', 'I st.', '', 5),
(62, 'matematyka', 'I', '', 6),
(63, 'matematyka', 'II', '', 6),
(64, 'Instutut Fizyki', '', '', 6),
(65, 'Instytut Chemii', '', '', 6),
(66, 'geologia', 'I st.', '', 7),
(67, 'geologia', 'II st.', '', 7),
(68, 'geologia stosowana', 'I s.', '', 7),
(69, 'geografia', 'I st.', '', 7),
(70, 'geofizyka', 'I st.', '', 7),
(71, 'geofizyka', 'II st.', '', 7),
(72, 'filozofia', 'I st.', '', 8),
(73, 'filozofia', 'II st.', '', 8),
(74, 'filozofia - specjalność: etyka stosowana', 'II st.', '', 8),
(75, 'filozofia - specjalność: filozoficzno-kulturowa', 'II st.', '', 8),
(76, 'filozofia - specjalność: historyczno-filozoficzna', 'II st.', '', 8),
(77, 'doradztwo filozoficzne i coaching', 'I st.', '', 8),
(78, 'doradztwo filozoficzne i coaching', 'II st.', '', 8),
(79, 'kognitywistyka', 'I st.', '', 8),
(80, 'politologia', 'I st.', '', 8),
(81, 'politologia', 'II st.', '', 8),
(82, 'dziennikarstwo', 'I st.', '', 8),
(83, 'dziennikarstwo', 'II st.', '', 8),
(84, 'bezpieczeństwo narodowe i międzynarodowe', 'I st.', '', 8),
(85, 'bezpieczeństwo narodowe i międzynarodowe', 'II st.', '', 8),
(86, 'doradztwo polityczne i publiczne', 'I st.', '', 8),
(87, 'historia', 'I i II st.', '', 8),
(88, 'socjologia', 'I st.', '', 8),
(89, 'socjologia, spec: socjologia reklamy i komunikacja społeczna (tyklo 2016)', 'I st.', '', 8),
(90, 'socjologia', 'II st.', '', 8),
(91, 'praca socjalna', 'I st.', '', 8),
(92, 'historia sztuki', 'I st.', '', 8),
(93, 'psychologia', 'jednolite', '', 9),
(94, 'pedagogika', 'I st.', 'część ogólna dla wszystkich specjalności', 9),
(95, 'pedagogika', 'I st.', 'edukacja i rehabilitacja os. z niespełnosprawn. intelekt. (2015)', 9),
(96, 'pedagogika', 'I st.', 'pedagogika resocjalizacyjna z penitencjarną (2017)', 9),
(97, 'pedagogika', 'I st.', 'edukacja wczesnoszkolna i wychowanie przedszkolne', 9),
(98, 'pedagogika', 'I st.', 'opiekuńczo-wychowawcza', 9),
(99, 'pedagogika', 'II st.', 'część ogólna dla wszystkich specjalności', 9),
(100, 'pedagogika', 'II st.', 'edukacja wczesnoszkolna i wychowanie przedszkolne', 9),
(101, 'pedagogika', 'II st.', 'opiekuńczo-wychowawcza', 9),
(102, 'pedagogika', 'II st.', 'resocjalizacyjna z profilaktyką społeczną', 9),
(103, 'pedagogika', 'II st.', 'pedagogika rewalidacyjna', 9),
(104, 'pedagogika specjalna', 'I st.', 'edukacja i rehabilitacja os. z niepełnosprawnością intelektualną', 10),
(105, 'administracja', 'I i II', 'studenci realizują wszystkie moduły obligatoryjne i seminarium, a przedmioty fakultatywne - wedle wyboru, na tym lub innym kierunku', 10),
(106, 'przedsiębiorczość', 'I', 'w ISM - wersja papierowa dostępna w sekretariacie ISM (będzie zeskanowane)', 10),
(107, 'przedsiębiorczość', 'II', 'w ISM - wersja papierowa dostępna w sekretariacie ISM (będzie zeskanowane)', 10),
(108, 'prawo', 'MGR', 'minimum programowe z 2017 roku obowiązuje również rocznik 2016/2017', 10),
(109, 'organizacja produkcji filmowej i telewizyjnej', 'I st.', '', 11),
(110, 'organizacja produkcji filmowej i telewizyjnej', 'II st.', '', 11),
(111, 'teologia', 'jednolite', '', 12),
(112, 'nauki o rodzinie', 'I st.', '', 12),
(113, 'nauki o rodzinie', 'II st.', '', 12),
(114, 'dsadsadsaddsad', 'dsad', 'dsadsad', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `firstname` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `active` int(11) NOT NULL,
  `enable` int(11) NOT NULL,
  `eneble` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `firstname`, `lastname`, `enabled`, `active`, `enable`, `eneble`) VALUES
(38, '$2a$10$dOuNVd8cH.BkUcaBiCmPquukdKNW1cZDgGBXDrGi17dfZHOm7mfha', 'janusz@gmail.com', 'Janusz', 'Abramowicz', 0, 1, 0, NULL),
(39, '$2a$10$ExrprDxMy3iVXymGgq/xcujf2EbUDVt6ijnBk583Y3W/81f0uKDei', 'arnold@gmail.com', 'Arnold', 'Szwarcneger', 0, 0, 0, NULL),
(40, '$2a$10$XyCVVY/BWB9RRe3hOCJRaeD8165RUoOSDGYxnA0PhWXjU7.c4hSu6', 'adam@gmail.com', 'Adam', 'Gondzik', 0, 1, 0, NULL),
(41, '$2a$10$vdOkOF1s4VPtOIFxIG.cQe9caVeTxMcJY8vUTUKJK5yZNWtN.WJHe', 'joni@gmail.com', 'Joni ', 'Dep', 0, 0, 0, NULL),
(42, '$2a$10$lz2gGv.znYNUfjfSyiNN0uaSdx13obpzD6r2StntijjV/IgJ3L8IG', 'dato@gmail.com', 'Dato', 'Kardava', 0, 0, 0, NULL),
(43, '$2a$10$7Kv87q54GZ/NtBG2VgK0SOpEEoUkZIIknZPgnbGIbIIBZQ.ELeABy', 'jan@gmail.com', 'Janklod', 'Vandam', 0, 0, 0, NULL),
(44, '$2a$10$vt6ybMatSFLqyswpxzQgvuDnDHSSdB3VwLrabr4BWDU6Ulfg/RXPq', 'anna@gmail.com', 'Andria', 'Bakuradze', 0, 1, 0, NULL),
(45, '$2a$10$s.aR.EZNBntXYM8xP9MwtOzuHTk8sQBHsnsR1H5ceTeFIe2Joq/BC', 'term@gmail.com', 'Terminator', 'Terminatroski', 0, 0, 0, NULL),
(46, '$2a$10$GWw1wAjyANxSinxZVEqCF.NN9OVYLwbIyfIqjotsGtiZv4eWFXIGW', 'malgorata@gmail.com', 'Małgorzata', 'Abramowicz', 0, 0, 0, NULL),
(47, '$2a$10$DZ6C8smAYC/hcgXIDgQo4Ox.DtSKWKSVk1bxIJCTC/1lhNjKT6pwq', 'siguer@gmail.com', 'David', 'Siguer', 0, 0, 0, NULL),
(48, '$2a$10$LdMQnC6VslzDH3Q00mFtEedp6.zqm6jXh.8./eCWh6JUBjGX9n5Dy', 'siguera@gmail.com', 'David', 'Siguer', 0, 0, 0, NULL),
(49, '$2a$10$duiPBxSax6Lcn49EdTQt3uT4mChJH7oHe43gMFlaiOXFJv6Xt.b6S', 'san@gmail.com', 'Sakamoto', 'San', 0, 0, 0, NULL),
(50, '$2a$10$YnudeMGwTOl/CTHaKRlnreW0iS23jSG/t1YtxBVcZnMXgR8IjhKRW', 'sana@gmail.com', 'Sakamoto', 'Sana', 0, 0, 0, NULL),
(51, '$2a$10$I065aeXQyWg1qGIXf2lTmOExy9he0P4lpF.EgmjxDHT4dyOdMaVbK', 'tata@gmail.com', 'tata', 'tatowicz', 0, 0, 0, NULL),
(57, '$2a$10$xzsL3iwa/QQHxTmdj.BSLukuFiEuSmXQkZFWJctd1F98M8Vb3Pbw6', 'romen@kasa.com', 'Roman', 'Abramowicz', 1, 0, 0, NULL),
(58, '$2a$10$X28q8D25TPvjCKRBF1uCreDX5lK/duE4CtP9s//abMg6QmPuUdAju', 'lora@gmail.com', 'Lora', 'Lorowicz', 1, 0, 0, NULL),
(59, '$2a$10$VHMTaJxXZy.XP6q.PbGF7uZGQA6AWPSMRgGAkmFMgu/J4sb1k2r3a', 'shaurma@gmail.com', 'Ataman', 'Shaurma', 1, 0, 0, NULL),
(60, '$2a$10$W4/VSMxfH7Xt0M8mwsUOc.pxTDt5ZqYuFJWiffr7ltMZ7AeqQ3Pbq', 'naomi@gmail.com', 'Naumi', 'Kembel', 1, 0, 0, NULL),
(61, '$2a$10$pXdYz7g78TucbyUmbB2rxu8pxgMwYxFZPntfV9OrFo6LCvtQb7SQa', 'noras@gmail.com', 'Monika', 'Noras', 1, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(37, 1),
(38, 2),
(39, 1),
(40, 1),
(41, 1),
(42, 1),
(43, 1),
(44, 1),
(45, 1),
(46, 1),
(47, 1),
(48, 1),
(49, 1),
(50, 2),
(51, 1),
(57, 1),
(58, 1),
(59, 1),
(60, 1),
(61, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id_department`);

--
-- Indeksy dla tabeli `minimum`
--
ALTER TABLE `minimum`
  ADD PRIMARY KEY (`id_min`),
  ADD KEY `minimum_department__fk` (`depertment_id`);

--
-- Indeksy dla tabeli `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `department`
--
ALTER TABLE `department`
  MODIFY `id_department` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT dla tabeli `minimum`
--
ALTER TABLE `minimum`
  MODIFY `id_min` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT dla tabeli `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `minimum`
--
ALTER TABLE `minimum`
  ADD CONSTRAINT `minimum_department__fk` FOREIGN KEY (`depertment_id`) REFERENCES `department` (`id_department`);

--
-- Ograniczenia dla tabeli `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
