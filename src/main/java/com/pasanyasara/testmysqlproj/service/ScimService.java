package com.pasanyasara.testmysqlproj.service;

import com.pasanyasara.testmysqlproj.model.Association;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ScimService {
    ResponseEntity<Object> updateAssociation(Association association) throws IOException;
}
