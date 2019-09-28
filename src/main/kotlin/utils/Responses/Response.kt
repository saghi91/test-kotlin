package utils.Responses

import utils.HttpStatus

data class Response(val status: HttpStatus, val message: String) {}