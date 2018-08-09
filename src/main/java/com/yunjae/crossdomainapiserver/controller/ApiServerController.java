package com.yunjae.crossdomainapiserver.controller;

import com.yunjae.crossdomainapiserver.domain.Body;
import com.yunjae.crossdomainapiserver.domain.Header;
import com.yunjae.crossdomainapiserver.domain.RequestMessage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApiServerController {
    @CrossOrigin(origins = "*")
    @PostMapping("/crossApi")
    public ResponseEntity<String> crossApi(@RequestBody RequestMessage message, HttpServletRequest req) {
        String url = message.getUrl();
        String method = message.getMethod();

        // Request Header 설정
        HttpHeaders headers = new HttpHeaders();
        if (headers != null) {
            for (Header header : message.getHeaders()) {
                headers.add(header.getKey(), header.getValue());
            }
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result = null;

        if (method.equals("GET")) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            // QueryString 값 설정
            for (Body body : message.getDatas()) {
                builder.queryParam(body.getKey(), body.getValue());
            }

            HttpEntity<?> entity = new HttpEntity<>(headers);
            // rest 호출
            result = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    String.class);
        }

        return result;
    }
}


