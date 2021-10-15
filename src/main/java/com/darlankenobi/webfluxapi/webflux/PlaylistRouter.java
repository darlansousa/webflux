package com.darlankenobi.webfluxapi.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class PlaylistRouter {

    //@Bean
    public RouterFunction<ServerResponse> route(PlaylistHanddler handdler){
        return RouterFunctions
                .route(GET("/playlists").and(accept(MediaType.APPLICATION_JSON)), handdler::findAll)
                .andRoute(GET("/playlists/{id}").and(accept(MediaType.APPLICATION_JSON)), handdler::findById)
                .andRoute(POST("/playlists").and(accept(MediaType.APPLICATION_JSON)), handdler::save);

    }
}
