package com.adaptable.aggregate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class TradeAndReferenceData {

    @XmlElement
    private List<Counterparty> counterparties = new ArrayList<>();


    public List<Counterparty> getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(List<Counterparty> counterparties) {
        this.counterparties = counterparties;
    }

    private class Counterparty {
        private List<Trade> trades = new ArrayList<>();
        private ReferenceData referenceData;
    }

    private class Trade {
        private String id;
        private Date data;
        private String value;
    }

    private class ReferenceData {
    }
}
