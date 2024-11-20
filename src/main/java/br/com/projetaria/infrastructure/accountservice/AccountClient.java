package br.com.projetaria.infrastructure.accountservice;

import br.com.projetaria.infrastructure.accountservice.output.AccountOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "accountservice", url = "http://localhost:3000/accounts")
public interface AccountClient {

    @GetMapping()
    List<AccountOutput> getAccountBy(@RequestParam final String userId);

//    @PutMapping
//    void updateAccount(@RequestBody);sddsfdfdsfds

}
