package nl.hu.v1wac.firstapp.persistence;

import nl.hu.v1wac.firstapp.webservices.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryPostgresDaoImpl extends PostgresBaseDao implements CountryDao {

    @Override
    public boolean save(Country country) throws SQLException {
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(
                "INSERT INTO country(code, iso3, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, latitude, longitude, capital)" +
                "VALUES (?, ?, ?, ?, ?, ?, NULL, ?, NULL, NULL, NULL, ?, ?, NULL, ?, ?, ?) ");
        preparedStatement.setString(1, country.getCode());
        preparedStatement.setString(2, country.getIso3());
        preparedStatement.setString(3, country.getName());
        preparedStatement.setString(4, country.getContinent());
        preparedStatement.setString(5, country.getRegion());
        preparedStatement.setDouble(6, country.getSurface());
        preparedStatement.setInt(7, country.getPopulation());
        preparedStatement.setString(8, country.getName());
        preparedStatement.setString(9, country.getGovernment());
        preparedStatement.setDouble(10, country.getLatitude());
        preparedStatement.setDouble(11, country.getLongitude());
        preparedStatement.setString(12, country.getCapital());
        return preparedStatement.executeUpdate() == 1;
    }

    @Override
    public List<Country> findAll() throws SQLException {
        return getList(super.getConnection().prepareStatement("SELECT * FROM country ORDER BY name ASC").executeQuery());
    }

    @Override
    public Country findByCode(String code) throws SQLException {
        PreparedStatement preparedStatement = super.getConnection().prepareStatement("SELECT * FROM country WHERE code = ?");
        preparedStatement.setString(1, code);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return toCountry(resultSet);
    }

    @Override
    public List<Country> find10LargestPopulations() throws SQLException {
        return getList(super.getConnection().prepareStatement("SELECT * FROM country ORDER BY population DESC LIMIT 10").executeQuery());
    }

    @Override
    public List<Country> find10LargestSurfaces() throws SQLException {
        return getList(super.getConnection().prepareStatement("SELECT * FROM country ORDER BY surfacearea DESC LIMIT 10").executeQuery());
    }

    @Override
    public boolean update(Country country) throws SQLException {
        PreparedStatement preparedStatement = super.getConnection().prepareStatement("UPDATE country SET code = ?, name = ?, capital = ?, continent = ?, region = ?, surfacearea = ?, population = ?, governmentform = ?, latitude = ?, longitude = ? WHERE iso3 = ?");
        preparedStatement.setString(1, country.getCode());
        preparedStatement.setString(2, country.getName());
        preparedStatement.setString(3, country.getCapital());
        preparedStatement.setString(4, country.getContinent());
        preparedStatement.setString(5, country.getRegion());
        preparedStatement.setDouble(6, country.getSurface());
        preparedStatement.setInt(7, country.getPopulation());
        preparedStatement.setString(8, country.getGovernment());
        preparedStatement.setDouble(9, country.getLatitude());
        preparedStatement.setDouble(10, country.getLongitude());
        preparedStatement.setString(11, country.getIso3());
        return preparedStatement.executeUpdate() == 1;
    }

    @Override
    public boolean delete(Country country) throws SQLException {
        PreparedStatement preparedStatement = super.getConnection().prepareStatement("DELETE FROM country WHERE iso3 = ?");
        preparedStatement.setString(1, country.getIso3());
        return preparedStatement.executeUpdate() == 1;
    }

    private List<Country> getList(ResultSet resultSet) throws SQLException {
        List<Country> countries = new ArrayList<>();
        while (resultSet.next()) {
            countries.add(toCountry(resultSet));
        }
        return countries;
    }

    private Country toCountry(ResultSet resultSet) throws SQLException {
        return new Country(resultSet.getString("CODE"), resultSet.getString("ISO3"),
                resultSet.getString("NAME"), resultSet.getString("CAPITAL"),
                resultSet.getString("CONTINENT"), resultSet.getString("REGION"),
                resultSet.getInt("SURFACEAREA"), resultSet.getInt("POPULATION"),
                resultSet.getString("GOVERNMENTFORM"), resultSet.getDouble("LATITUDE"),
                resultSet.getDouble("LONGITUDE"));
    }

}
