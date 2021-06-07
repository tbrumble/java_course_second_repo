package ru.javacourse.atm.external.bank.api.Service;

import Utils.HashBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javacourse.atm.external.bank.api.Exceptions.NoEntityException;
import ru.javacourse.atm.external.bank.api.Repository.ClientRepository;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public String getAccountId(String clientId) throws NoEntityException {
        return
                clientRepository.findAll().stream().
                        filter(client -> HashBuilder.getStringHash(
                                client.getClientid().toString()).equals(clientId))
                        .findFirst().orElseThrow(
                                () -> new NoEntityException(clientId))
                        .getAccountid().toString();
    }
}
