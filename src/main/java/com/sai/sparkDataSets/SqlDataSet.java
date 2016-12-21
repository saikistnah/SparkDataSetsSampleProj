package com.sai.sparkDataSets;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

import com.sai.sparkDataSets.DTO.User;

public class SqlDataSet {

	public static void main(String[] args) {
		
		SparkConf sparkConf = new SparkConf().setAppName("com.sparkDataset").setMaster("local");
		SparkContext sparkContext = new SparkContext(sparkConf);
		SparkSession sparkSession = new SparkSession(sparkContext);
		SQLContext sQLContext = new SQLContext(sparkSession);
		
		//Dataset<User> ds = sQLContext.read().json("/Users/user/Documents/PersonalPOCs/SparkDataSetsSample/src/test/resources/testTable.json").as(Encoders.bean(User.class));
		
		Dataset<User> ds1 = sQLContext.read().json("/Users/user/Documents/PersonalPOCs/SparkDataSetsSample/src/test/resources/test.json").as(Encoders.bean(User.class));
		//ds.join(ds1).show();
		ds1.groupBy("name").count().show();

	}

}
