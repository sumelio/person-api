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

package co.com.nxs.person.entities;

import co.com.nxs.person.enums.RelativeType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Relative entity.
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "relative")
public class Relative {
    private RelativeType relativeType;
    private Person person;
}
