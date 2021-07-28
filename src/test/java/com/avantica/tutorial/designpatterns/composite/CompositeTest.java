package com.avantica.tutorial.designpatterns.composite;

import org.junit.Assert;
import org.junit.Test;

public class CompositeTest {
    static final String COMPONENT_CLASS_NAME_EXPECTED = "TruckCompany";
    static final String COMPOSITE_CLASS_NAME_EXPECTED = "ParentTruckCompany";
    static final String LEAF_CLASS_NAME_EXPECTED = "TruckCompanyWithoutSubsidiaries";
    static final double TOTAL_MAINTENANCE_COST_EXPECTED_COMPANY_WITH_SUBSIDIARIES = 500;

    private void addTrucksToCompany (TruckCompany truckCompany, int truckQuantity){
        for (int i = 0; i < truckQuantity; i++) {
            truckCompany.addTruck();
        }
    }

    private void addSubsidiariesToParentTruckCompany(TruckCompany parentTruckCompany, TruckCompany...truckCompanies){
        for (TruckCompany truckCompany : truckCompanies){
            parentTruckCompany.addSubsidiary(truckCompany);
        }
    }

    private void assertClassesCreation(TruckCompany truckCompany, String childClassNameExpected){
        Assert.assertEquals("Failure - expected component class name does not match", COMPONENT_CLASS_NAME_EXPECTED, truckCompany.getClass().getSuperclass().getSimpleName());
        Assert.assertEquals("Failure - expected child class name does not match", childClassNameExpected, truckCompany.getClass().getSimpleName());
    }

    /*Creation of component and leaf classes*/
    @Test
    public void validateCreationTruckCompanyWithoutSubsidiaries(){
        TruckCompany truckCompany = new TruckCompanyWithoutSubsidiaries();
        assertClassesCreation(truckCompany, LEAF_CLASS_NAME_EXPECTED);
    }

    /*Creation of component and composite classes*/
    @Test
    public void validateCreationParentTruckCompany(){
        TruckCompany groupTruckCompany = new ParentTruckCompany();
        assertClassesCreation(groupTruckCompany, COMPOSITE_CLASS_NAME_EXPECTED);
    }

    @Test
    public void calculateMaintenanceCostOfCompanyWithSubsidiaries() {
        TruckCompany truckCompany1 = new TruckCompanyWithoutSubsidiaries();
        addTrucksToCompany(truckCompany1, 1);
        TruckCompany truckCompany2 = new TruckCompanyWithoutSubsidiaries();
        addTrucksToCompany(truckCompany2, 3);
        TruckCompany parentTruckCompany = new ParentTruckCompany();
        addTrucksToCompany(parentTruckCompany, 1);
        addSubsidiariesToParentTruckCompany(parentTruckCompany, truckCompany1, truckCompany2);
        Assert.assertTrue("Failure - expected total maintenance cost does not match", TOTAL_MAINTENANCE_COST_EXPECTED_COMPANY_WITH_SUBSIDIARIES == parentTruckCompany.calculateMaintenanceCost());
    }

    @Test
    public void calculateMaintenanceCostOfCompanyWithoutSubsidiariesOrTrucks() {
        TruckCompany truckCompany = new TruckCompanyWithoutSubsidiaries();
        Assert.assertTrue("Failure - expected total maintenance cost does not match", 0 == truckCompany.calculateMaintenanceCost());
    }

    @Test
    public void calculateMaintenanceCostOfParentTruckCompanyWithoutTrucks() {
        TruckCompany truckCompany = new ParentTruckCompany();
        Assert.assertTrue("Failure - expected total maintenance cost does not match", 0 == truckCompany.calculateMaintenanceCost());
    }
}
