package com.concorde.infrastructure.dto.response

data class BaseResponse<T>(
    val success: Boolean,
    val message: String? = null,
    val result: T? = null,
    val error: ErrorResponse? = null
) {
    companion object {
        fun <T> success(result: T, message: String? = null): BaseResponse<T> {
            return BaseResponse(
                success = true,
                message = message,
                result = result
            )
        }

        fun <T> error(message: String, error: ErrorResponse? = null): BaseResponse<T> {
            return BaseResponse(
                success = false,
                message = message,
                error = error
            )
        }
    }
}