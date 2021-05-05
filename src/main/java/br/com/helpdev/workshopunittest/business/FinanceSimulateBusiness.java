package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.service.SerasaService;
import br.com.helpdev.workshopunittest.business.model.SimulationData;
import br.com.helpdev.workshopunittest.business.model.SimulationResult;
import br.com.helpdev.workshopunittest.utils.DocumentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceSimulateBusiness {

  @Autowired
  private SerasaService serasaService;


  public SimulationResult simulate(final SimulationData simulationData) {

    final var debits = serasaService.getDebits(simulationData.getDocument());
    if (debits.isEmpty()) {
      throw new SecurityException("Your document has debits!");
    }

    if (DocumentUtils.isCpf(simulationData.getDocument())) {

      if ((simulationData.getFinancialValue() / simulationData.getIncome()) > 100) {
        throw new IllegalArgumentException("You can't finance this value for person");
      }

    } else if (DocumentUtils.isCnpj(simulationData.getDocument())) {

      if ((simulationData.getFinancialValue() / simulationData.getIncome()) > 20) {
        throw new IllegalArgumentException("You can't finance this value for company");
      }

    }

    return calculateParcel(simulationData);
  }

  private SimulationResult calculateParcel(final SimulationData simulationData) {
    var parcelValue = simulationData.getFinancialValue() / simulationData.getParcels();
    parcelValue *= 0.1;
    return new SimulationResult(parcelValue);
  }
}
