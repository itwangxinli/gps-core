package com.derbysoft.gps.bean

import java.nio.charset.Charset

import com.alibaba.fastjson.serializer.SerializerFeature
import com.alibaba.fastjson.support.config.FastJsonConfig
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.MediaType

import scala.collection.JavaConverters._

@Configuration
class ApplicationBean {

  val logger = LoggerFactory.getLogger(classOf[ApplicationBean])

  @Bean def fastJsonHttpMessageConverter: HttpMessageConverters = {
    val fastConverter = new FastJsonHttpMessageConverter
    val fastJsonConfig = new FastJsonConfig
    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat)
    fastConverter.setFastJsonConfig(fastJsonConfig)
    fastConverter.setSupportedMediaTypes(List(MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_STREAM_JSON).asJava)
    fastConverter.setDefaultCharset(Charset.forName("UTF-8"))
    new HttpMessageConverters(fastConverter)
  }
}
