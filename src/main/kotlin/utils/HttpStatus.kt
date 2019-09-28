package utils

enum class HttpStatus(val statusCode: Int) {
    //200
    Ok(200),
    Created(201),
    //400
    NotFound(404),
    Forbidden(403),
    //500
    InternalServerError(500)
}
