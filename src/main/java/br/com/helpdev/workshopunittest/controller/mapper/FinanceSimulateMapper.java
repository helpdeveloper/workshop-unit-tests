package br.com.helpdev.workshopunittest.controller.mapper;

import br.com.helpdev.workshopunittest.business.model.SimulationResult;
import br.com.helpdev.workshopunittest.controller.dto.FinanceSimulateRequestDTO;
import br.com.helpdev.workshopunittest.controller.dto.FinanceSimulateResponseDTO;
import br.com.helpdev.workshopunittest.business.model.SimulationData;


public class FinanceSimulateMapper {

  public static SimulationData toModel(final FinanceSimulateRequestDTO request) {
    return new SimulationData(
        request.document,
        request.income,
        request.financialValue,
        request.parcels
    );
  }

  public static FinanceSimulateResponseDTO toDto(final SimulationResult simulated) {
    final var response = new FinanceSimulateResponseDTO();
    response.parcelValue = simulated.getParcelValue();
    return response;
  }

}
