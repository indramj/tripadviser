package com.first.tripadviser.service;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.entity.Destination;
import com.first.tripadviser.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destRepository;

    public void addDest(DestDTO destDTO) {
        Destination dest = dtoToEntity(destDTO);
        destRepository.save(dest);

    }

    public List<DestDTO> getDestByPnoAndDate(Long planNo , LocalDate date){
        List<Destination> entityList = destRepository.findAllByPlan_PlanNoAndDate(planNo , date);
        List<DestDTO> dtoList = new ArrayList<>();
        for (Destination dest : entityList){
            DestDTO dto = DestDTO.builder()
                    .destId(dest.getDestId())
                    .planNo(dest.getPlan().getPlanNo())
                    .date(dest.getDate())
                    .mapX(dest.getMapX())
                    .mapY(dest.getMapY())
                    .contentId(dest.getContentId())
                    .destTitle(dest.getDestTitle())
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<DestDTO> getDestinationsByPlanNo(Long planNo){
        List<Destination> entityList = destRepository.findAllByPlan_PlanNo(planNo);
        List<DestDTO> dtoList = new ArrayList<>();
        for (Destination dest : entityList){
            DestDTO dto = DestDTO.builder()
                    .destId(dest.getDestId())
                    .planNo(dest.getPlan().getPlanNo())
                    .date(dest.getDate())
                    .mapX(dest.getMapX())
                    .mapY(dest.getMapY())
                    .contentId(dest.getContentId())
                    .destTitle(dest.getDestTitle())
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }
//    public List<DestDTO> getDestList(String memberId){
//        List<Destination> entityList = destRepository.findAllByMember_MemberId(memberId);
//        List<DestDTO> dtoList = new ArrayList<DestDTO>();
//        for (Destination destination : entityList){
//            DestDTO dto = entityToDTO(destination);
//            dtoList.add(dto);
//        }
//        return dtoList;
//    }

    public void addDestList(List<DestDTO> dtoList) {
        for (DestDTO destDTO : dtoList) {
            addDest(destDTO);
        }
    }

    public void deleteDest(Long destId) {
        destRepository.deleteById(destId);
    }
}

