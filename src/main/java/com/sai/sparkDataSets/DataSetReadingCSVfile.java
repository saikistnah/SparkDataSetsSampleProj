package com.sai.sparkDataSets;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class DataSetReadingCSVfile {


	public static void main(String[] args) {
		
		SparkConf sparkConf = new SparkConf().setAppName("com.sparkDataset").setMaster("local");
		SparkContext sparkContext = new SparkContext(sparkConf);
		SparkSession sparkSession = new SparkSession(sparkContext);
		SQLContext sQLContext = new SQLContext(sparkSession);
		
		
		Dataset<Row> ds1 = sQLContext.read().format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/Users/user/Documents/PersonalPOCs/SparkDataSetsSample/src/test/resources/Performance_Stat_WithoutLoad.csv");
		Dataset<Row> ds2 = sQLContext.read().format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/Users/user/Documents/PersonalPOCs/SparkDataSetsSample/src/test/resources/Performance_Stat_withLoad30.csv");
		
		//ds1.orderBy(ds1.col(" no of request").desc());
		
		ds1.as("with").join(ds2.as("without"),ds1.col(" No of Thread").equalTo(ds2.col(" No of Thread")),"left").sort(ds1.col(" no of request").desc()).show();
		
		//ds1.groupBy("View").count().orderBy(ds1.col("View").desc()).show();
		//ds2.printSchema();
	}



}
