package com.avantica.tutorial.designpatterns.composite;

/*Leaf Class*/
public class TruckCompanyWithoutSubsidiaries extends TruckCompany {
    public boolean addSubsidiary(TruckCompany subsidiary) {
        return false;
    }

    public double calculateMaintenanceCost() {
        return truckQuantity * truckMaintenanceUnitCost;
    }
}
