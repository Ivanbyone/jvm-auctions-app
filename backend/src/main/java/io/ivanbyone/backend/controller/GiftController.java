package io.ivanbyone.backend.controller;

import io.ivanbyone.backend.dto.output.GiftOutput;
import io.ivanbyone.backend.dto.output.ResponseContract;
import io.ivanbyone.backend.service.GiftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Gift")
@RequestMapping("/gift")
@SuppressWarnings("unused")
public class GiftController {

    private final GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Show all gifts sorted by supply")
    @ApiResponse(responseCode = "200", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    public ResponseContract<List<GiftOutput>> findGifts(
            @RequestParam(name = "sort", defaultValue = "desc") String sort
    ) {
        List<GiftOutput> output = giftService.findGifts(sort);
        return ResponseContract.<List<GiftOutput>>builder()
                .message(output)
                .status(HttpStatus.OK.value())
                .build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Show gift by ID")
    @ApiResponse(responseCode = "200", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    @ApiResponse(responseCode = "404", content = @Content(
            schema = @Schema(implementation = ResponseContract.class)
    ))
    public ResponseContract<GiftOutput> findGiftById(@PathVariable("id") String id) {
        GiftOutput output = giftService.findGiftById(id);
        return ResponseContract.<GiftOutput>builder()
                .message(output)
                .status(HttpStatus.OK.value())
                .build();
    }
}
