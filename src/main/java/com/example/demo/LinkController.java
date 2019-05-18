package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/link")
    Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest requestLink) {
        return linkService.shortenLink(requestLink.getLink())
                .map(CreateLinkResponse::new);
    }

    @GetMapping("/link/{key}")
    Mono<ResponseEntity<Object>> getLink(@PathVariable String key) {
        return linkService.getOriginalLink(key)
                          .map(link -> ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                                                     .header("Location", link.getOriginalLink())
                                                     .build())
                          .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Value
    public static class CreateLinkRequest {

        private String link;
    }

    @Value
    public static class CreateLinkResponse {

        private String shortenedLink;
    }
}
