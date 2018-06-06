package nl.hu.v1wac.firstapp.webservices;

import com.google.gson.Gson;

import javax.ws.rs.*;
import java.sql.SQLException;

@Path("/countries")
public class WorldResource  {
    @GET
    @Produces("application/json")
    public String getOrders() throws SQLException {
        Gson gson = new Gson();
        return gson.toJson(ServiceProvider.getWorldService().getAllCountries());
    }

    @GET
    @Path("{code}")
    @Produces("application/json")
    public String getApplicationByCode(@PathParam("code") String code) throws SQLException {
        Gson gson = new Gson();
        if (code.equals("largestsurfaces")) {
            return gson.toJson(ServiceProvider.getWorldService().get10LargestSurfaces());
        } else if (code.equals("largestpopulations")) {
            return gson.toJson(ServiceProvider.getWorldService().get10LargestPopulations());
        }
        return gson.toJson(ServiceProvider.getWorldService().getCountryByCode(code));
    }

    @PUT
    @Produces("application/json")
    public String updateCountry(String message) throws SQLException {
        Gson gson = new Gson();
        Country country = gson.fromJson(message, Country.class);
        return gson.toJson(ServiceProvider.getWorldService().updateCountry(country));
    }

    @POST
    @Produces("application/json")
    public String newCountry(String message) throws SQLException {
        Gson gson = new Gson();
        Country country = gson.fromJson(message, Country.class);
        return gson.toJson(ServiceProvider.getWorldService().newCountry(country));
    }

    @DELETE
    @Produces("application/json")
    public String deleteCountry(String message) throws SQLException {
        Gson gson = new Gson();
        Country country = gson.fromJson(message, Country.class);
        return gson.toJson(ServiceProvider.getWorldService().deleteCountry(country));
    }
}
