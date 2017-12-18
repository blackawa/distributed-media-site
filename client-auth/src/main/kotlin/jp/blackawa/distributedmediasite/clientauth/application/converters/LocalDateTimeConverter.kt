package jp.blackawa.distributedmediasite.clientauth.application.converters

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class LocalDateTimeConverter : AttributeConverter<LocalDateTime, Timestamp> {

    override fun convertToDatabaseColumn(
        localDateTime: LocalDateTime?
    ): Timestamp? = if (localDateTime == null) null else Timestamp.valueOf(localDateTime)

    override fun convertToEntityAttribute(
        timestamp: Timestamp?
    ): LocalDateTime? = timestamp?.toLocalDateTime()
}