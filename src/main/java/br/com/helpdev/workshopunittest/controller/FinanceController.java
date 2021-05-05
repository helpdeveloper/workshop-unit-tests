package br.com.helpdev.workshopunittest.controller;

import br.com.helpdev.workshopunittest.controller.dto.FinanceSimulateRequestDTO;
import br.com.helpdev.workshopunittest.controller.dto.FinanceSimulateResponseDTO;
import br.com.helpdev.workshopunittest.business.FinanceSimulateBusiness;
import br.com.helpdev.workshopunittest.controller.mapper.FinanceSimulateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceController {

  @Autowired
  private FinanceSimulateBusiness business;

  @GetMapping(consumes = "application/json", produces = "application/json")
  public FinanceSimulateResponseDTO simulate(@RequestBody final FinanceSimulateRequestDTO request) {
    final var model = FinanceSimulateMapper.toModel(request);
    final var simulated = business.simulate(model);
    return FinanceSimulateMapper.toDto(simulated);
  }

}
