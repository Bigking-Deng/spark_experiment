import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class sparksql {

    public static void main(String []args){

        System.setProperty("HADOOP_USER_NAME","root");
        SparkConf sparkConf = new SparkConf().setAppName("Java Spark Hive Example").setMaster("local[2]");

        SparkSession spark = SparkSession
                .builder()
                .config(sparkConf)
                .enableHiveSupport()
                .getOrCreate();
        spark.sql("show databases").show();

        spark.sql("select * from bigking.house_price");

        spark.stop();

    }
}
