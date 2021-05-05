package br.com.helpdev.workshopunittest.business.model;

public class SimulationResult {

  private final float parcelValue;

  public SimulationResult(final float parcelValue) {
    this.parcelValue = parcelValue;
  }

  public float getParcelValue() {
    return parcelValue;
  }
}
