/**
 * 
 */
package com.contentdata.config;

import java.util.List;
import java.util.Map;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Eazy Bytes
 *
 */
@Configuration
@ConfigurationProperties(prefix = "content")
@RefreshScope
@Data
public class ContentServiceConfig {
	// @Value("${content.msg}")
	 private String msg;
	 private String buildVersion;
}
