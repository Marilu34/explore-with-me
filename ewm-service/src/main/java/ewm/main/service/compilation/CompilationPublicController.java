package ewm.main.service.compilation;

import ewm.main.service.compilation.model.dto.CompilationDto;
import ewm.main.service.compilation.model.dto.CompilationDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping(path = "/compilations")
@Slf4j
@RequiredArgsConstructor
@Validated
public class CompilationPublicController {
    private final CompilationService compilationService;

    @GetMapping("/{compilationId}")
    @ResponseStatus(HttpStatus.OK)
    public CompilationDto getCompilationById(@Positive @PathVariable long compilationId) {
        log.info("Публичная компиляция была получена: compilationId = {}", compilationId);
        return CompilationDtoMapper.toCompilationDto(compilationService.getCompilationById(compilationId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompilationDto> getAllCompilations(@RequestParam(required = false) Boolean pinned,
                                                   @PositiveOrZero @RequestParam(defaultValue = "0") int from,
                                                   @Positive @RequestParam(defaultValue = "10") int size) {
        log.info("Все публичные компиляции были получены: pinned = {}, from = {}, size = {}", pinned, from, size);
        return CompilationDtoMapper.toCompilationDtoList(compilationService.getAllCompilations(pinned, from, size));
    }


}