package com.dgswiphak.ida.common.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.dgswiphak.ida.common.property.AwsProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsS3Config(
    private val awsProperties: AwsProperties
) {
    @Bean
    fun amazonS3Client(): AmazonS3Client {
        val awsCredentials = BasicAWSCredentials(awsProperties.accessKey, awsProperties.secretKey)
        return AmazonS3ClientBuilder.standard()
            .withRegion(Regions.AP_NORTHEAST_2)
            .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
            .build() as AmazonS3Client
    }
}