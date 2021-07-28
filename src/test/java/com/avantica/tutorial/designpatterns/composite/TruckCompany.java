package com.avantica.tutorial.designpatterns.composite;

/*Component Class*/
public abstract class TruckCompany {
    protected static double truckMaintenanceUnitCost = 100.0;
    protected int truckQuantity;

    public TruckCompany(){
        truckQuantity = 0;
    }

    public void addTruck() {
        truckQuantity++;
    }

    public abstract boolean addSubsidiary(TruckCompany subsidiary);

    public abstract double calculateMaintenanceCost();
}
