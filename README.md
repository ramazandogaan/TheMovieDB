# 🎬 TheMovieDB API – Test Automation Project

![Java](https://img.shields.io/badge/Java-24-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![RestAssured](https://img.shields.io/badge/RestAssured-5.5.6-brightgreen?style=for-the-badge&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.2.5+-blue?style=for-the-badge&logo=apachemaven&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reports-FF69B4?style=for-the-badge&logo=allure&logoColor=white)

A backend **API Test Automation Framework** built with **Java, Rest-Assured, TestNG, Maven, and Allure** to validate endpoints of the  
**TheMovieDB API (TMDB)**.

---

## 📌 Overview

This framework is designed to test the core functionalities of TheMovieDB API.  
It follows a **modular**, **maintainable**, and **scalable** structure using:

- **BaseTest** class for request specifications
- **TestNG** for execution order and validations
- **Rest-Assured** for API requests
- **Allure Reporting** for detailed test reports

---

## 🚀 Key Features

- ✔️ **Reusable Request Specification** (BaseTest included)
- ✔️ **Dynamic Test Flow** — IDs extracted and passed to next tests
- ✔️ **Structured Assertions** with Hamcrest
- ✔️ **Error Handling Scenarios** (401, invalid session ID, etc.)
- ✔️ **JSON Body Testing** for POST/DELETE operations
- ✔️ **Allure Reporting Integration**
- ✔️ **Maven Surefire + TestNG XML Execution**

---

## 🧪 Test Coverage Summary

| Test Case | Description | Status |
|----------|-------------|--------|
| **TC_03** | Get Account Details | 🟢 Passed |
| **TC_04** | Add Movie to Favorites | 🟢 Passed |
| **TC_05** | Add Movie to Watchlist | 🟢 Passed |
| **TC_06** | Get Favorite Movies | 🟢 Passed |
| **TC_07** | Get Rated Movies | 🟢 Passed |
| **TC_08** | Get Watchlist Movies | 🟢 Passed |
| **TC_09** | Get Movie Genres | 🟢 Passed |
| **TC_10** | Get Now Playing Movies | 🟢 Passed |
| **TC_11** | Get Popular Movies | 🟢 Passed |
| **TC_12** | Get Top Rated Movies | 🟢 Passed |
| **TC_13** | Get Upcoming Movies | 🟢 Passed |
| **TC_14** | Search Movies | 🟢 Passed |
| **TC_15** | Get Movie Details | 🟢 Passed |
| **TC_16** | Search Keywords | 🟢 Passed |
| **TC_17** | Rate a Movie | 🟢 Passed |
| **TC_18** | Delete Rating | 🟢 Passed |
| **TC_19** | Add Item with Invalid Session (Negative Test) | 🟢 Passed |

---

## 📦 Technologies Used

- **Java 24**
- **Rest-Assured 5.5.6**
- **TestNG 7.11.0**
- **Hamcrest 3.0**
- **Jackson Databind**
- **Allure Reports**

---
## 👥 Contributors

- **Merve Çelebi**
- **Sibel Cebeci**
- **Gürhan Ataş**
- **Ramazan Doğan**
- **Ibrahim Huseynli**

---

## ▶️ How to Run Tests

### **1. Clone the project**
```bash
git clone https://github.com/your-repo/TheMovieDB.git
```
<hr>

<p style="margin-left: 20px">
  <img src="https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExNHNxMTBlcXJtMzFrazIybnc2MzNxaDF4NHo1Ymw0dTU1YWw0bndkMCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/EZr27ZbJwmjE9PGyLN/giphy.gif" alt="Project Animation" width="200">
</p>

<hr>
