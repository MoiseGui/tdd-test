package com.example.ddd.application.ws;

import com.example.ddd.application.dto.CommandeDto;
import com.example.ddd.domain.commande.delete.CommandeDeleteInput;
import com.example.ddd.domain.commande.delete.CommandeDeleteProcess;
import com.example.ddd.domain.commande.paiement.CommandePaiementInput;
import com.example.ddd.domain.commande.paiement.CommandePaiementProcess;
import com.example.ddd.domain.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commande")
@Api("Cette classe permet de tester les process de la commande : delete et payer")
public class CommandeRest {

    @ApiOperation("paiement process : check commande & update totalPayer")
    @PutMapping("/")
    public Result payer(@RequestBody CommandeDto commandeDto) {
        CommandePaiementInput commandePaiementInput = CommandeDto.toCommandePaiementInput(commandeDto);
        return commandePaiementProcess.execute(commandePaiementInput);
    }
    @ApiOperation("delete process : check commande & check totalPayer confrome")
    @DeleteMapping("/")
    public Result delete(@RequestBody CommandeDto commandeDto) {
        CommandeDeleteInput commandeDeleteInput = CommandeDto.toCommandeDeleteInput(commandeDto);
        return commandeDeleteProcess.execute(commandeDeleteInput);
    }

    @Autowired
    private CommandePaiementProcess commandePaiementProcess;
    @Autowired
    private CommandeDeleteProcess commandeDeleteProcess;

}
