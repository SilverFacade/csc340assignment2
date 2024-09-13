package com.csc340.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    /**
     * Get a random slip of advice from adviceslipAPI.
     *
     * @return a slip of advice.
     */
    @GetMapping("/advice")
    public Object getAdvice(@RequestParam(value = "id", defaultValue = "107") int id) {
        try {
            String url = "https://api.adviceslip.com/advice";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            Advice advice = new Advice(root.get("slip").get("advice").asText(), root.get("slip").get("id").asInt());

            return advice;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /advice";
        }
    }

}
