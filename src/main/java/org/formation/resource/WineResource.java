package org.formation.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.formation.dto.WineDTO;
import org.formation.service.WineService;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;

@Path("/wines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WineResource {

    private final WineService wineService;

    public WineResource(WineService wineService) {
        this.wineService = wineService;
    }

    @GET
    public List<WineDTO> getAllWines() {
        return this.wineService.getAllWines();
    }

    @GET
    @Path("/{id}")
    public WineDTO getWine(@PathParam("id") Long id) {
        return this.wineService.getWine(id);
    }

    @POST
    @ResponseStatus(201)
    public WineDTO createWine(WineDTO wine) {
        return this.wineService.createWine(wine);
    }

    @PUT
    @Path("/{id}")
    public WineDTO updateWine(@PathParam("id") Long id, WineDTO wine) {
        return this.wineService.updateWine(id, wine);
    }

    @DELETE
    @Path("/{id}")
    public void deleteWine(@PathParam("id") Long id) {
        this.wineService.deleteWine(id);
    }
}
