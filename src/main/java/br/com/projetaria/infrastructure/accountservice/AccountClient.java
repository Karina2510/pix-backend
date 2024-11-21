package br.com.projetaria.infrastructure.accountservice;

import br.com.projetaria.domain.account.Account;
import br.com.projetaria.infrastructure.accountservice.input.AccountInput;
import br.com.projetaria.infrastructure.accountservice.output.AccountOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "accountservice", url = "http://localhost:3000/accounts")
public interface AccountClient {

    @GetMapping()
    List<AccountOutput> getAccountBy(@RequestParam final String userId);

    @PutMapping("/{id}")
    void updateAccount(@PathVariable String id, @RequestBody AccountInput input);

    //    @PutMapping
//    void updateAccount(@RequestBody);sddsfdfdsfds

}
