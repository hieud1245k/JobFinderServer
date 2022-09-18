package murraco.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import murraco.dto.v1.TipDTO;
import murraco.service.TipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
@Api(tags = "tips")
@RequiredArgsConstructor
public class TipController {
    final private TipService tipService;

    @GetMapping("/")
    public ResponseEntity<List<TipDTO>> getAll() {
        return ResponseEntity.ok(tipService.getAll());
    }
}
