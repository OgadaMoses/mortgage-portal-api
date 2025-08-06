package com.mortgage.portal_api.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

 private final String jwtSecret = "ChangeThisToASecretKeyWithAtLeast32Chars!";
 private final long jwtExpirationMs = 3600000; // Expire after 1 hour: mogada 06082025

 private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

 public String generateToken(String username, String role) {
     return Jwts.builder()
             .setSubject(username)
             .claim("role", role)
             .setIssuedAt(new Date())
             .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
             .signWith(key, SignatureAlgorithm.HS256)
             .compact();
 }

 public String getUsernameFromToken(String token) {
     return Jwts.parserBuilder()
             .setSigningKey(key)
             .build()
             .parseClaimsJws(token)
             .getBody()
             .getSubject();
 }

 public String getRoleFromToken(String token) {
     return (String) Jwts.parserBuilder()
             .setSigningKey(key)
             .build()
             .parseClaimsJws(token)
             .getBody()
             .get("role");
 }

 public boolean validateToken(String token) {
     try {
         Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
         return true;
     } catch (JwtException e) {
         return false;
     }
 }
}
