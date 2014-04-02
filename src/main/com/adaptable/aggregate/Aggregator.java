package com.adaptable.aggregate;

import com.adaptable.importer.reference.ReferenceImporter;
import com.adaptable.importer.trade.TradeImporter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aggregate")
public class Aggregator {
    TradeImporter tradeImporter = new TradeImporter();
    ReferenceImporter referenceImporter = new ReferenceImporter();

   public Aggregator() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TradeAndReferenceData aggregate() {
        TradeAndReferenceData tradeAndReferenceData = new TradeAndReferenceData();
        return tradeAndReferenceData;
    }


}
