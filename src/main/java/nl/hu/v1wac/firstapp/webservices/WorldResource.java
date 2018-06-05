package nl.hu.v1wac.firstapp.webservices;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
