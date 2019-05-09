package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/link")
    Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest requestLink, HttpServletRequest request) {
        return linkService.shortenLink(requestLink.getLink(), request.getRequestURL().toString())
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
