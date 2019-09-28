package utils.Responses

import utils.HttpStatus

class HttpResponse {
    companion object {
        @JvmStatic
        fun create(httpStatus: HttpStatus, message: String): Response {
            return Response(httpStatus, message)
        }
    }
}