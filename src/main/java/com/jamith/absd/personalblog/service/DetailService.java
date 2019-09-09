package com.jamith.absd.personalblog.service;

import com.jamith.absd.personalblog.dto.DetailDTO;
import org.springframework.stereotype.Service;

@Service
public interface DetailService {

    DetailDTO getDetails();

    boolean updateDetails(DetailDTO dto);

}
