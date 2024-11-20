package br.com.projetaria.infrastructure.userserver;

import br.com.projetaria.infrastructure.userserver.output.UserOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice", url = "http://localhost:3000/users")
public interface UserClient {

    @GetMapping("/{id}")
    UserOutput getUserBy(@PathVariable final String id);

}
