package br.com.helpdev.workshopunittest.business.model;

public class SimulationResult {

  private final Long parcelValue;

  public SimulationResult(final Long parcelValue) {
    this.parcelValue = parcelValue;
  }

  public Long getParcelValue() {
    return parcelValue;
  }
}
