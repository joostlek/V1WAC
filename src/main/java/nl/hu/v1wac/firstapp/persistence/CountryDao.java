package nl.hu.v1wac.firstapp.persistence;

import nl.hu.v1wac.firstapp.webservices.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDao {
    boolean save(Country country) throws SQLException;
    List<Country> findAll() throws SQLException;
    Country findByCode(String code) throws SQLException;
    List<Country> find10LargestPopulations() throws SQLException;
    List<Country> find10LargestSurfaces() throws SQLException;
    boolean update(Country country) throws SQLException;
    boolean delete(Country country) throws SQLException;
}
