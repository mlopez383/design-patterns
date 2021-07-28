package com.avantica.tutorial.designpatterns.composite;

import java.util.*;

/*Composite Class*/
public class ParentTruckCompany extends TruckCompany {
    protected List<TruckCompany> subsidiaries = new ArrayList<TruckCompany>();

    public boolean addSubsidiary(TruckCompany subsidiary) {
        return subsidiaries.add(subsidiary);
    }

    public double calculateMaintenanceCost() {
        double cost = 0.0;
        for (TruckCompany subsidiary: subsidiaries) {
            cost += subsidiary.calculateMaintenanceCost();
        }

        return truckQuantity * truckMaintenanceUnitCost + cost;
    }
}
