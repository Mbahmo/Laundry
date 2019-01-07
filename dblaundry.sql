-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2018 at 12:53 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblaundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbbarang`
--

CREATE TABLE `tbbarang` (
  `IdBarang` int(11) NOT NULL,
  `NamaBarang` varchar(200) NOT NULL,
  `JenisBarang` varchar(200) NOT NULL,
  `Satuan` varchar(50) NOT NULL,
  `Harga` double(12,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbbarang`
--

INSERT INTO `tbbarang` (`IdBarang`, `NamaBarang`, `JenisBarang`, `Satuan`, `Harga`) VALUES
(1, 'Kaos', 'Baju', 'Pcs', 3000),
(2, 'Celana', 'Celana', 'Pcs', 2500),
(3, 'asd', 'Baju', 'Kg', 123),
(4, 'Celana Kiloan', 'Baju', 'Kg', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `tbpelanggan`
--

CREATE TABLE `tbpelanggan` (
  `IdPelanggan` int(11) NOT NULL,
  `NamaPelanggan` varchar(200) NOT NULL,
  `Alamat` varchar(200) NOT NULL,
  `NoTelp` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpelanggan`
--

INSERT INTO `tbpelanggan` (`IdPelanggan`, `NamaPelanggan`, `Alamat`, `NoTelp`) VALUES
(1, 'Joko', 'Denpasar', '08123853463'),
(2, 'Anthony', 'Magelang', '08123256456546');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenerimaan`
--

CREATE TABLE `tbpenerimaan` (
  `NoTransaksi` int(11) NOT NULL,
  `TglMasuk` date NOT NULL,
  `TglSelesai` date NOT NULL,
  `Keterangan` varchar(200) NOT NULL,
  `IdPelanggan` int(11) NOT NULL,
  `IdUser` int(11) NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenerimaan`
--

INSERT INTO `tbpenerimaan` (`NoTransaksi`, `TglMasuk`, `TglSelesai`, `Keterangan`, `IdPelanggan`, `IdUser`, `IdBarang`, `Jumlah`) VALUES
(7, '2018-12-21', '2018-12-22', 'Sudah Diambil', 2, 1, 3, 2),
(8, '2018-12-21', '2018-12-22', 'Sudah Diambil', 1, 1, 1, 1),
(9, '2018-12-21', '2018-12-22', 'Belum Diambil', 2, 1, 1, 2),
(10, '2018-12-22', '2018-12-23', 'Belum Diambil', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbpengambilan`
--

CREATE TABLE `tbpengambilan` (
  `NoPengambilan` int(11) NOT NULL,
  `NoTransaksi` int(11) NOT NULL,
  `TglAmbil` date NOT NULL,
  `TotalBayar` double(12,0) NOT NULL,
  `IdUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpengambilan`
--

INSERT INTO `tbpengambilan` (`NoPengambilan`, `NoTransaksi`, `TglAmbil`, `TotalBayar`, `IdUser`) VALUES
(3, 7, '2018-12-21', 250, 1),
(4, 8, '2018-12-22', 5000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `IdUser` int(11) NOT NULL,
  `Username` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`IdUser`, `Username`, `Password`, `Level`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'user', 'user', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbarang`
--
ALTER TABLE `tbbarang`
  ADD PRIMARY KEY (`IdBarang`);

--
-- Indexes for table `tbpelanggan`
--
ALTER TABLE `tbpelanggan`
  ADD PRIMARY KEY (`IdPelanggan`);

--
-- Indexes for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  ADD PRIMARY KEY (`NoTransaksi`);

--
-- Indexes for table `tbpengambilan`
--
ALTER TABLE `tbpengambilan`
  ADD PRIMARY KEY (`NoPengambilan`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbbarang`
--
ALTER TABLE `tbbarang`
  MODIFY `IdBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbpelanggan`
--
ALTER TABLE `tbpelanggan`
  MODIFY `IdPelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  MODIFY `NoTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbpengambilan`
--
ALTER TABLE `tbpengambilan`
  MODIFY `NoPengambilan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
