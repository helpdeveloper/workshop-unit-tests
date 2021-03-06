package br.com.helpdev.workshopunittest.business.model;


public class SimulationData {

  private final String document;
  private final Long income;
  private final Long financialValue;
  private final Long parcels;

  public SimulationData(final String document, final Long income, final Long financialValue, final Long parcels) {
    this.document = document;
    this.income = income;
    this.financialValue = financialValue;
    this.parcels = parcels;
  }

  public String getDocument() {
    return document;
  }

  public Long getIncome() {
    return income;
  }

  public Long getFinancialValue() {
    return financialValue;
  }

  public Long getParcels() {
    return parcels;
  }
}
