package com.first.tripadviser.service;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.entity.Destination;
import com.first.tripadviser.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService{

    private final DestinationRepository destRepository;

    public void addDest(DestDTO destDTO){
        Destination dest = dtoToEntity(destDTO);
        destRepository.save(dest);
    }


}
