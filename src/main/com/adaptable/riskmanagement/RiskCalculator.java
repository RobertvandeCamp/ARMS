package com.adaptable.riskmanagement;

import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Path("calculate")
public class RiskCalculator {

    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String calculateRisk() {
        String aggregatedData = getAggregatedData();

        Map<String, String> result;
        try {
            result = OBJECTMAPPER.readValue(
                    aggregatedData, OBJECTMAPPER.getTypeFactory().constructMapType(HashMap.class, String.class, String.class));
        } catch (IOException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

        for (String key : result.keySet()) {
            System.out.println(String.format("Got key [%s] and value [%s].", key, result.get(key)));
        }

        Calculation calculation = new Calculation();
        calculation.setData(aggregatedData);
        try {
            return OBJECTMAPPER.writeValueAsString(calculation);
        } catch (IOException e) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    private String getAggregatedData() {
        String responseEntity = ClientBuilder.newClient().target("http://localhost:8080/arms").path("aggregate")
                .request().get(String.class);
        return responseEntity;
    }

    private class Calculation {
        private String id = UUID.randomUUID().toString();
        private double amount = 1.0;
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
