package nl.hu.v1wac.firstapp.webservices;

import nl.hu.v1wac.firstapp.persistence.CountryPostgresDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorldService {

    public List<Country> getAllCountries() throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.findAll();
    }

    public List<Country> get10LargestPopulations() throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.find10LargestPopulations();
    }

    public List<Country> get10LargestSurfaces() throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.find10LargestSurfaces();
    }

    public Country getCountryByCode(String code) throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.findByCode(code);
    }

    public boolean updateCountry(Country country) throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.update(country);
    }

    public boolean newCountry(Country country) throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.save(country);
    }

    public boolean deleteCountry(Country country) throws SQLException {
        CountryPostgresDaoImpl countryPostgresDao = new CountryPostgresDaoImpl();
        return countryPostgresDao.delete(country);
    }
}
