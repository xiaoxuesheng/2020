//package com.hjj.toy.util.文件存储.s3;
//
//import com.amazonaws.ClientConfiguration;
//import com.amazonaws.Protocol;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.client.builder.AwsClientBuilder;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.*;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//public class S3ClientService implements InitializingBean {
//
//    @Value("${s3.connect.access}")
//    private String access;
//
//    @Value("${s3.connect.secret}")
//    private String secret;
//
//    @Value("${s3.connect.bucket}")
//    private String bucket;
//
//    @Value("${s3.connect.endPoint}")
//    private String endPoint;
//
//    private AmazonS3 amazonS3Client;
//
//
//    public PutObjectResult uploadFileToS3(File file) throws Exception {
//        PutObjectResult putObjectResult = amazonS3Client.putObject(bucket, file.getName(), file);
//        return putObjectResult;
//    }
//
//    public PutObjectResult uploadFileToS3(String key, InputStream inputStream) throws Exception{
//
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        PutObjectResult putObjectResult = amazonS3Client.putObject(bucket, key, inputStream, objectMetadata);
//        return putObjectResult;
//    }
//
//
//
//    public InputStream downloadFileFromS3(String key) throws Exception{
//
//        GeneratePresignedUrlRequest httpRequest=new GeneratePresignedUrlRequest(bucket, key);
//        String url = amazonS3Client.generatePresignedUrl(httpRequest).toString();
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpget = new HttpGet(url);
//        CloseableHttpResponse response = httpclient.execute(httpget);
//        HttpEntity entity = response.getEntity();
//        InputStream input = entity.getContent();
//        return input;
//    }
//
//
//    public void deleteFileFromS3(String key) throws Exception{
//        amazonS3Client.deleteObject(bucket,key);
//    }
//
//
//    public List<String> listFileFromS3() throws Exception{
//        List<String> keys = new ArrayList<>();
//        ObjectListing list = amazonS3Client.listObjects(bucket);
//        for(S3ObjectSummary s3ObjectSummary: list.getObjectSummaries()){
//            keys.add(s3ObjectSummary.getKey());
//        }
//        return keys;
//    }
//
//
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//        //for old version
//        // <dependency>
//        //<groupId>com.amazonaws</groupId>
//        //<artifactId>aws-java-sdk-s3</artifactId>
//        //<!--<version>1.9.6</version>-->
//        // </dependency>
////        AWSCredentials credentials = new BasicAWSCredentials(access, secret);
////
////        ClientConfiguration clientConfig = new ClientConfiguration();
////        clientConfig.setProtocol(Protocol.HTTP);
////
////        amazonS3Client = new AmazonS3Client(credentials, clientConfig);
////        amazonS3Client.setEndpoint(endPoint);
////        amazonS3Client.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
//
//
//
////        for new version
//        ClientConfiguration clientConfig = new ClientConfiguration();
//        clientConfig.setProtocol(Protocol.HTTP);
//        AWSCredentials credentials = new BasicAWSCredentials(access, secret);
//        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(endPoint, "cn-north-1");
//        AmazonS3ClientBuilder amazonS3ClientBuilder = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withClientConfiguration(clientConfig);
//        amazonS3ClientBuilder.withEndpointConfiguration(endpointConfiguration);
//        amazonS3ClientBuilder.withPathStyleAccessEnabled(true);
//        AmazonS3Client amazonS3 = (AmazonS3Client)amazonS3ClientBuilder.build();
//        this.amazonS3Client = amazonS3;
//    }
//}
