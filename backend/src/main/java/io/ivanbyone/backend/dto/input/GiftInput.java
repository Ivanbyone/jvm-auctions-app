package io.ivanbyone.backend.dto.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GiftInput {
    @NotNull(message = "'giftsPerRound' is required")
    @Min(value = 1, message = "Required minimal 1 gift per round")
    @Max(value = 10, message = "Required maximum 10 gifts per round")
    private Integer giftsPerRound;

    @NotNull(message = "'rounds' is required")
    @Min(value = 1, message = "Required minimal 1 round")
    @Max(value = 5, message = "Required maximum 5 rounds")
    private Integer rounds;
}
