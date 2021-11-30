import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class SparkRDD {
    public static void main(String []args){
        SparkConf sparkConf = new SparkConf().setAppName("Java Spark Hive Example").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5,6));

        System.out.println(" ");
        JavaRDD rdd1 = rdd.map(w -> new Tuple2<Integer, Integer>(w, 1));
        List<Tuple2> list = rdd1.collect() ;
        int n = list.size();
    }
}
