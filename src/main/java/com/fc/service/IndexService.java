package com.fc.service;

import javax.servlet.http.HttpServletRequest;

public interface IndexService {
    String init(HttpServletRequest request, Integer pageNumber, Integer pageSize);
}
