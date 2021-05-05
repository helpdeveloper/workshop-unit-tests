package br.com.helpdev.workshopunittest.business;

import br.com.helpdev.workshopunittest.service.SerasaService;
import br.com.helpdev.workshopunittest.business.model.SimulationData;
import br.com.helpdev.workshopunittest.business.model.SimulationResult;
import br.com.helpdev.workshopunittest.utils.DocumentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FinanceSimulateBusiness {

  @Autowired
  private SerasaService serasaService;

  @Value("${finance.person.calc.value}")
  private Long personCalcValue;

  @Value("${finance.company.calc.value}")
  private Long companyCalcValue;

  public SimulationResult simulate(final SimulationData simulationData) {

    final var debits = serasaService.getDebits(simulationData.getDocument());
    if (!debits.isEmpty()) {
      throw new SecurityException("Your document has debits!");
    }

    if (DocumentUtils.isCpf(simulationData.getDocument())) {

      if ((simulationData.getFinancialValue() / simulationData.getIncome()) > personCalcValue) {
        throw new IllegalArgumentException("You can't finance this value for person");
      }

    } else if (DocumentUtils.isCnpj(simulationData.getDocument())) {

      if ((simulationData.getFinancialValue() / simulationData.getIncome()) > companyCalcValue) {
        throw new IllegalArgumentException("You can't finance this value for company");
      }

    }

    return calculateParcel(simulationData);
  }

  private SimulationResult calculateParcel(final SimulationData simulationData) {
    long parcelValue = simulationData.getFinancialValue() / simulationData.getParcels();
    parcelValue += parcelValue * 0.1f;
    return new SimulationResult(parcelValue);
  }

  public Long getPersonCalcValue() {
    return personCalcValue;
  }

  public Long getCompanyCalcValue() {
    return companyCalcValue;
  }
}
