package murraco.mappers;

import murraco.dto.v1.TipDTO;
import murraco.model.Tip;

public class TipMapper {
    static public TipDTO toDTO(Tip tip) {
        TipDTO tipDTO = new TipDTO();
        tipDTO.setTitle(tip.getTitle());
        tipDTO.setContent(tip.getContent());
        tipDTO.setAuthorName(tip.getAuthorName());
        tipDTO.setAuthorPosition(tip.getAuthorPosition());
        tipDTO.setAvatarUrl(tip.getAvatarUrl());
        tipDTO.setTipColor(tip.getTipColor());
        return tipDTO;
    }
}
