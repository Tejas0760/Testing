package com.link.service;

import java.util.List;
import java.util.Map;

public interface fetching {

    List<Map<String,Object>> list();

    Map<String, Object> ById(int id);
}
