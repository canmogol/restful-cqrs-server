package com.fererlab.query.city.restful;

import com.fererlab.query.city.serviceengine.CityQueryServiceEngine;
import com.fererlab.query.city.serviceengine.dto.CityDTO;
import com.fererlab.query.city.serviceengine.dto.CityListDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@LocalBean
@Stateless(name = "CityQueryResource", mappedName = "CityQueryResource")
@Path("/query/city")
@Produces({"application/json"})
@Consumes({"application/json"})
public class CityQueryResource {

    @EJB(beanName = "CityQueryServiceEngineImpl")
    CityQueryServiceEngine cityServiceEngine;

    @GET
    @Path("/findById/{id}")
    public CityDTO findById(@PathParam("id") Integer id) {
        return cityServiceEngine.findById(id);
    }

    @GET
    @Path("/list/{index}/{numberOfRecords}")
    public CityListDTO list(Integer index, Integer numberOfRecords) {
        return cityServiceEngine.list(index, numberOfRecords);
    }

    @GET
    @Path("/count")
    public Long count() {
        return cityServiceEngine.count();
    }

}
