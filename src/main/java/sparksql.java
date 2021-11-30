import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.sources.In;
import scala.Int;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class sparksql {


    public static void main(String []args){

        System.setProperty("HADOOP_USER_NAME","root");
        SparkConf sparkConf = new SparkConf().setAppName("Java Spark Hive Example").setMaster("local[2]")
                .set("dfs.ha.namenodes.nameservices","192.168.0.202");

        SparkSession spark = SparkSession
                .builder()
                .config(sparkConf)
                .enableHiveSupport()
                .getOrCreate();


        spark.sql("show databases").show();

        spark.sql("use bigking").show();

        spark.sql("select * from bigking.house_price").show();

        spark.stop();

    }
}
