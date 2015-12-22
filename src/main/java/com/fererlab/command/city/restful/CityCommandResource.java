package com.fererlab.command.city.restful;

import com.fererlab.command.city.serviceengine.CityCommandServiceEngine;
import com.fererlab.command.city.serviceengine.dto.CityCommandDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@LocalBean
@Stateless(name = "CityCommandResource", mappedName = "CityCommandResource")
@Path("/command/city")
@Produces({"application/json"})
@Consumes({"application/json"})
public class CityCommandResource {

    @EJB(beanName = "CityCommandServiceEngineImpl")
    private CityCommandServiceEngine cityServiceEngine;

    @POST
    public void create(CityCommandDTO cityCommandDTO) {
        cityServiceEngine.create(cityCommandDTO);
    }

    @PUT
    public void update(CityCommandDTO cityCommandDTO) {
        cityServiceEngine.update(cityCommandDTO);
    }

    @DELETE
    public void delete(CityCommandDTO cityCommandDTO) {
        cityServiceEngine.delete(cityCommandDTO);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        cityServiceEngine.delete(id);
    }
}
