package br.com.projetaria.infrastructure.controllers;

import br.com.projetaria.application.usecase.TransactByAccountsUseCase;
import br.com.projetaria.application.usecase.input.TransactionCommandInput;
import br.com.projetaria.application.usecase.output.TransactionCommandOutput;
import br.com.projetaria.infrastructure.controllers.input.TransactInput;
import br.com.projetaria.infrastructure.controllers.output.TransacionarOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixController {

    private final TransactByAccountsUseCase useCase;

    public PixController(TransactByAccountsUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/transact")
    public TransacionarOutput transact(@RequestBody TransactInput input) {

        TransactionCommandInput commandInput = new TransactionCommandInput(
                input.requesterUserId(),
                input.receiverUserId(),
                input.amount());

        final TransactionCommandOutput commandOutput = useCase.execute(commandInput);

        return new TransacionarOutput(
                commandOutput.transactionId(),
                commandOutput.transactionAt());
    }
}
