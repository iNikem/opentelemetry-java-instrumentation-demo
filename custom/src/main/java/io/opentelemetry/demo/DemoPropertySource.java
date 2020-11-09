package io.opentelemetry.demo;

import io.opentelemetry.javaagent.spi.config.PropertySource;
import java.util.Map;

/**
 * {@link PropertySource} is an SPI provided by OpenTelemetry Java instrumentation agent.
 * By implementing it custom distributions can supply their own default configuration.
 * The configuration priority, from highest to lowest is:
 * system properties -> environment variables -> configuration file -> PropertySource SPI -> hard-coded defaults
 */
public class DemoPropertySource implements PropertySource {

  @Override
  public Map<String, String> getProperties() {
    return Map.of(
        "otel.exporter.otlp.endpoint", "collector:55680",
        "otel.config.max.attrs", "16"
    );
  }
}
