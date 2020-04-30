package stackoverflow
import org.apache.spark.{SparkConf, SparkContext}

object Main extends App {


    lazy val conf: SparkConf = new SparkConf().setMaster("local").setAppName("StackOverflow")
    lazy val sc: SparkContext = new SparkContext(conf)
    val lines = sc.textFile("src/main/resources/stackoverflow/stackoverflow.csv")
    val raw = StackOverflow.rawPostings(lines)
    println(raw.count())
    val grouped = StackOverflow.groupedPostings(raw)
    println(grouped.count())

}
