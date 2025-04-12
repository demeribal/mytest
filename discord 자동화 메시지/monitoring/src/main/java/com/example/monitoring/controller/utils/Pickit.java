package com.example.monitoring.controller.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
 public class Pickit {
 private final RestTemplate restTemplate = new RestTemplate();
 private final String webhookUrl = "https://discord.com/api/webhooks/1360476028530856097/IN06GxyNW4a5gm3IEiyK-JDSDnu6WOlwjHVPF7UIyaWSLrdpE3hZeXw_UXA9Uqi4DYpg";
 /*
 @Scheduled(fixedRate = 10 * 1000) // 1분 간격 테스트
 public void sendDiscordMessage() {
  HttpHeaders headers = new HttpHeaders();
  headers.setContentType(MediaType.APPLICATION_JSON);

  Map<String, String> payload = new HashMap<>();
  payload.put("content", "테스트...");
  HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);
  restTemplate.postForEntity(webhookUrl, request, String.class);
 }*/

 @Scheduled(fixedRate = 60 * 1000)
 public void sendHttp() throws Exception {

     String url = "https://spc.y-sisul.or.kr/page/rent/rent.od.list.asp";
     
     String response = restTemplate.getForObject(url, String.class);
     String pattern = "<li>2부\\. 18:00~20:00\\s*<span class='status_e'>예약완료</span></li>"; // 예약가능으로 바꾸면 됨
     Pattern r = Pattern.compile(pattern);
     Matcher m = r.matcher(response);

     if (m.find()) {
         System.out.println("예약완료 found!");

         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);

         Map<String, String> payload = new HashMap<>();
         payload.put("content", "예약완료건이 감지되었습니다.");

         HttpEntity<Map<String, String>> req = new HttpEntity<>(payload, headers);

         ResponseEntity<String> res = restTemplate.postForEntity(webhookUrl, req, String.class);

     } else {

         System.out.println("예약완료 not found.");

     }
 }

}