package org.homework.igorr.core.config;

import org.homework.igorr.core.CoreScanMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CoreScanMarker.class)
public class CoreConfig {
}
