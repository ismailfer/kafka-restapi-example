package com.ismail.kafkaexample;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime created)
{
}
