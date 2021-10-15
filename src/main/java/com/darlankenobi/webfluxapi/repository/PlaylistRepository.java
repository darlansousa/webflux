package com.darlankenobi.webfluxapi.repository;

import com.darlankenobi.webfluxapi.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
