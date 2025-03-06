package org.example.servlettest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NaverAPIResult(List<NaverAPIResultItem> items, String lastBuildDate) {}

