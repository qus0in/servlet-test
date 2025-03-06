package org.example.servlettest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NaverAPIResultItem(String title, String link, String description, String pubDate) {
}
