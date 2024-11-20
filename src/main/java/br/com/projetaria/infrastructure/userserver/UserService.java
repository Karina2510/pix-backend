package br.com.projetaria.infrastructure.userserver;

import br.com.projetaria.domain.user.User;
import br.com.projetaria.domain.user.service.IUserService;
import br.com.projetaria.infrastructure.userserver.output.UserOutput;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public User getUserBy(final String id) {
        if (id == null) {
            throw new RuntimeException("The id of user is required");
        }

        final UserOutput userFounded = this.userClient.getUserBy(id);

        final User user = new User(userFounded.id(), userFounded.name(), userFounded.createdAt());

        return user;
    }
}
