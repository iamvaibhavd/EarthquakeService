package com.earthquakeInfo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.earthquakeInfo.service.EarthquakeInfoService;

@Path("/EQServiceInfo")
public class EQServiceController {
	@GET
	@Path("/param")
	public Response getEarthquakeInfo(@QueryParam("starttime") String starttime, 
									  @QueryParam("endtime") String endtime)
	{
		
	return Response.status(Status.OK).entity(new EarthquakeInfoService().getEarthquakeInfo(starttime, endtime)).build();
		
	}

}
