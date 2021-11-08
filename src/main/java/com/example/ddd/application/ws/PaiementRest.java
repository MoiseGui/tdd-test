package com.example.ddd.application.ws;

import com.example.ddd.application.dto.PaiementDto;
import com.example.ddd.domain.core.Result;
import com.example.ddd.domain.paiement.PaiementCreateProcess;
import com.example.ddd.domain.paiement.PaiementCreateProcessInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/paiement")
@Api("Cette classe permet de tester les process de la commande : delete et payer")
public class PaiementRest {

    @ApiOperation("paiement process : check commande & update totalPayer")
    @PostMapping("/")
    public Result save(@RequestBody PaiementDto paiementDto) {
        PaiementCreateProcessInput paiementCreateProcessInput= PaiementDto.to(paiementDto);
        return paiementCreateProcess.execute(paiementCreateProcessInput);
    }

    @Autowired
    private PaiementCreateProcess paiementCreateProcess;


}
