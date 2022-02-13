package org.homework.igorr.core.utils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoField.*;

public final class DateTimeUtils {
    private DateTimeUtils() {}
    //

    /**
     * Время без нс
     */
    public static final DateTimeFormatter TIME_FORMAT = new DateTimeFormatterBuilder()
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .optionalStart()
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2)
            .toFormatter();

    /**
     * ISO формат
     */
    public static final DateTimeFormatter ISO_DATE_TIME_FORMAT = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral('T')
            .append(TIME_FORMAT)
            .toFormatter();

}
