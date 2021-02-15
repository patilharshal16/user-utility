package com.ebi.utility.dto;

import com.ebi.utility.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author Harshal Patil
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class InputDTO {
    @JsonProperty("person")
    List<UserDTO> data;
}
