package com.darlankenobi.webfluxapi.service;

import com.darlankenobi.webfluxapi.document.Playlist;
import com.darlankenobi.webfluxapi.dto.IssNotification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> findAll();
    Mono<Playlist> findById(String id);
    Mono<Playlist> save(Playlist playlist);
    Flux<IssNotification> findNotifications() throws InterruptedException;
}
