package murraco.service.Impl;

import lombok.RequiredArgsConstructor;
import murraco.dto.v1.TipDTO;
import murraco.mappers.TipMapper;
import murraco.repository.TipRepository;
import murraco.service.TipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipServiceImpl implements TipService {
    final private TipRepository tipRepository;

    @Override
    public List<TipDTO> getAll() {
        return tipRepository.findAll().stream().map(TipMapper::toDTO).collect(Collectors.toList());
    }
}
