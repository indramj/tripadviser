package com.first.tripadviser.service;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.entity.Destination;
import com.first.tripadviser.entity.Member;
import com.first.tripadviser.entity.Plan;

import java.time.LocalDate;
import java.util.List;

public interface DestinationService {

    public void addDest(DestDTO destDTO);

    public void addDestList(List<DestDTO> dtoList);

    //public List<DestDTO> getDestList(String memberId);
    public List<DestDTO> getDestinationsByPlanNo(Long planNo);

    public List<DestDTO> getDestByPnoAndDate(Long planNo , LocalDate date);

    public void deleteDest(Long destId);


    default Destination dtoToEntity(DestDTO destDTO){
        Destination dest = Destination.builder()
                .destTitle(destDTO.getDestTitle())
                .mapX(destDTO.getMapX())
                .mapY(destDTO.getMapY())
                .date(destDTO.getDate())
                .contentId(destDTO.getContentId())
                .plan(Plan.builder().planNo(destDTO.getPlanNo()).build())
                .build();
        return dest;
    }

    default DestDTO entityToDTO(Destination dest){
        DestDTO dto = DestDTO.builder()
                .destId(dest.getDestId())
                .contentId(dest.getContentId())
                .destTitle(dest.getDestTitle())
                .mapX(dest.getMapX())
                .mapY(dest.getMapY())
                .date(dest.getDate())
                .planNo(dest.getPlan().getPlanNo())
                .build();
        return dto;
    }

}
