package com.first.tripadviser.service;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.entity.Destination;
import com.first.tripadviser.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService{

    private final DestinationRepository destRepository;

    public void addDest(DestDTO destDTO){
        Destination dest = dtoToEntity(destDTO);
        destRepository.save(dest);

    }

    public void addDestList(List<DestDTO> dtoList){
        for (DestDTO destDTO : dtoList) {
            addDest(destDTO);
        }
    }

    public List<DestDTO> readDestList(String memberId){
        List<Destination> entityList = destRepository.findAllByMember_MemberId(memberId);
        List<DestDTO> dtoList = new ArrayList<>();
        for (Destination destination : entityList) {
            DestDTO dto = entityToDTO(destination);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
