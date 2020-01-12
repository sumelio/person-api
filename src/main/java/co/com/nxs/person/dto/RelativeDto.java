/*
 *
 *  *   Copyright 2020, Nexos Software S.A.S
 *  *   https://nxs.com.co/
 *  *
 *  *   All rights reserved
 *  *   Date: 12/02/2020
 *
 *
 */

package co.com.nxs.person.dto;

import co.com.nxs.person.enums.RelativeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Relative data transfer object.
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelativeDto {
    private RelativeType relativeType;
    private PersonDto person;
}
