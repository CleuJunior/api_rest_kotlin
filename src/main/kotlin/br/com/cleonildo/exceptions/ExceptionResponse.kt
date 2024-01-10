package br.com.cleonildo.exceptions

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


data class ExceptionResponse(
    @JsonProperty("status_code")
    val status: Int,
    @JsonProperty("status_message")
    val statusErrorMessagem: String,
    @JsonProperty("excpetion_message")
    val message: String?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:SS")
    val timestamp: LocalDateTime
)