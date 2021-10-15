package com.darlankenobi.webfluxapi.client;

import com.darlankenobi.webfluxapi.dto.IssNotification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url = "http://api.open-notify.org", name = "iss")
public interface ISSClient {

    @GetMapping(value = "/astros.json")
    IssNotification getPeapleInSpace();

}