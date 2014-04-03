package com.adaptable.aggregate;

import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("aggregate")
public class Aggregator {

    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String aggregate() {
        AggregatedData data = new AggregatedData();
        try {
            return OBJECTMAPPER.writeValueAsString(data);
        } catch (IOException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    private class AggregatedData {
        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        private String data = "This is the data";
    }
}
