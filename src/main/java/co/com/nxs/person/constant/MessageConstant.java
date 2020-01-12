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

package co.com.nxs.person.constant;

/**
 * Message constants for Person rest api.
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
public class MessageConstant {
    public static final String GENERAL_ERROR_MESSAGE = "Por favor, inténtelo más tarde. ";
    public static final String PERSON_NOT_FOUND = "Persona con identificador %s no encontrada.";
    public static final String FAIL_UPDATE_BY_PERSON_NOT_FOUND = "No es posible actualizar, la persona con identificador %s no encontrada.";
    public static final String FAIL_DELETE_BY_PERSON_NOT_FOUND = "No es posible eliminar, la persona con identificador %s no encontrada.";
    public static final String OK = "OK";
    public static final String SUCCESSFUL_CREATED = "Persona registrada con éxito";
    public static final String SUCCESSFUL_UPDATED = "Persona actualizada con éxito";
    public static final String SUCCESSFUL_DELETE = "Persona eliminada con éxito";
    public static final String NAME_CANNOT_NULL = "El nombre no puede ser null";
}
