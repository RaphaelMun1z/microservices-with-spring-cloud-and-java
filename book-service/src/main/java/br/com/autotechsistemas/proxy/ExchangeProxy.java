package br.com.autotechsistemas.proxy;

import br.com.autotechsistemas.dto.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange-service")
public interface ExchangeProxy {
    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    public Exchange getExchange(
            @PathVariable Double amount,
            @PathVariable String from,
            @PathVariable String to);
}
