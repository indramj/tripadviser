package com.first.tripadviser.service;

import com.first.tripadviser.dto.DestDTO;
import com.first.tripadviser.entity.Destination;
import com.first.tripadviser.entity.Member;

public interface DestinationService {

    public void addDest(DestDTO destDTO);


    default Destination dtoToEntity(DestDTO destDTO){
        Destination dest = Destination.builder()
                .destTitle(destDTO.getDestTitle())
                .mapX(destDTO.getMapX())
                .mapY(destDTO.getMapY())
                .date(destDTO.getDate())
                .contentId(destDTO.getContentId())
                .member(Member.builder().memberId(destDTO.getMemberId()).build())
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
                .memberId(dest.getMember().getMemberId())
                .build();
        return dto;
    }

}
