package io.jaconunes.walletcontrolapi.servive;

import io.jaconunes.walletcontrolapi.entities.Moeda;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Client HTTP criado via <b>OpenFeign</b> para consumo da API de Cotação de Moeda <b>AwesomeApi</b>.
 *
 * @see <a href="https://docs.awesomeapi.com.br/api-de-moedas">AwesomeApi - API de Cotações de Moedas</a>
 *
 * @author jaconunes
 */

@FeignClient(name = "AwesomeApi", url = "https://economia.awesomeapi.com.br/json")
public interface ConversorMoedaService {

    @RequestMapping(method = RequestMethod.GET, value = "/{moeda}-BRL")
    ArrayList<Moeda> consultarMoeda(@PathVariable String moeda);

}
