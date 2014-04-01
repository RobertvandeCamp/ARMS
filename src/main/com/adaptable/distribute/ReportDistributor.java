package com.adaptable.distribute;

import com.adaptable.riskmanagement.RiskReport;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("report")
public class ReportDistributor {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String report() {
        RiskReport report = new RiskReport();
        try {
            return JSON_MAPPER.writeValueAsString(report);
        } catch (IOException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
